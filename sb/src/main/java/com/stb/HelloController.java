package com.stb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello () {
        return "안녕하세요";
    }
    @GetMapping("/")
    public String root() {
        return "redirect:/question/list2";
    }
}
