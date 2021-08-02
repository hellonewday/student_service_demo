package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Student
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-26T06:52:10.121Z[GMT]")

@Entity
public class Student {
    @JsonProperty("name")
    @Basic
    @Column(name = "name")
    private String name = null;

    @Id
    @JsonProperty("id")
    @Column(name = "id")
    private int id = 0;


    @JsonProperty("age")
    @Basic
    @Column(name = "age")
    private int age = 0;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Thông tin tên sinh viên
     *
     * @return name
     **/
    @Schema(required = true, description = "Thông tin tên sinh viên")
    @NotNull

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student id(int id) {
        this.id = id;
        return this;
    }

    /**
     * ID thuộc tính
     *
     * @return id
     **/
    @Schema(required = true, description = "ID thuộc tính")
    @NotNull

    @Valid
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student age(int age) {
        this.age = age;
        return this;
    }


    /**
     * Thông tin tuổi sinh viên
     *
     * @return age
     **/
    @Schema(required = true, description = "Thông tin tuổi sinh viên")
    @NotNull

    @Valid
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(this.name, student.name) &&
                Objects.equals(this.id, student.id) &&
                Objects.equals(this.age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, age);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Student {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    age: ").append(toIndentedString(age)).append("\n");
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
