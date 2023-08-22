package cz.cvut.fel.swa.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * InlineResponse2001
 */
public class AuthorsResponse {
  @JsonProperty("page")
  private Integer page;

  @JsonProperty("pageSize")
  private Integer pageSize;

  @JsonProperty("totalPages")
  private Integer totalPages;

  @JsonProperty("data")
  @Valid
  private List<Author> data = null;

  public AuthorsResponse page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Number of page returned
   * @return page
  */
  @ApiModelProperty(value = "Number of page returned")


  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public AuthorsResponse pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * Size of returned page
   * @return pageSize
  */
  @ApiModelProperty(value = "Size of returned page")


  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public AuthorsResponse totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Total number of pages
   * @return totalPages
  */
  @ApiModelProperty(value = "Total number of pages")


  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public AuthorsResponse data(List<Author> data) {
    this.data = data;
    return this;
  }

  public AuthorsResponse addDataItem(Author dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Author> getData() {
    return data;
  }

  public void setData(List<Author> data) {
    this.data = data;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthorsResponse authorsResponse = (AuthorsResponse) o;
    return Objects.equals(this.page, authorsResponse.page) &&
        Objects.equals(this.pageSize, authorsResponse.pageSize) &&
        Objects.equals(this.totalPages, authorsResponse.totalPages) &&
        Objects.equals(this.data, authorsResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, pageSize, totalPages, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2001 {\n");
    
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

