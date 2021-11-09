package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import theater.service.*;

import java.util.UUID;

@Controller
public class ThreeDTheaterController {
    @Autowired
    MovieService movieService;

    @Autowired
    PlaceService placeService;

    @Autowired
    CinemaService cinemaService;

    @Autowired
    ShowTimeService showTimeService;

    @Autowired
    PromotionService promotionService;

    @RequestMapping("/threedtheater/{movieID}/{placeID}/{cinemaID}/{showTimeID}")
    public String getThreeDPage(@PathVariable UUID movieID,@PathVariable UUID placeID,@PathVariable UUID cinemaID,@PathVariable UUID showTimeID, Model model) {
        model.addAttribute("movie", movieService.getMovie(movieID));
        model.addAttribute("place", placeService.getPlace(placeID));
        model.addAttribute("cinema", cinemaService.getCinema(cinemaID));
        model.addAttribute("showTime", showTimeService.getShowTime(showTimeID));
        return "threedtheater";
    }

//    @RequestMapping("/threedtheater/{promotionID}")
//    public String getCodePromotion(@PathVariable UUID promotionID,Model model) {
//        public String code(@RequestParam(value = ))
//        model.addAttribute("code", promotionService.getCode(promotionID);
//        return ;
//    }
}
