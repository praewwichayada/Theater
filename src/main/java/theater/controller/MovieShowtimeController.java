package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.PathContainer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import theater.model.Movie;
import theater.service.MovieService;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.UUID;

@Controller
public class MovieShowtimeController {
    @Autowired
    MovieService movieService;

    @RequestMapping("/movieshowtime")
    public String getMovieShowtimePage(Model model) throws MalformedURLException {
        Movie movie = movieService.getMovie(UUID.fromString("1266887f-426e-47ec-807d-bc68be429e65"));
        model.addAttribute("movieImage", new URL(movie.getImage()));
        model.addAttribute("movieName", movie.getName());
        model.addAttribute("moviePeriod", movie.getPeriod() + " นาที");
        model.addAttribute("movieDescription", movie.getDescription());
        return "movieshowtime";
    }
}
