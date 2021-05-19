package ConsomiTounsi.controllers.Forum;

import ConsomiTounsi.Service.SubjectManagerInterface;
import ConsomiTounsi.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Forum/Subject")
public class SubjectController {

    /*{
    "descriptionSubject": null,
}*/

    @Autowired
    SubjectManagerInterface subjectS;

    @PostMapping("/add")
    public void addSubject(@RequestBody Subject a){
        subjectS.addSubject(a);}

    @GetMapping("/retrieve-all")
    @CrossOrigin(origins = "*")
    public List<Subject> getListSubjects(){
        return subjectS.retrieveAllSubject(); }

    @GetMapping("/retrieve-id/{id}")
    public Subject getSubjectById(@PathVariable("id") long id){
        return subjectS.FindSubject(id);
    }

    @DeleteMapping("remove-id/{id}")
    public void removeSubjectByID(@PathVariable("id")long id){
        subjectS.deleteSubject(id);
    }

    @PutMapping("/update")
    public Subject updateSubject(@RequestBody Subject a){
        return subjectS.updateSubject(a);
    }

    @PutMapping("/likeSubject-id/{id}")
    public void addLike(@PathVariable("id") long id){subjectS.addLike(id);}

    @PutMapping("/dislikeSubject-id/{id}")
    public void dislike(@PathVariable("id") long id){subjectS.dislike(id);}

    @PutMapping("/setFeauturedSubjects")
    public void FeatureSubjects(){
        subjectS.setFeaturedSubjects();
    }

    @GetMapping("/getFeaturedSubjects")
    public List<Subject> ListFeaturedSubjects(){
        return subjectS.getFeaturedSubjects();
    }

    @GetMapping("/getWordFilteredSubjects")
    public List<Subject> FilterByWords(@RequestParam("word")String word){
//    public List<String> FilterByWords(@RequestParam("word")String word){
        return subjectS.FilterByWords(word);
    }

    @GetMapping("/getLikesFilteredSubjects/{minLikes}/{maxLikes}")
    public List<Subject> FilterByNbLikes(@PathVariable("minLikes")String minLikes, @PathVariable("maxLikes")String maxLikes){
        return subjectS.FilterByNbLikes(minLikes, maxLikes);
    }

    @GetMapping("/getFilteredSubjects")
    public List<Subject> Filter(@RequestParam("word")String word , @RequestParam("minLikes")String minLikes, @RequestParam("maxLikes")String maxLikes){
        return subjectS.Filter(word , minLikes, maxLikes);
    }
}

