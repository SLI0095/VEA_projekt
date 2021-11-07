package cz.vsb.SLI0095_project.repositories;

import cz.vsb.SLI0095_project.entities.Person;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PersonJPARepository {

    @PersistenceContext
    private EntityManager em;

    public List<Person> getAllPersons(){
        return em.createQuery("Select p from Person p", Person.class).getResultList();
    }

    @Transactional
    public void savePerson(Person person){
        if(person.getId() == 0){
            em.persist(person);
        } else {
            em.merge(person);
        }
    }

}
