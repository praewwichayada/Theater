package theater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieShowtimeController {

    @RequestMapping("/movieshowtime")
    public String getMovieShowtimePage() {
        return "movieshowtime";
    }
}
