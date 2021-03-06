package ru.lazarev.springcourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/json/get")
    public String getJson() {
        return "json";
    }

    @GetMapping("xml/get")
    public String getXML() {
        return "xml";
    }


}