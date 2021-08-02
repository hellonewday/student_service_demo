package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DefaultResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-26T06:52:10.121Z[GMT]")


public class DefaultResponse {
    @JsonProperty("success")
    private String success = null;

    @JsonProperty("message")
    private String message = null;

    public DefaultResponse success(String success) {
        this.success = success;
        return this;
    }

    public DefaultResponse(String success, String message) {
        this.success = success;
        this.message = message;
    }

    public DefaultResponse() {

    }

    /**
     * Trạng thái
     *
     * @return success
     **/
    @Schema(required = true, description = "Trạng thái")
    @NotNull

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public DefaultResponse message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Thông báo từ hệ thống
     *
     * @return message
     **/
    @Schema(required = true, description = "Thông báo từ hệ thống")
    @NotNull

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DefaultResponse defaultResponse = (DefaultResponse) o;
        return Objects.equals(this.success, defaultResponse.success) &&
                Objects.equals(this.message, defaultResponse.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DefaultResponse {\n");

        sb.append("    success: ").append(toIndentedString(success)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
