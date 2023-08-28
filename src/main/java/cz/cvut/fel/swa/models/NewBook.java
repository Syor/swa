package cz.cvut.fel.swa.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * NewBook
 */
public class NewBook   {
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

  @JsonProperty("author")
  private Integer author;

  public NewBook title(String title) {
    this.title = title;
    return this;
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

  @Override
  public String toString() {
    return "NewBook{" +
            "title='" + title + '\'' +
            ", isbn='" + isbn + '\'' +
            ", published='" + published + '\'' +
            ", language='" + language + '\'' +
            ", genre='" + genre + '\'' +
            ", author=" + author +
            '}';
  }
}

