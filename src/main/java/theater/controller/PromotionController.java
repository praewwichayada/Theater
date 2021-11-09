package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import theater.model.Movie;
import theater.model.Promotion;
import theater.service.PromotionService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PromotionController {

    @Autowired
    PromotionService promotionService;

    @RequestMapping("/promotion")
    public String getPromotionPage(Model model) {
        List<Promotion> promotions = promotionService.getALl();
        model.addAttribute("promotions", promotions);
        return "promotion";
    }
}
