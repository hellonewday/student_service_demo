package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Student;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * StudentResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-26T06:52:10.121Z[GMT]")


public class StudentResponse  {
  @JsonProperty("student")
  private Student student;

  @JsonProperty("success")
  private Boolean success = null;

  public StudentResponse student(Student student) {
    this.student = student;
    return this;
  }

  /**
   * Get student
   * @return student
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public StudentResponse success(Boolean success) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudentResponse studentResponse = (StudentResponse) o;
    return Objects.equals(this.student, studentResponse.student) &&
        Objects.equals(this.success, studentResponse.success);
  }

  @Override
  public int hashCode() {
    return Objects.hash(student, success);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudentResponse {\n");
    
    sb.append("    student: ").append(toIndentedString(student)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
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
