package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import theater.model.Movie;
import theater.service.MovieService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    MovieService movieService;

    @RequestMapping("/")
    public String getHomePage(Model model){
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
        return "home";
    }
}

