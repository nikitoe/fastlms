package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public boolean register(MemberInput memberInput) {

        Member member = new Member();
        member.setUserId(memberInput.getUserId());
        member.setUserName(memberInput.getUserName());
        member.setPassword(memberInput.getPassword());
        member.setPhone(memberInput.getPhone());
        member.setRegDt(LocalDateTime.now());
        memberRepository.save(member);

        return false;
    }
}
