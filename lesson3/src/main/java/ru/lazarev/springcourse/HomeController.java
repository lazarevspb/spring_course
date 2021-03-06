package ru.lazarev.springcourse;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /* https://www.baeldung.com/jackson-object-mapper-tutorial */
    @GetMapping("/json")
    public ObjectMapper getJson(){
        JsonFactory jf = ;
        ObjectMapper json= new ObjectMapper(jf);
        return json;
    }

}
