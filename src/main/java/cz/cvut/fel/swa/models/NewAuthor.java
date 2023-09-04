package cz.cvut.fel.swa.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * NewAuthor
 */
public class NewAuthor   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("birth")
  private String birth;

  public NewAuthor(String name, String surname, String birth) {
    this.name = name;
    this.surname = surname;
    this.birth = birth;
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

  @Override
  public String toString() {
    return "NewAuthor{" +
            "name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", birth='" + birth + '\'' +
            '}';
  }
}

