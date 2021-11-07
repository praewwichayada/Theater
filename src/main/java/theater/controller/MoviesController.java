package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import theater.model.Movie;
import theater.service.MovieService;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/MovieManagement")
public class MoviesController {
    @Autowired
    MovieService movieService;

    @GetMapping
    public List<Movie> getAll(){
        return movieService.getALl();
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        return movieService.create(movie);
    }

    @DeleteMapping("/{id}")
    public Movie delete(@PathVariable UUID id) {
        return movieService.delete(id);
    }
}
