package com.zerobase.fastlms.main.controller;


import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.service.BannerService;
import com.zerobase.fastlms.components.MailComponents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final BannerService bannerService;

    @RequestMapping("/")
    public String index(Model model) {
        List<BannerDto> list = bannerService.frontList();

        model.addAttribute("list", list);


        return "index";
    }

    @RequestMapping("/error/denied")
    public String errorDenied() {
        return "error/denied";
    }

}
