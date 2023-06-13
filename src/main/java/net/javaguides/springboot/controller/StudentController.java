package net.javaguides.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.bean.Student;

@RestController
@RequestMapping("students")
public class StudentController {
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {

        Student student = new Student(1, "Emmizo", "Kwizera", "emmizokwizera@gmail");
        // return new ResponseEntity<>(student, HttpStatus.OK);
        // return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header", "Emmizo-kwizera").body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "Emmizo", "Kwizera", "emmizokwizera@gmail"));
        students.add(new Student(2, "Nyakuri", "Revitte", "emmizokwizera@gmail"));
        students.add(new Student(3, "Ndanyuzwe", "Duncan", "emmizokwizera@gmail"));
        students.add(new Student(4, "Sanjay", "Sanda", "emmizokwizera@gmail"));

        return ResponseEntity.ok(students);
    }
    // spring boot respt API with path Variable
    // {id} - URI template variable
    // http://localhost:8080/student/1

    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathStudent(
            @PathVariable("id") int studentId,
            @PathVariable("first-name") String firstName,
            @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName, "emmizokwizera@gmail");
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API with Requeest Param
    // http://localhost/students/query?id=1
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id) {
        Student student = new Student(1, "Emmizo", "Kwizera", "emmizokwizera@gmail");
        return ResponseEntity.ok(student);
    }

    // Sprig boot REST API that handles HTTP POST Request
    // @PostMapping and @RequestBody
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student studentInfo) {
        return new ResponseEntity<>(studentInfo, HttpStatus.CREATED);
    }
    // Spring boot RESP API hat handles HTTP PUT request- updating existing resource
    // http://localhost:8080/students/1/update

    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API that handles HTTP delete request - Deleting te existing
    // resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully!");
    }
}
