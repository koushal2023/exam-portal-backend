package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.services.UserService;

@SpringBootApplication
public class ExamPortalBackendApplication implements CommandLineRunner{

//	@Autowired
//	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalBackendApplication.class, args);
		System.out.println("exam portal backend application started successfully");
	}

	@Override
	public void run(String... args) throws Exception {

//		use this only for the first time to register admin
		
//		System.out.println("run method started successfully");
//		User user=new User();
//		user.setFirstName("koushal");
//		user.setLastName("sharma");
//		user.setUsername("koushal2023");
//		user.setPassword("koushal2023");
//		user.setEmail("koushalsharma2023@gmail.com");
//		user.setProfile("koushal.png");
//		user.setAbout("he is first Admin");
//		user.setPhone("1234657890");
//		
//		Role role1=new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//		
//		Set<UserRole> userRolesSet=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRolesSet.add(userRole);
//		
//		User user1 = this.userService.createUser(user, userRolesSet);
//		System.out.println(user1.getUsername());
	}

}
