package com.Student.Student.dao;

import com.Student.Student.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastname(String getlastname);

    void update(Student theStudent);

    void delete(int id);

    int deleteAll();
}
