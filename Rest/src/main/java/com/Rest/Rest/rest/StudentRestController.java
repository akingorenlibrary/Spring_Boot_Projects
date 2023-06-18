package com.Rest.Rest.rest;

import com.Rest.Rest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents=new ArrayList<>();

        theStudents.add(new Student("Akın","Gören"));
        theStudents.add(new Student("Aida","Guseynova"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable(name="studentId") int studentId){
        System.out.println("ok");
        if( (studentId>=theStudents.size()) || (studentId<0)){
            throw new StudentNotFoundException("Student not found - "+studentId);
        }

        return theStudents.get(studentId);
    }



}
