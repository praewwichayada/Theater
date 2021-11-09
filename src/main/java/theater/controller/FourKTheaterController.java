package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import theater.model.Promotion;
import theater.model.ShowTime;
import theater.service.*;

import java.util.List;
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

    @Autowired
    PromotionService promotionService;

    @RequestMapping("/fourktheater/{movieID}/{placeID}/{cinemaID}/{showTimeID}")
    public String getFourKPage(@PathVariable UUID movieID, @PathVariable UUID placeID, @PathVariable UUID cinemaID, @PathVariable UUID showTimeID, Model model) {
        model.addAttribute("movie", movieService.getMovie(movieID));
        model.addAttribute("place", placeService.getPlace(placeID));
        model.addAttribute("cinema", cinemaService.getCinema(cinemaID));

        ShowTime showTime = showTimeService.getShowTime(showTimeID);
        model.addAttribute("showTime", showTime);

        model.addAttribute("finalPrice", showTime.getPrice());

        return "fourktheater";
    }

    @RequestMapping("/fourktheater/{movieID}/{placeID}/{cinemaID}/{showTimeID}/{code}")
    public String getFourKWithPromotionPage(@PathVariable UUID movieID, @PathVariable UUID placeID, @PathVariable UUID cinemaID, @PathVariable UUID showTimeID, @PathVariable String code, Model model) {

        ShowTime showTime = showTimeService.getShowTime(showTimeID);
        List<Promotion> promotions = promotionService.getALl();
        Promotion promotion = null;
        for(Promotion p : promotions){
            if(p.getCode().equals(code)){
                promotion = p;
                break;
            }
        }

        if(promotion != null){
            model.addAttribute("finalPrice", showTime.getPrice() - promotion.getDiscount());
            model.addAttribute("discount", promotion.getDiscount());
            model.addAttribute("status", "succeed");
        }else{
            model.addAttribute("status", "fail");
            return "redirect:/fourktheater/" + movieID + "/" + placeID + "/" + cinemaID + "/" + showTimeID;
        }

        model.addAttribute("movie", movieService.getMovie(movieID));
        model.addAttribute("place", placeService.getPlace(placeID));
        model.addAttribute("cinema", cinemaService.getCinema(cinemaID));
        model.addAttribute("showTime", showTime);

        model.addAttribute("code", code);

        return "fourktheater";
    }
}
