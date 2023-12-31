package cz.cvut.fel.swa.controller;

import cz.cvut.fel.swa.models.BooksResponse;
import cz.cvut.fel.swa.models.NewBook;
import cz.cvut.fel.swa.models.Book;

import cz.cvut.fel.swa.service.BookService;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<BooksResponse> getBooks(@RequestParam(value = "page", required = false) Integer page,
                                                  @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                  @RequestParam(value = "title", required = false) String title) {
        BooksResponse response = new BooksResponse();
        if (page != null && pageSize != null) {
            Pageable pageable = PageRequest.of(page, pageSize);
            Page<Book> bookPage = bookService.getAllBooks(title, pageable);
            response.setPage(page);
            response.setPageSize(pageSize);
            response.setTotalPages(bookPage.getTotalPages());
            response.setData(bookPage.toList());
        } else {
            response.setData(bookService.getAllBooks(title));
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> putBook(@RequestBody NewBook newBook) {
        try {
            bookService.createBook(newBook);
            return new ResponseEntity<>(newBook.getIsbn(), HttpStatus.CREATED);
        } catch (InvalidParameterException | DataIntegrityViolationException e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/isbn/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable("isbn") String bookIsbn) {
        try {
            Book book = bookService.getBook(bookIsbn);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (InvalidParameterException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/isbn/{isbn}")
    public ResponseEntity<Void> postBook(@PathVariable("isbn") String bookIsbn,
                                         @RequestBody NewBook newBook) {
        try {
            bookService.updateBook(newBook, bookIsbn);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (InvalidParameterException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/isbn/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable("isbn") String bookIsbn) {
        try {
            bookService.deleteBook(bookIsbn);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (InvalidParameterException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
