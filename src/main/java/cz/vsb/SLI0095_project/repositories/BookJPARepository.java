package cz.vsb.SLI0095_project.repositories;

import cz.vsb.SLI0095_project.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJPARepository extends CrudRepository<Book, Long> {
}
