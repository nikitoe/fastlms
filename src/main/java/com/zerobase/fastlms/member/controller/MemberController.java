package com.zerobase.fastlms.member.controller;

import com.zerobase.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    //@RequestMapping(value = "/member/register", method = RequestMethod.GET)
    @GetMapping("/member/register")
    public String register() {

        return "member/register";
    }

    //@RequestMapping(value = "/member/register", method = RequestMethod.POST)
    @PostMapping("/member/register")
    public String registerSubmit(Model model,
                                 MemberInput parameter
    ) {

        boolean result = memberService.register(parameter);
        model.addAttribute("result",result);


        return "/member/register_complete";
    }

}
