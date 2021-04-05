package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {

    @Query(value= "SELECT c FROM comment c WHERE c.most_pertinat_comment= TRUE AND c.subject_id_subject=:id ",nativeQuery= true)
    List<Comment> retrievePertinentCommentsBySubject(@Param("id") long id);

    @Query(value= "SELECT c FROM comment c WHERE c.subject_id_subject=:id ",nativeQuery= true)
    List<Comment> retrieveSubjectComments(@Param("id") long id);

    @Modifying
    @Query(value="UPDATE comment c SET c.likes_comment=:nb WHERE c.id_comment=:id",nativeQuery= true)
    int addLike(@Param("nb") int nb , @Param("id") long id);

    @Modifying
    @Query(value="UPDATE comment c SET c.most_pertinat_comment = TRUE WHERE c.id_comment=:id",nativeQuery= true)
    int setPertinentComment(@Param("id") long id);

}
