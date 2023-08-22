package cz.cvut.fel.swa.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

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

  /**
   * Get title
   * @return title
  */
  @ApiModelProperty(value = "")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public NewBook isbn(String isbn) {
    this.isbn = isbn;
    return this;
  }

  /**
   * Get isbn
   * @return isbn
  */
  @ApiModelProperty(value = "")


  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public NewBook published(String published) {
    this.published = published;
    return this;
  }

  /**
   * Get published
   * @return published
  */
  @ApiModelProperty(value = "")


  public String getPublished() {
    return published;
  }

  public void setPublished(String published) {
    this.published = published;
  }

  public NewBook language(String language) {
    this.language = language;
    return this;
  }

  /**
   * Get language
   * @return language
  */
  @ApiModelProperty(value = "")


  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public NewBook genre(String genre) {
    this.genre = genre;
    return this;
  }

  /**
   * Get genre
   * @return genre
  */
  @ApiModelProperty(value = "")


  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public NewBook author(Integer author) {
    this.author = author;
    return this;
  }

  /**
   * Get author
   * @return author
  */
  @ApiModelProperty(value = "")


  public Integer getAuthor() {
    return author;
  }

  public void setAuthor(Integer author) {
    this.author = author;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewBook newBook = (NewBook) o;
    return Objects.equals(this.title, newBook.title) &&
        Objects.equals(this.isbn, newBook.isbn) &&
        Objects.equals(this.published, newBook.published) &&
        Objects.equals(this.language, newBook.language) &&
        Objects.equals(this.genre, newBook.genre) &&
        Objects.equals(this.author, newBook.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, isbn, published, language, genre, author);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewBook {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    isbn: ").append(toIndentedString(isbn)).append("\n");
    sb.append("    published: ").append(toIndentedString(published)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    genre: ").append(toIndentedString(genre)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

