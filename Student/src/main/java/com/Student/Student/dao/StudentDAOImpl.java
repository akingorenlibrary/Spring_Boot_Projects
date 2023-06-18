package com.Student.Student.dao;

import com.Student.Student.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    @Transactional
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student",Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastname(String getlastname) {
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student where lastName=:getlastname",Student.class);
        theQuery.setParameter("getlastname",getlastname);
        return theQuery.getResultList();

    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student theStudent=entityManager.find(Student.class,id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int etkilenenSatirSayisi=entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return etkilenenSatirSayisi;
    }


}
