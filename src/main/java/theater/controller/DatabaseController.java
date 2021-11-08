package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import theater.model.Cinema;
import theater.model.Movie;
import theater.service.CinemaService;
import theater.service.MovieService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/database")
public class DatabaseController {

    //Cinemas Controller
    @Autowired
    CinemaService cinemaService;

    @GetMapping("/movie")
    public List<Cinema> getAllCinemas(){
        return cinemaService.getALl();
    }

    @PostMapping("/movie/add")
    public Cinema createCinema(@RequestBody Cinema cinema) {
        return cinemaService.create(cinema);
    }

    @DeleteMapping("/movie/delete/{id}")
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
}
