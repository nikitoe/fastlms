package com.zerobase.fastlms.configuration;

import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.entity.MemberLoginHistory;
import com.zerobase.fastlms.member.repository.MemberLoginHistoryRepository;
import com.zerobase.fastlms.member.repository.MemberRepository;
import com.zerobase.fastlms.member.service.MemberService;
import com.zerobase.fastlms.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class UserAuthenticationSuccessHandler
        extends SimpleUrlAuthenticationSuccessHandler {

    private final MemberRepository memberRepository;
    private final MemberLoginHistoryRepository memberLoginHistoryRepository;


    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException {

        // 접속한 유저 아이디(이메일) 가져오기
        String userId = authentication.getName();

        // 접속한 유저 아이디 세션 값 저장
        HttpSession session = request.getSession();
        session.setAttribute("userId", userId + "님 반갑습니다.");

        // 접속한 유저 로그인 일시 저장
        Optional<Member> optionalMember =  memberRepository.findById(userId);
        if(optionalMember.isPresent()){
            Member member = optionalMember.get();
            member.setLastLoginDt(LocalDateTime.now());
            memberRepository.save(member);
        }

        // userAgent, ip 정보 가져오기
        String userAgent = RequestUtils.getUserAgent(request);
        String ipAddr = RequestUtils.getIpAddr(request);

        // 사용자 로그인 히스토리 정보 저장하기
        memberLoginHistoryRepository.save(
                MemberLoginHistory.builder()
                        .loginDt(LocalDateTime.now())
                        .ipAddr(ipAddr)
                        .userAgent(userAgent)
                        .userId(userId)
                        .build());

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
