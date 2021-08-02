package io.swagger.api;

import io.swagger.model.DefaultResponse;
import io.swagger.model.Student;
import io.swagger.model.StudentResponse;
import io.swagger.model.StudentsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.services.StudentService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-26T06:52:10.121Z[GMT]")
@RestController
public class StudentsApiController implements StudentsApi {

    private static final Logger log = LoggerFactory.getLogger(StudentsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    private final StudentService studentService;

    @org.springframework.beans.factory.annotation.Autowired
    public StudentsApiController(ObjectMapper objectMapper, HttpServletRequest request, StudentService studentService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.studentService = studentService;
    }

    public ResponseEntity<DefaultResponse> publicCreateStudents(@Parameter(in = ParameterIn.DEFAULT, description = "Thêm sinh viên mới vào hệ thống", schema = @Schema()) @Valid @RequestBody Student body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                DefaultResponse response = studentService.addStudent(body);
                if (response.getSuccess() == "false") {
                    return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
                } else {
                    return new ResponseEntity(response, HttpStatus.CREATED);
                }

            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<DefaultResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<DefaultResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<DefaultResponse> publicDeleteStudentsById(@Parameter(in = ParameterIn.PATH, description = "Xóa sinh viên trong hệ thống", required = true, schema = @Schema()) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                DefaultResponse response = studentService.deleteStudent(id);
                if (response.getSuccess() == "false") {
                    return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
                } else {
                    return new ResponseEntity(response, HttpStatus.OK);
                }
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<DefaultResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<DefaultResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<StudentsResponse> publicFindStudents() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                StudentsResponse response = new StudentsResponse();
                response.setData(studentService.getAllStudents());
                response.setCounts(studentService.getAllStudents().size());
                response.setSuccess(Boolean.TRUE);
                return new ResponseEntity<StudentsResponse>(response, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<StudentsResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<StudentsResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<StudentResponse> publicFindStudentsById(@Parameter(in = ParameterIn.PATH, description = " Id của student", required = true, schema = @Schema()) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                StudentResponse response = new StudentResponse();
                if (studentService.getStudent(id) != null) {
                    response.setStudent(studentService.getStudent(id));
                    response.setSuccess(Boolean.TRUE);
                    return new ResponseEntity<StudentResponse>(response, HttpStatus.OK);
                } else {
                    response.setSuccess(false);
                    response.setStudent(null);
                    return new ResponseEntity<StudentResponse>(response, HttpStatus.BAD_REQUEST);
                }


            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<StudentResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<StudentResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<DefaultResponse> publicUpdateStudents(@Parameter(in = ParameterIn.PATH, description = "Sửa thông tin theo mã sinh viên", required = true, schema = @Schema()) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "Dữ liệu sinh viên cần sửa trong hệ thống", schema = @Schema()) @Valid @RequestBody Student body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                DefaultResponse response = studentService.updateStudent(id, body);
                if (response.getSuccess() == "false") {
                    return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
                } else {
                    return new ResponseEntity(response, HttpStatus.OK);
                }
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<DefaultResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<DefaultResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
