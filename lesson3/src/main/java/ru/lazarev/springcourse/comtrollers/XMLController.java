package ru.lazarev.springcourse.comtrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class XMLController {
    @GetMapping("xml/get")
    public String getXML() {
        return "xml";
    }
}