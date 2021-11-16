package cz.vsb.SLI0095_project.repositories;

import cz.vsb.SLI0095_project.entities.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingJPARepository extends CrudRepository<Rating, Long>{

}
