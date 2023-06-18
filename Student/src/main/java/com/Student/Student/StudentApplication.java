package com.Student.Student;

import com.Student.Student.dao.StudentDAO;
import com.Student.Student.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			createStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudent(studentDAO);
			//queryForStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		int etkilenenSatirSayisi=studentDAO.deleteAll();
		System.out.println("Deleted All..."+etkilenenSatirSayisi+" rows");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=1;
		studentDAO.delete(studentId);
		System.out.println("Deleted...");
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId=2;
		System.out.println("Gettin student with id: "+studentId);
		Student myStudent=studentDAO.findById(studentId);

		System.out.println("Updating student ...");
		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);

		System.out.println("updated student: "+myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> temp=studentDAO.findByLastname("gören");
		for(Student person : temp){
			System.out.println(person);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> temp=studentDAO.findAll();
		for(Student person : temp){
			System.out.println(person);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println(studentDAO.findById(2).getFirstName());
	}

	private void createStudent(StudentDAO studentDAO) {
		Student tempStudent=new Student("Aida","Gören","a@gmail.com");
		studentDAO.save(tempStudent);
	}

}
