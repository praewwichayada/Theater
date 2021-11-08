package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import theater.model.*;
import theater.service.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/database")
public class DatabaseController {

    //Cinemas Controller
    @Autowired
    CinemaService cinemaService;

    @GetMapping("/cinema")
    public List<Cinema> getAllCinemas(){
        return cinemaService.getALl();
    }

    @PostMapping("/cinema/add")
    public Cinema createCinema(@RequestBody Cinema cinema) {
        return cinemaService.create(cinema);
    }

    @DeleteMapping("/cinema/delete/{id}")
    public Cinema deleteCinema(@PathVariable UUID id) {
        return cinemaService.delete(id);
    }



    //Movie Controller
    @Autowired
    MovieService movieService;

    @GetMapping("/movie")
    public List<Movie> getAllMovies(){
        return movieService.getALl();
    }

    @PostMapping("/movie/add")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.create(movie);
    }

    @DeleteMapping("/movie/delete/{id}")
    public Movie deleteMovie(@PathVariable UUID id) {
        return movieService.delete(id);
    }



    //Promotion Controller
    @Autowired
    PromotionService promotionService;

    @GetMapping("/promotion")
    public List<Promotion> getAllPromotions(){
        return promotionService.getALl();
    }

    @PostMapping("/promotion/add")
    public Promotion createPromotion(@RequestBody Promotion promotion) {
        return promotionService.create(promotion);
    }

    @DeleteMapping("/promotion/delete/{id}")
    public Promotion deletePromotion(@PathVariable String code) {
        return promotionService.delete(code);
    }



    //Show Time Controller
    @Autowired
    ShowTimeService showTimeService;

    @GetMapping("/showTime")
    public List<ShowTime> getAllShowTimes(){
        return showTimeService.getALl();
    }

    @PostMapping("/showTime/add")
    public ShowTime createShowTime(@RequestBody ShowTime showTime) {
        return showTimeService.create(showTime);
    }

    @DeleteMapping("/showTime/delete/{id}")
    public ShowTime deleteShowTime(@PathVariable UUID id) {
        return showTimeService.delete(id);
    }



    //Theater Controller
    @Autowired
    TheaterService theaterService;

    @GetMapping("/theater")
    public List<Theater> getAllTheaters(){
        return theaterService.getALl();
    }

    @PostMapping("/theater/add")
    public Theater createTheater(@RequestBody Theater theater) {
        return theaterService.create(theater);
    }

    @DeleteMapping("/theater/delete/{id}")
    public Theater deleteTheater(@PathVariable UUID id) {
        return theaterService.delete(id);
    }



    //Ticket Controller
    @Autowired
    TicketService ticketService;

    @GetMapping("/ticket")
    public List<Ticket> getAllTickets(){
        return ticketService.getALl();
    }

    @PostMapping("/ticket/add")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.create(ticket);
    }

    @DeleteMapping("/ticket/delete/{id}")
    public Ticket deleteTicket(@PathVariable UUID id) {
        return ticketService.delete(id);
    }



    //User Controller
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userService.getALl();
    }

    @PostMapping("/user/add")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @DeleteMapping("/user/delete/{id}")
    public User deleteUser(@PathVariable String email) {
        return userService.delete(email);
    }
}
