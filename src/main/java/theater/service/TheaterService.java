package theater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import theater.model.Theater;
import theater.repository.TheaterRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TheaterService {
    @Autowired
    TheaterRepository theaterRepository;

    public List<Theater> getALl(){
        return theaterRepository.findAll();
    }

    public Theater getPromotion(UUID id){
        return theaterRepository.findById(id).get();
    }

    public Theater create(Theater theater){
        theaterRepository.save(theater);
        return theater;
    }

    public Theater delete(UUID id){
        Theater record = theaterRepository.findById(id).get();
        theaterRepository.deleteById(id);
        return record;
    }
}
