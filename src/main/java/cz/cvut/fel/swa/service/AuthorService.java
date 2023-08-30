package cz.cvut.fel.swa.service;

import cz.cvut.fel.swa.models.Author;
import cz.cvut.fel.swa.models.Book;
import cz.cvut.fel.swa.models.NewAuthor;
import cz.cvut.fel.swa.repository.AuthorsRepository;
import cz.cvut.fel.swa.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorsRepository authorsRepository;

    @Autowired
    BooksRepository booksRepository;

    public List<Book> getAuthorBooks(Integer authorId) throws InvalidParameterException
    {
        Optional<Author> author = authorsRepository.findById(authorId);
        if(author.isEmpty())
        {
            throw new InvalidParameterException();
        }
        //return booksRepository.findByAuthor(authorId);
        return null;
    }

    public void deleteAuthor(Integer authorId) throws InvalidParameterException
    {
        Optional<Author> author = authorsRepository.findById(authorId);
        if(author.isEmpty())
        {
            throw new InvalidParameterException();
        }
        authorsRepository.delete(author.get());
    }

    public Author getAuthor(Integer authorId) throws InvalidParameterException
    {
        Optional<Author> author = authorsRepository.findById(authorId);
        if(author.isEmpty())
        {
            throw new InvalidParameterException();
        }
        return author.get();
    }

    public void updateAuthor(Integer authorId, NewAuthor newAuthor) throws InvalidParameterException
    {
        Optional<Author> author = authorsRepository.findById(authorId);
        if(author.isEmpty())
        {
            throw new InvalidParameterException();
        }
        Author currAuthor = author.get();
        currAuthor.updateAuthor(newAuthor);
        authorsRepository.save(currAuthor);
    }

    public List<Author> getAllAuthors()
    {
        return authorsRepository.findAll();
    }

    public Integer putAuthor(NewAuthor newAuthor) throws InvalidParameterException
    {
        Author author = new Author(newAuthor);
        authorsRepository.save(author);
        return author.getId();
    }
}
