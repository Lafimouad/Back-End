package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {
    @Query("SELECT c FROM Comment c WHERE c.mostPertinentComment= TRUE")
    List<Comment> retrieveCommentByPertinence(@Param("mostPertinentComment") boolean mostPertinentComment);

}
