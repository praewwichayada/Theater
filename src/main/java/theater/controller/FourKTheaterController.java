package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import theater.service.CinemaService;
import theater.service.MovieService;
import theater.service.PlaceService;
import theater.service.ShowTimeService;

import java.util.UUID;

@Controller
public class FourKTheaterController {
    @Autowired
    MovieService movieService;

    @Autowired
    PlaceService placeService;

    @Autowired
    CinemaService cinemaService;

    @Autowired
    ShowTimeService showTimeService;

    @RequestMapping("/fourktheater/{movieID}/{placeID}/{cinemaID}/{showTimeID}")
    public String getThreeDPage(@PathVariable UUID movieID, @PathVariable UUID placeID, @PathVariable UUID cinemaID, @PathVariable UUID showTimeID, Model model) {
        model.addAttribute("movie", movieService.getMovie(movieID));
        model.addAttribute("place", placeService.getPlace(placeID));
        model.addAttribute("cinema", cinemaService.getCinema(cinemaID));
        model.addAttribute("showTime", showTimeService.getShowTime(showTimeID));
        return "fourktheater";
    }
}
