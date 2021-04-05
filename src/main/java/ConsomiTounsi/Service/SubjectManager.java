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
        List<String> prohibitedDict = Arrays.asList("fuck", "shit", "bastard", "bitch");
        List<String> List = new ArrayList<String>(Arrays.asList(Su.getDescriptionSubject().split("\\s+")));
        for (String word : List ) {
            if (prohibitedDict.contains(word)){ prohibited = true ;}
        }
        if (prohibited == false )
        { Su.setLikesSubject(0);
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
    public void setFeauturedSubjects() {
        int i = 0;
        int MaxLikes=0;
        long idMax = 0 ;
        List<Subject> ListSubjects = retrieveAllSubject();
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
    public List<Subject> getFeautredSubjects() {
        return sr.getFeaturedSubjects();
    }

}

