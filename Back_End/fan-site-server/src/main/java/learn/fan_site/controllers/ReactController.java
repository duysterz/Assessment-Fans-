package learn.fan_site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
public class ReactController {
    @RequestMapping(value = "/")
    public String index() {
        return "Front_End/public/index.html";
    }
}

