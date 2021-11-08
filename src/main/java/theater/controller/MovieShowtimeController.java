package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import theater.model.Cinema;
import theater.model.ShowTime;
import theater.service.CinemaService;
import theater.service.MovieService;
import theater.service.PlaceService;
import theater.service.ShowTimeService;

import java.util.*;

@Controller
public class MovieShowtimeController {
    @Autowired
    MovieService movieService;

    @Autowired
    PlaceService placeService;

    @Autowired
    CinemaService cinemaService;

    @Autowired
    ShowTimeService showTimeService;

    @RequestMapping("movies/{id}")
    public String getMovieShowtimePage(@PathVariable UUID id,Model model){
        model.addAttribute("movie", movieService.getMovie(id));

        List<Cinema> cinemaList = cinemaService.getALl();
        Collections.sort(cinemaList, new Comparator<Cinema>() {
            @Override
            public int compare(Cinema o1, Cinema o2) {
                return o1.getNumber().compareTo(o2.getNumber());
            }
        });
        model.addAttribute("cinemas", cinemaList);

        model.addAttribute("places", placeService.getALl());


        List<ShowTime> showTimeList = showTimeService.getALl();
        Collections.sort(showTimeList, new Comparator<ShowTime>() {
            @Override
            public int compare(ShowTime o1, ShowTime o2) {
                return o1.getDateTime().compareTo(o2.getDateTime());
            }
        });
        model.addAttribute("showtimes", showTimeList);

        return "movieshowtime";
    }




}
