package com.onetoone.onetoone;

import com.onetoone.onetoone.dao.AppDAO;
import com.onetoone.onetoone.entity.Instructor;
import com.onetoone.onetoone.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnetooneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnetooneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Deleting instructor");
		appDAO.deleteInstructorById(theId);
		System.out.println("done");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: "+ theId);
		Instructor instructor=instructor=appDAO.findById(theId);
		System.out.println("instructor: "+instructor.getFirstName());
		System.out.println("instructordetail: "+instructor.getInstructorDetail().getYoutubeChannel());
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor=new Instructor("Chad", "Darby","a@gmail.com");
		InstructorDetail instructorDetail=new InstructorDetail("http://www.youtube.com","sondakika");
		instructor.setInstructorDetail(instructorDetail);
		System.out.println("Saving...");
		appDAO.save(instructor);
	}
}
