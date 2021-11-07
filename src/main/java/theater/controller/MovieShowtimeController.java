package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.PathContainer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/{id}")
    public String getMovieShowtimePage(@PathVariable UUID id,Model model){
        model.addAttribute("movie", movieService.getMovie(id));
        return "movieshowtime";
    }
}
