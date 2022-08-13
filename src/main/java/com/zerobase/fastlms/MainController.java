package com.zerobase.fastlms;


import com.zerobase.fastlms.components.MailComponents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MailComponents mailComponents;

    @RequestMapping("/")
    public String index() {

        String email = "simzzangn1@naver.com";
        String subject = "안녕하세요. 지투더용 입니다.";
        String text = "<p>반갑습니다.</p>";

        mailComponents.sendMail(email, subject, text);

        return "index";
    }

}
