package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Comment;
import ConsomiTounsi.entities.Feedback;
import ConsomiTounsi.entities.Subject;
import ConsomiTounsi.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SubjectManager implements SubjectManagerInterface{

    @Autowired
    SubjectRepository sr;

    @Override
    public List<Subject> retrieveAllSubject() {
        return (List<Subject>) sr.findAll();
    }

    @Override
    public void addSubject(Subject Su) {
        boolean prohibited = false;
        List<String> prohibitedDict = Arrays.asList("barcha", "klem", "khayeb");
        List<String> List = new ArrayList<String>(Arrays.asList(Su.getDescriptionSubject().split("\\s+")));
        for (String word : List ) {
            if (prohibitedDict.contains(word)){ prohibited = true ;}
        }
        if (prohibited == false )
        { Su.setLikesSubject(0);
          Su.setFeaturedSubject(false);
            sr.save(Su);
        }
    }


    @Override
    public void deleteSubject(Long id) {
        sr.deleteById(id);
    }

    @Override
    public void deleteSubject(String id) {
        sr.deleteById(Long.parseLong(id));
    }

    @Override
    public Subject updateSubject(Subject Su) {
        return sr.save(Su);
    }

    @Override
    public Subject FindSubject(Long id) {
        return sr.findById(id).orElse(new Subject());
    }

    @Override
    public Subject FindSubject(String id) {
        return sr.findById(Long.parseLong(id)).orElse(new Subject());
    }

    @Override
    public int addLike(long id) {
        Subject a = sr.findById(id).orElse(new Subject());
        int nb = a.getLikesSubject() + 1;
        return sr.addLike(nb , id) ; }

    @Override
    public void setFeaturedSubjects() {
        int i = 0;
        int MaxLikes=0;
        long idMax = 0 ;
        long id=0;
        List<Subject> ListSubjects = retrieveAllSubject();
        for ( Subject subj : ListSubjects){
            id = subj.getIdSubject();
            sr.NotFeatured(id);
        }
        while(i<3)
        {
        for ( Subject subj : ListSubjects) {
                if ( subj.getLikesSubject() > MaxLikes )
                {
                    MaxLikes = subj.getLikesSubject();
                    idMax = subj.getIdSubject();
                }
            }
            sr.setFeautured(idMax);
            ListSubjects.remove(FindSubject(idMax));
            MaxLikes=0;
            i++;
        }
    }

    @Override
    public List<Subject> getFeaturedSubjects() {
        return sr.getFeaturedSubjects();
    }

}

