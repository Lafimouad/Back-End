package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectManagerInterface {
    List<Subject> retrieveAllSubject();
    Subject addSubject(Subject Su);
    void deleteSubject(Long id);
    void deleteSubject(String id);
    Subject updateSubject(Subject Su);
    Optional<Subject> FindSubject(Long id);
    Optional<Subject> FindSubject(String id);
}
