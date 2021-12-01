package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.Book;
import cz.vsb.SLI0095_project.entities.Rating;
import cz.vsb.SLI0095_project.repositories.BookJPARepository;
import cz.vsb.SLI0095_project.repositories.RatingJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@ConditionalOnProperty(
        value="accessType",
        havingValue = "jpa",
        matchIfMissing = true)
public class BookJPAService implements BookService{

    @Autowired
    private BookJPARepository bookJPARepository;
    @Autowired
    private RatingJPARepository ratingJPARepository;

    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        Iterable<Book> iterator = bookJPARepository.findAll();
        for(Book b : iterator){
            books.add(b);
        }
        return books;
    }

    @Transactional
    public void saveBook(Book book){
        if(book.getBookId() == 0){
            bookJPARepository.save(book);
        }
        else if (book.getBookId() > 0){
            if(bookJPARepository.existsById(book.getBookId()))
            {
                bookJPARepository.save(book);
            }
        }
    }

    public Book getBookById(long id){
        Optional<Book> bookData = bookJPARepository.findById(id);
        if(bookData.isPresent())
        {
            return bookData.get();
        }
        else return null;
    }

    @Transactional
    public void deleteBook(Book book){
        if(bookJPARepository.existsById(book.getBookId())){
            for(Rating rating: book.getRatings()){
                ratingJPARepository.delete(rating);
            }
            bookJPARepository.delete(book);
        }
    }
}
