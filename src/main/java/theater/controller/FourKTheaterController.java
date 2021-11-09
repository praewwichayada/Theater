package theater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FourKTheaterController {
    @RequestMapping("/fourktheater")
    public String getThreeDPage() {
        return "fourktheater";
    }
}
