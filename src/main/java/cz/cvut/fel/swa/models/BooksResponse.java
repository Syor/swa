package cz.cvut.fel.swa.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * InlineResponse200
 */
public class BooksResponse {
  @JsonProperty("page")
  private Integer page;

  @JsonProperty("pageSize")
  private Integer pageSize;

  @JsonProperty("totalPages")
  private Integer totalPages;

  @JsonProperty("data")
  @Valid
  private List<Book> data = null;

  public BooksResponse page(Integer page) {
    this.page = page;
    return this;
  }

  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public List<Book> getData() {
    return data;
  }

  public void setData(List<Book> data) {
    this.data = data;
  }
}

