package cz.cvut.fel.swa.service;

import cz.cvut.fel.swa.models.Book;
import cz.cvut.fel.swa.models.NewBook;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class BookService {
    public List<Book> getAllBooks()
    {
        Book book1 = new Book();
        book1.setTitle("book1");
        Book book2 = new Book();
        book2.setTitle("book2");

        return List.of(book1, book2);
    }

    public Book getBook(String bookIsbn) throws InvalidParameterException
    {
        return new Book();
    }

    public void deleteBook(String bookIsbn) throws InvalidParameterException
    {

    }

    public String createBook(NewBook newBook) throws InvalidParameterException
    {
        return "isbn";
    }

    public void updateBook(NewBook newBook, String bookIsbn) throws InvalidParameterException, IllegalArgumentException
    {

    }
}
