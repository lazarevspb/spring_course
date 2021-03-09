package ru.lazarev.springcourse.comtrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String homePage() {
        return "home/main";
    }

    @GetMapping("/data")
    public String dataPage() {
        return "data/main";
    }

}
