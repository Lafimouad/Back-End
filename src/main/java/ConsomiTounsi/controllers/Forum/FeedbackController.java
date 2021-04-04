package ConsomiTounsi.controllers.Forum;

import ConsomiTounsi.Service.FeedbackManagerInterface;
import ConsomiTounsi.entities.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Forum/Feedback")
public class FeedbackController {

    /*{
    "idFeedback": 1,
    "descriptionFeedback": "desc",
    "product": null
}*/

    @Autowired
    FeedbackManagerInterface feedbackS;

    @PostMapping("/add")
    public Feedback addComment(@RequestBody Feedback a){
        Feedback feedback = feedbackS.addFeedback(a);
        return feedback ;}

    @GetMapping("/retrieve-all")
    public List<Feedback> getListFeedback(){
        return feedbackS.retrieveAllFeedback(); }

    @GetMapping("/retrieve-id")
    public Feedback getFeedbackById(@RequestParam("id") long id){
        return feedbackS.FindFeedback(id);
    }

    @DeleteMapping("remove-id")
    public void removeFeedbackByID(@RequestParam("id")long id){
        feedbackS.deleteFeedback(id);
    }

    @PutMapping("/update")
    public Feedback updateFeedback(@RequestBody Feedback a){
        return feedbackS.updateFeedback(a);
    }
}
