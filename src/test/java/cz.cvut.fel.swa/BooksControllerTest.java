package cz.cvut.fel.swa;


import cz.cvut.fel.swa.controller.AuthorController;
import cz.cvut.fel.swa.controller.BookController;
import cz.cvut.fel.swa.models.AuthorsResponse;
import cz.cvut.fel.swa.models.BooksResponse;
import cz.cvut.fel.swa.models.NewAuthor;
import cz.cvut.fel.swa.models.NewBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

@SpringBootTest(classes = SwaApplication.class)
@ContextConfiguration(classes = {TestConfig.class})

public class BooksControllerTest {

    @Autowired
    BookController bookController;

    @Autowired
    AuthorController authorController;

    private Integer authorId;

    @BeforeEach
    public void setup()
    {
        ResponseEntity<?> entity1 = authorController.putAuthor(new NewAuthor("Pepa", "Vopička", "12.5.1986"));

        Assertions.assertEquals(HttpStatus.OK, entity1.getStatusCode());
        authorId = (Integer) entity1.getBody();
    }

    @Test
    @Transactional
    public void addBooksTest()
    {
        ResponseEntity<?> entity1 = bookController.putBook(new NewBook("Title", "isbn", "1.1.1999", "CZ" , "egnre", authorId));

        Assertions.assertEquals(HttpStatus.CREATED, entity1.getStatusCode());
        Assertions.assertNotNull(entity1.getBody());
        Assertions.assertEquals(String.class, entity1.getBody().getClass());

        ResponseEntity<?> entity2 = bookController.putBook(new NewBook("Title", "isbn2", "1.1.1999", "CZ" , "egnre", authorId));

        Assertions.assertEquals(HttpStatus.CREATED, entity2.getStatusCode());

        ResponseEntity<BooksResponse> entityResponse = bookController.getBooks(null, null, null);

        Assertions.assertNotNull(entityResponse.getBody());
        Assertions.assertEquals(2, entityResponse.getBody().getData().size());
    }
}