package theater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import theater.model.Promotion;
import theater.repository.PromotionRepository;

import java.util.List;

@Service
public class PromotionService {
    @Autowired
    PromotionRepository promotionRepository;

    public List<Promotion> getALl(){
        return promotionRepository.findAll();
    }

    public Promotion getPromotion(String code){
        return promotionRepository.findById(code).get();
    }

    public Promotion create(Promotion promotion){
        promotionRepository.save(promotion);
        return promotion;
    }

    public Promotion delete(String code){
        Promotion record = promotionRepository.findById(code).get();
        promotionRepository.deleteById(code);
        return record;
    }
}
