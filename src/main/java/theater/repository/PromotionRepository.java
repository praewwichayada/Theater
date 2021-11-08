package theater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import theater.model.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, String> {
}
