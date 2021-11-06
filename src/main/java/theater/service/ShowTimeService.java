package theater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import theater.model.ShowTime;
import theater.repository.ShowTimeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ShowTimeService {
    @Autowired
    private ShowTimeRepository showTimeRepository;

    public List<ShowTime> getALl(){
        return showTimeRepository.findAll();
    }

    public ShowTime getShowTime(UUID id){
        return showTimeRepository.findById(id).get();
    }

    public ShowTime create(ShowTime showTime){
        showTimeRepository.save(showTime);
        return showTime;
    }

    public ShowTime delete(UUID id){
        ShowTime record = showTimeRepository.findById(id).get();
        showTimeRepository.deleteById(id);
        return record;
    }
}
