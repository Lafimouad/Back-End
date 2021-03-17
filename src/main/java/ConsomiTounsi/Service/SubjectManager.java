package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Subject;

import java.util.List;
import java.util.Optional;

public class SubjectManager implements SubjectManagerInterface{
    @Override
    public List<Subject> retrieveAllSubject() {
        return null;
    }

    @Override
    public Subject addSubject(Subject Su) {
        return null;
    }

    @Override
    public void deleteSubject(Long id) {

    }

    @Override
    public void deleteSubject(String id) {

    }

    @Override
    public Subject updateSubject(Subject Su) {
        return null;
    }

    @Override
    public Optional<Subject> FindSubject(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Subject> FindSubject(String id) {
        return Optional.empty();
    }
}
