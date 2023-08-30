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
public class Book {

  @Id
  @JsonProperty("isbn")
  private String isbn;

  @JsonProperty("title")
  private String title;

  @JsonProperty("published")
  private String published;

  @JsonProperty("language")
  private String language;

  @JsonProperty("genre")
  private String genre;

  @JsonProperty("author")
  private Integer author;

  public Book() {
  }

  public Book(NewBook book)
  {
    this.author = book.getAuthor();
    this.genre = book.getGenre();
    this.isbn = book.getIsbn();
    this.language = book.getLanguage();
    this.title = book.getTitle();
    this.published = book.getPublished();
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

  public Integer getAuthor() {
    return author;
  }

  public void setAuthor(Integer author) {
    this.author = author;
  }

  public void updateBook(NewBook newBook)
  {
    if(newBook.getAuthor() != null) this.author = newBook.getAuthor();
    if(newBook.getGenre() != null) this.genre = newBook.getGenre();
    if(newBook.getLanguage() != null) this.language = newBook.getLanguage();
    if(newBook.getPublished() != null) this.published = newBook.getPublished();
    if(newBook.getTitle() != null) this.title = newBook.getTitle();
  }

  @Override
  public String toString() {
    return "Book{" +
            "isbn='" + isbn + '\'' +
            ", title='" + title + '\'' +
            ", published='" + published + '\'' +
            ", language='" + language + '\'' +
            ", genre='" + genre + '\'' +
            ", author=" + author +
            '}';
  }
}

