package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.entities.Role;
import ConsomiTounsi.entities.Shelf;
import ConsomiTounsi.entities.typeShelf;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepository extends CrudRepository<Shelf,Long> {
	
	 /*List<Shelf> FindByTypeShelf(typeShelf type);*/


	/*@Query(value="SELECT s FROM shelf s WHERE s.type_shelf=:type",nativeQuery = true)
	Shelf FindByTypeShelf(String type);*/


	@Query("SELECT e FROM Shelf e WHERE e.typeShelf=:type")
	Shelf FindByTypeShelf(@Param("type") String type);


    @Query(value="SELECT id_shelf FROM shelf WHERE type_shelf=:type)",nativeQuery = true)
	long selectIdshelfbytype(@Param("type") String type);


}
