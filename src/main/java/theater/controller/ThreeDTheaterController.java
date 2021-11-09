package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
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
    public String getThreeDPage(@PathVariable UUID movieID,@PathVariable UUID placeID,@PathVariable UUID cinemaID,@PathVariable UUID showTimeID, Model model, @AuthenticationPrincipal OAuth2User principal) {
        model.addAttribute("movie", movieService.getMovie(movieID));
        model.addAttribute("place", placeService.getPlace(placeID));
        model.addAttribute("cinema", cinemaService.getCinema(cinemaID));
        model.addAttribute("showTime", showTimeService.getShowTime(showTimeID));

        model.addAttribute("user", principal.getAttribute("email"));

        return "threedtheater";
    }

//    @RequestMapping("/threedtheater/{promotionID}")
//    public String getCodePromotion(@PathVariable UUID promotionID,Model model) {
//        public String code(@RequestParam(value = ))
//        model.addAttribute("code", promotionService.getCode(promotionID);
//        return ;
//    }
}
