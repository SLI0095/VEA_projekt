package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.Book;
import cz.vsb.SLI0095_project.repositories.BookJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookJPARepository bookJPARepository;

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

    public void deleteBook(Book book){
        if(bookJPARepository.existsById(book.getBookId())){
            bookJPARepository.delete(book);
        }
    }
}
