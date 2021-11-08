package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import theater.model.Movie;
import theater.service.MovieService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MoviesController {
    @Autowired
    MovieService movieService;

    @RequestMapping("/movies")
    public String getMoviesPage(Model model){
        List<Movie> movies = movieService.getALl();
        List<Movie> moviesOnAir = new ArrayList<>();
        List<Movie> moviesComingSoon = new ArrayList<>();

        for(Movie m : movies){
            if(m.getStatus().equals("on air")){
                moviesOnAir.add(m);
            }else{
                moviesComingSoon.add(m);
            }
        }

        model.addAttribute("moviesOnAir", moviesOnAir);
        model.addAttribute("moviesComingSoon", moviesComingSoon);
        return "movies";
    }
}
