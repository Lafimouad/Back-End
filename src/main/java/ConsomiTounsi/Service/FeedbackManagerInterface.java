package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Feedback;
import ConsomiTounsi.entities.Message;

import java.util.List;
import java.util.Optional;

public interface FeedbackManagerInterface {
    List<Feedback> retrieveAllFeedback();
    Feedback addFeedback(Feedback M);
    void deleteFeedback(Long id);
    void deleteFeedback(String id);
    Feedback updateFeedback(Feedback M);
    Feedback FindFeedback(Long id);
    Feedback FindFeedback(String id);
}
