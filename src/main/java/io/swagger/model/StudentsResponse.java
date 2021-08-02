package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Student;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * StudentsResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-26T06:52:10.121Z[GMT]")


public class StudentsResponse   {
  @JsonProperty("data")
  @Valid
  private List<Student> data = new ArrayList<Student>();

  @JsonProperty("success")
  private Boolean success;

  @JsonProperty("counts")
  private int counts;

  public StudentsResponse data(List<Student> data) {
    this.data = data;
    return this;
  }

  public StudentsResponse addDataItem(Student dataItem) {
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<Student> getData() {
    return data;
  }

  public void setData(List<Student> data) {
    this.data = data;
  }

  public StudentsResponse success(Boolean success) {
    this.success = success;
    return this;
  }

  /**
   * Trạng thái phản hồi
   * @return success
   **/
  @Schema(required = true, description = "Trạng thái phản hồi")
      @NotNull

    public Boolean isSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public StudentsResponse counts(int counts) {
    this.counts = counts;
    return this;
  }

  /**
   * Số lượng bản ghi
   * @return counts
   **/
  @Schema(required = true, description = "Số lượng bản ghi")
      @NotNull

    @Valid
    public int getCounts() {
    return counts;
  }

  public void setCounts(int counts) {
    this.counts = counts;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudentsResponse studentsResponse = (StudentsResponse) o;
    return Objects.equals(this.data, studentsResponse.data) &&
        Objects.equals(this.success, studentsResponse.success) &&
        Objects.equals(this.counts, studentsResponse.counts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, success, counts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudentsResponse {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    counts: ").append(toIndentedString(counts)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
