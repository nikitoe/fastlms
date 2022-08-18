package com.zerobase.fastlms.course.controller;

import com.zerobase.fastlms.admin.model.MemberParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdminCourseController {

    @GetMapping("/admin/course/list.do")
    public String list(Model model, MemberParam parameter) {

        return "admin/course/list";
    }
}
