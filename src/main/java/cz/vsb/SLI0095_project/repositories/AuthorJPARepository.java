package cz.vsb.SLI0095_project.repositories;


import cz.vsb.SLI0095_project.entities.Author;
import cz.vsb.SLI0095_project.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AuthorJPARepository extends CrudRepository<Author, Long> {

}
