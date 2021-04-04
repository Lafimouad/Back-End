package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Feedback;
import ConsomiTounsi.entities.Subject;
import ConsomiTounsi.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectManager implements SubjectManagerInterface{
    @Autowired
    SubjectRepository sr;

    @Override
    public List<Subject> retrieveAllSubject() {
        return (List<Subject>) sr.findAll();
    }

    @Override
    public Subject addSubject(Subject Su) {
        return sr.save(Su);
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
}
