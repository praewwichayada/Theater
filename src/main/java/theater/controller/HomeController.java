package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import theater.model.Movie;
import theater.service.MovieService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    MovieService movieService;

    @RequestMapping("/")
    public String getHomePage(Model model) throws MalformedURLException {
        List<Movie> movies = movieService.getALl();
        model.addAttribute("movie1", new URL(movies.get(0).getImage()));
        return "home";
    }

    @RequestMapping("/movies")
    public String getMoviesPage() {
        return "movies";
    }

}

