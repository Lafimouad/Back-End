package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback,Long> {
}
