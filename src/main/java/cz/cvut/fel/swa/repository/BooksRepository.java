package cz.cvut.fel.swa.repository;

import cz.cvut.fel.swa.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, String> {

    List<Book> findAllByAuthor(@Param("author") Integer author);

    @Query(value = "SELECT * FROM tab_books WHERE title LIKE %:title%", nativeQuery = true)
    List<Book> findAllWithLikeTitle(@Param("title") String title);
}
