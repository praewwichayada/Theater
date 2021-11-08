package theater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import theater.model.Place;
import theater.repository.PlaceRepository;

import java.util.List;
import java.util.UUID;

@Service
public class PlaceService {
    @Autowired
    PlaceRepository placeRepository;

    public List<Place> getALl(){
        return placeRepository.findAll();
    }

    public Place getPlace(UUID id){
        return placeRepository.findById(id).get();
    }

    public Place create(Place place){
        placeRepository.save(place);
        return place;
    }

    public Place delete(UUID id){
        Place record = placeRepository.findById(id).get();
        placeRepository.deleteById(id);
        return record;
    }
}
