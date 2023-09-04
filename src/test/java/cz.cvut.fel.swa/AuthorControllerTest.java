package cz.cvut.fel.swa;

import cz.cvut.fel.swa.controller.AuthorController;
import cz.cvut.fel.swa.models.Author;
import cz.cvut.fel.swa.models.AuthorsResponse;
import cz.cvut.fel.swa.models.NewAuthor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

@SpringBootTest(classes = SwaApplication.class)
@ContextConfiguration(classes = {TestConfig.class})

public class AuthorControllerTest {

    @Autowired
    AuthorController authorController;


    @Test
    @Transactional
    public void addAuthorsTest()
    {

        ResponseEntity<?> entity1 = authorController.putAuthor(new NewAuthor("Pepa", "Vopička", "12.5.1986"));

        Assertions.assertEquals(HttpStatus.OK, entity1.getStatusCode());
        Assertions.assertNotNull(entity1.getBody());
        Assertions.assertEquals(Integer.class, entity1.getBody().getClass());

        ResponseEntity<?> entity2 = authorController.putAuthor(new NewAuthor("Pepa", "Čepička", "13.5.1986"));

        Assertions.assertEquals(HttpStatus.OK, entity2.getStatusCode());

        ResponseEntity<AuthorsResponse> entityResponse = authorController.getAuthors(null, null);

        Assertions.assertNotNull(entityResponse.getBody());
        Assertions.assertEquals(2, entityResponse.getBody().getData().size());
    }

    @Test
    @Transactional
    public void getAuthorTest() {
        NewAuthor newAuthor = new NewAuthor("Pepa", "Vopička", "12.5.1986");
        ResponseEntity<?> entity1 = authorController.putAuthor(newAuthor);

        Assertions.assertEquals(HttpStatus.OK, entity1.getStatusCode());
        Integer id = (Integer) entity1.getBody();

        ResponseEntity<Author> responseEntity = authorController.getAuthor(id);
        Assertions.assertNotNull(responseEntity.getBody());
        Author author = responseEntity.getBody();

        Assertions.assertEquals(newAuthor.getName(), author.getName());
        Assertions.assertEquals(newAuthor.getSurname(), author.getSurname());
        Assertions.assertEquals(newAuthor.getBirth(), author.getBirth());
    }

    @Test
    @Transactional
    public void modifyAuthorTest() {
        NewAuthor newAuthor = new NewAuthor("Pepa", "Vopička", "12.5.1986");
        ResponseEntity<?> entity1 = authorController.putAuthor(newAuthor);

        Assertions.assertEquals(HttpStatus.OK, entity1.getStatusCode());
        Integer id = (Integer) entity1.getBody();

        NewAuthor modifiedAuthor = new NewAuthor(null, "Čepička", null);

        ResponseEntity<Void> modifiedResponse = authorController.postAuthor(id, modifiedAuthor);
        Assertions.assertEquals(HttpStatus.OK, modifiedResponse.getStatusCode());

        ResponseEntity<Author> responseEntity = authorController.getAuthor(id);
        Assertions.assertNotNull(responseEntity.getBody());
        Author author = responseEntity.getBody();

        Assertions.assertEquals(newAuthor.getName(), author.getName());
        Assertions.assertEquals(modifiedAuthor.getSurname(), author.getSurname());
        Assertions.assertEquals(newAuthor.getBirth(), author.getBirth());

    }

    @Test
    @Transactional
    public void getAndDeleteAuthorTest() {
        NewAuthor newAuthor = new NewAuthor("Pepa", "Vopička", "12.5.1986");
        ResponseEntity<?> entity1 = authorController.putAuthor(newAuthor);

        Assertions.assertEquals(HttpStatus.OK, entity1.getStatusCode());
        Integer id = (Integer) entity1.getBody();

        ResponseEntity<Void> entity2 = authorController.deleteAuthor(id);
        Assertions.assertEquals(HttpStatus.OK, entity2.getStatusCode());

        ResponseEntity<Author> responseEntity1 = authorController.getAuthor(id);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, responseEntity1.getStatusCode());

        ResponseEntity<Void> responseEntity2 = authorController.deleteAuthor(id);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, responseEntity2.getStatusCode());
    }

}
