package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event,Long> {
   // @Query(value = "DELETE * FROM event WHERE id_event = ?1",nativeQuery = true)
   // public void deleteeventbyid(long id);

    @Query("SELECT e FROM Event e WHERE e.id_event=:id")
    public void deleteeventbyid(@Param("id") long id);

}
