package au.com.riosoftware.services;


import au.com.riosoftware.domain.Book;
import au.com.riosoftware.domain.repositories.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;




public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void shouldAddBook(){
        Book book = new Book();
        book.setName("Java");
        book.setAuthor("Marcio");

        Book expectedBook = new Book();
        expectedBook.setId(1);
        expectedBook.setName("Java");
        expectedBook.setAuthor("Marcio");


        when(bookRepository.save(book)).thenReturn(expectedBook);

        Book receivedBook = bookService.newBook(book);

        assertThat(receivedBook, is(expectedBook));
    }


    @Test
    public void shouldDeleteBook(){
        Book book = new Book();
        book.setName("Java");
        book.setAuthor("Marcio");

        Book expectedBook = new Book();
        expectedBook.setId(1);
        expectedBook.setName("Java");
        expectedBook.setAuthor("Marcio");

        when(bookRepository.save(book)).thenReturn(expectedBook);

        bookService.delete(1);

        assertThat(bookService.findOne(1),is(isNull()));


    }
}
