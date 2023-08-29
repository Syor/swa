package cz.cvut.fel.swa.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import javax.validation.Valid;
import java.util.Objects;

/**
 * Book
 */
@Entity
@Table(name = "tab_books")
public class Book   {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("title")
  private String title;

  @JsonProperty("isbn")
  private String isbn;

  @JsonProperty("published")
  private String published;

  @JsonProperty("language")
  private String language;

  @JsonProperty("genre")
  private String genre;

  @ManyToOne
  @JsonProperty("author")
  private Author author;

  public Book() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getPublished() {
    return published;
  }

  public void setPublished(String published) {
    this.published = published;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  @Override
  public String toString() {
    return "Book{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", isbn='" + isbn + '\'' +
            ", published='" + published + '\'' +
            ", language='" + language + '\'' +
            ", genre='" + genre + '\'' +
            ", author=" + author +
            '}';
  }
}

