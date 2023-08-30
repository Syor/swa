package cz.cvut.fel.swa.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

/**
 * Author
 */
@Entity
@Table(name = "tab_authors")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("birth")
  private String birth;

  public Author() {
  }

  public Author(NewAuthor newAuthor)
  {
    this.birth = newAuthor.getBirth();
    this.name = newAuthor.getName();
    this.surname = newAuthor.getSurname();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getBirth() {
    return birth;
  }

  public void setBirth(String birth) {
    this.birth = birth;
  }

  public void updateAuthor(NewAuthor newAuthor)
  {
    if(newAuthor.getBirth() != null) this.birth = newAuthor.getBirth();
    if(newAuthor.getName() != null) this.name = newAuthor.getName();
    if(newAuthor.getSurname() != null) this.surname = newAuthor.getSurname();
  }

  @Override
  public String toString() {
    return "Author{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", birth='" + birth + '\'' +
            '}';
  }
}

