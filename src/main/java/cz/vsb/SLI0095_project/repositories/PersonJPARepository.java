package cz.vsb.SLI0095_project.repositories;

import cz.vsb.SLI0095_project.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@NoRepositoryBean
public interface PersonJPARepository extends CrudRepository<Person, Long> {

}
