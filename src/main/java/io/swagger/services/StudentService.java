package io.swagger.services;

import io.swagger.model.DefaultResponse;
import io.swagger.model.Student;
import io.swagger.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {
    StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String validateStudentRegistration(Student s) {
        if (s.getAge() < 0 || s.getAge() > 200) {
            return "Age is invalid";
        }
        if (s.getName().length() > 20) {
            return "Name is invalid";
        }

        if (s.getName().matches(".")) {

        }

        if (studentRepository.existsById(s.getId())) {
            return "Student with id " + s.getId() + " is duplicated";
        }
        return null;
    }

    public String validateStudentUpdate(Student s) {
        if ((s.getAge() < 0 || s.getAge() > 200) && s.getAge() != 0) {
            return "Age is invalid";
        }
        if (s.getName().length() > 20 && s.getName() != "") {
            return "Name is invalid";
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(int id) {
        if (!studentRepository.existsById(id)) {
            return null;
        }
        return studentRepository.findById(id).get();
    }

    public DefaultResponse addStudent(Student student) {
        if (validateStudentRegistration(student) != null) {
            return new DefaultResponse("false", validateStudentRegistration(student));
        } else {
            Student newStudent = studentRepository.save(student);
            return new DefaultResponse("true", "Add new student successfully - Id: " + newStudent.getId());
        }

    }

    public DefaultResponse deleteStudent(int id) {
        DefaultResponse response = new DefaultResponse();
        try {
            studentRepository.deleteById(id);
            response.setSuccess("true");
            response.setMessage("Delete successfully student " + id);
            return response;
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setSuccess("false");
            return response;
        }
    }

    @Transactional
    public DefaultResponse updateStudent(Integer id, Student student) {
        if (!studentRepository.existsById(id)) {
            return new DefaultResponse("false", "Student with id " + id + " is not found");
        }
        if (validateStudentUpdate(student) != null) {
            return new DefaultResponse("false", validateStudentUpdate(student));
        } else {
            Student newStudent = studentRepository.findById(id).get();
            newStudent.setName(student.getName() == "" ? newStudent.getName() : student.getName());
            newStudent.setAge(student.getAge() == 0 ? newStudent.getAge() : student.getAge());
            return new DefaultResponse("true", "Update id " + id + " successfully");
        }
    }
}
