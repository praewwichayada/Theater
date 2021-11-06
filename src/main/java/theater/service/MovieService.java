package theater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import theater.model.Movie;
import theater.repository.MovieRepository;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getALl(){
        return movieRepository.findAll();
    }

    public Movie getMovie(UUID id){
        return movieRepository.findById(id).get();
    }

    public Movie create(Movie movie){
        movieRepository.save(movie);
        return movie;
    }

    public Movie delete(UUID id){
        Movie record = movieRepository.findById(id).get();
        movieRepository.deleteById(id);
        return record;
    }
}