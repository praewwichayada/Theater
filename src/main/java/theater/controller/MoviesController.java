package theater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MoviesController {
    @RequestMapping("/movies")
    public String getMoviesPage() {
        return "movies";
    }
}
