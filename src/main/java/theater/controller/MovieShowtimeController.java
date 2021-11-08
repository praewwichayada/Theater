package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import theater.service.MovieService;
import theater.service.PlaceService;
import theater.service.ShowTimeService;

import java.util.UUID;

@Controller
public class MovieShowtimeController {
    @Autowired
    MovieService movieService;

    @Autowired
    PlaceService placeService;

    @Autowired
    ShowTimeService showTimeService;

    @RequestMapping("movies/{id}")
    public String getMovieShowtimePage(@PathVariable UUID id,Model model){
        model.addAttribute("movie", movieService.getMovie(id));
        model.addAttribute("places", placeService.getALl());
        model.addAttribute("showtimes", showTimeService.getALl());
        return "movieshowtime";
    }




}
