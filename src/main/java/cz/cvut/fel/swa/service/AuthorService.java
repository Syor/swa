package cz.cvut.fel.swa.service;

import cz.cvut.fel.swa.models.Author;
import cz.cvut.fel.swa.models.Book;
import cz.cvut.fel.swa.models.NewAuthor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class AuthorService {

    public List<Book> getAuthorBooks(Integer authorId) throws IllegalArgumentException
    {
        Book book1 = new Book();
        book1.setTitle("book1");
        Book book2 = new Book();
        book2.setTitle("book2");

        return List.of(book1, book2);
    }

    public void deleteAuthor(Integer authorId) throws IllegalArgumentException
    {

    }

    public Author getAuthor(Integer authorId) throws IllegalArgumentException
    {
        Author author = new Author();
        author.setName("Pepa");
        author.setSurname("Klacek");
        return author;
    }

    public void updateAuthor(Integer authorId, NewAuthor newAuthor) throws InvalidParameterException, IllegalArgumentException
    {

    }

    public List<Author> getAllAuthors()
    {
        Author author = new Author();
        author.setName("Pepa");
        author.setSurname("Klacek");

        Author author2 = new Author();
        author2.setName("Pepík");
        author2.setSurname("Klacík");

        return List.of(author, author2);
    }

    public Integer putAuthor(NewAuthor newAuthor) throws InvalidParameterException
    {
        return 100;
    }
}
