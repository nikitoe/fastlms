package com.zerobase.fastlms.course.controller;

import com.zerobase.fastlms.admin.service.CategoryService;
import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.model.CourseParam;
import com.zerobase.fastlms.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CourseController extends BaseController {

    private final CourseService courseService;
    private final CategoryService categoryService;


    @GetMapping("/course")
    public String course(Model model, CourseParam parameter) {

        List<CourseDto> list = courseService.frontList(parameter);
        model.addAttribute("list", list);

        return "course/index";
    }


}