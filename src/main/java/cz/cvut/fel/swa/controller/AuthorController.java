package cz.cvut.fel.swa.controller;

import cz.cvut.fel.swa.models.*;

import cz.cvut.fel.swa.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@Controller
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping(value = "{author-id}/books")
    public ResponseEntity<BooksResponse> getAuthorBooks(@PathVariable("author-id") Integer authorId,
                                                        @RequestParam(value = "page", required = false) Integer page,
                                                        @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        try{
            List<Book> books = authorService.getAuthorBooks(authorId);
            BooksResponse response = new BooksResponse();

            if(page != null && pageSize != null)
            {
                response.setTotalPages(books.size() / pageSize + 1);
                response.setPage(page);
                response.setPageSize(pageSize);
                response.setData(books.subList(page * pageSize, Math.min((page + 1) * pageSize, books.size())));
            }
            else
            {
                response.setData(books);
            }

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (InvalidParameterException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(value = "/{author-id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable("author-id") Integer authorId) {

        try{
            authorService.deleteAuthor(authorId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (InvalidParameterException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/{author-id}")
    public ResponseEntity<Author> getAuthor(@PathVariable("author-id") Integer authorId) {

        try{
            Author author = authorService.getAuthor(authorId);
            return new ResponseEntity<>(author, HttpStatus.OK);
        } catch (InvalidParameterException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{author-id}")
    public ResponseEntity<Void> postAuthor(@PathVariable("author-id") Integer authorId,
                                           @RequestBody NewAuthor newAuthor) {
        try{
            authorService.updateAuthor(authorId, newAuthor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (InvalidParameterException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<AuthorsResponse> getAuthors(@RequestParam(value = "page", required = false) Integer page,
                                                      @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        AuthorsResponse response = new AuthorsResponse();

        List<Author> authors = authorService.getAllAuthors();

        if (page != null && pageSize != null) {
            response.setPage(page);
            response.setPageSize(pageSize);
            response.setTotalPages(authors.size() / pageSize + 1);
            response.setData(authors.subList(page * pageSize, Math.min((page + 1) * pageSize, authors.size())));
        } else {
            response.setData(authors);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PutMapping()
    public ResponseEntity<?> putAuthor(@RequestBody NewAuthor newAuthor) {

        try{
            Integer authorId = authorService.putAuthor(newAuthor);
            return new ResponseEntity<Integer>(authorId, HttpStatus.OK);
        } catch (InvalidParameterException | DataIntegrityViolationException e) {
            return new ResponseEntity<String>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

}
