package au.com.riosoftware.domain.repositories;


import au.com.riosoftware.domain.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BooksRepository extends CrudRepository<Books,Long> {
}
