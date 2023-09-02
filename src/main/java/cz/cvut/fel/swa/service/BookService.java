package cz.cvut.fel.swa.service;

import cz.cvut.fel.swa.models.Book;
import cz.cvut.fel.swa.models.NewBook;
import cz.cvut.fel.swa.repository.BooksRepository;
import org.postgresql.util.PSQLException;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BooksRepository booksRepository;

    public List<Book> getAllBooks(String title) {
        if (title != null) {
            System.out.println(title);
            return booksRepository.findAllWithLikeTitle(title);
        } else {
            return booksRepository.findAll();
        }
    }

    public Book getBook(String bookIsbn) throws InvalidParameterException {
        Optional<Book> book = booksRepository.findById(bookIsbn);
        if (book.isEmpty()) {
            throw new InvalidParameterException("Book with requested isbn does not exist");
        }
        return book.get();
    }

    public void deleteBook(String bookIsbn) throws InvalidParameterException {
        Optional<Book> book = booksRepository.findById(bookIsbn);
        if (book.isEmpty()) {
            throw new InvalidParameterException();
        }
        booksRepository.delete(book.get());
    }

    public String createBook(NewBook newBook) throws InvalidParameterException {
        Book book = new Book(newBook);

        Optional<Book> sameBook = booksRepository.findById(newBook.getIsbn());
        if (sameBook.isPresent()) {
            throw new InvalidParameterException("Book with same isbn already exists");
        }
        booksRepository.save(book);
        return newBook.getIsbn();

    }

    public void updateBook(NewBook newBook, String bookIsbn) throws InvalidParameterException {

        Optional<Book> book = booksRepository.findById(bookIsbn);
        if (book.isEmpty()) {
            throw new InvalidParameterException();
        }
        Book currBook = book.get();
        currBook.updateBook(newBook);
        booksRepository.save(currBook);

    }
}
