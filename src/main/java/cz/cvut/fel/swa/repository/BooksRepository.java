package cz.cvut.fel.swa.repository;

import cz.cvut.fel.swa.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query(value = "SELECT * FROM tab_books WHERE title LIKE %:title%", nativeQuery = true)
    Page<Book> findAllWithLikeTitle(@Param("title") String title, Pageable pageable);

    @Query(value = "SELECT * FROM tab_books", nativeQuery = true)
    Page<Book> findAll(Pageable pageable);
}
