package com.onetoone.onetoone.dao;

import com.onetoone.onetoone.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findById(int theId);

    void deleteInstructorById(int theId);
}
