package au.com.riosoftware.services;

import au.com.riosoftware.domain.Book;
import au.com.riosoftware.domain.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> getAll(){
         return bookRepository.findAll();

    }

    public Book newBook(Book book){
        return bookRepository.save(book);

    }

    public Book findOne(long id){
        return bookRepository.findOne(id);
    }

    public void delete(long id){
        bookRepository.delete(id);
    }

}
