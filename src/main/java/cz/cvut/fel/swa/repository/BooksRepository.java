package cz.cvut.fel.swa.repository;

import cz.cvut.fel.swa.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, String> {

    /*@Query("SELECT b FROM tab_books b WHERE b.author = :author")
    List<Book> findByAuthor(@Param("author") Integer author);*/
}
