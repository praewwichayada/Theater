package theater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CinemasController {

    @RequestMapping("/cinemas")
    public String getCinemasPage() {
        return "cinemas";
    }
}
