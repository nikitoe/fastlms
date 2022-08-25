package com.zerobase.fastlms.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Component
@RequiredArgsConstructor
public class UserAuthenticationSuccessHandler
        extends SimpleUrlAuthenticationSuccessHandler {



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
        session.setAttribute("userId", userId +"님 반갑습니다.");




        super.onAuthenticationSuccess(request, response, authentication);
    }
}
