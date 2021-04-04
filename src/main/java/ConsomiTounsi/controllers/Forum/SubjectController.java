package ConsomiTounsi.controllers.Forum;

import ConsomiTounsi.Service.SubjectManagerInterface;
import ConsomiTounsi.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Forum/Subject")
public class SubjectController {

    /*{
    "idSubject": 1,
    "redendantSubject": false,
    "featuredSubject": false,
    "descriptionSubject": null,
    "likesSubject": 2,
    "user": null,
    "comment": null
}*/

    @Autowired
    SubjectManagerInterface subjectS;

    @PostMapping("/add")
    public Subject addComment(@RequestBody Subject a){
        Subject subject = subjectS.addSubject(a);
        return subject ;}

    @GetMapping("/retrieve-all")
    public List<Subject> getListSubjects(){
        return subjectS.retrieveAllSubject(); }

    @GetMapping("/retrieve-id")
    public Subject getSubjectById(@RequestParam("id") long id){
        return subjectS.FindSubject(id);
    }

    @DeleteMapping("remove-id")
    public void removeSubjectByID(@RequestParam("id")long id){
        subjectS.deleteSubject(id);
    }

    @PutMapping("/update")
    public Subject updateSubject(@RequestBody Subject a){
        return subjectS.updateSubject(a);
    }
}
