package com.exam.controllers;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.helper.UserFoundException;
import com.exam.helper.UserNotFoundException;
import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
//	creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		user.setProfile("default.png");

//		encoding password with bcryptpasswordencoder
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		Set<UserRole> userRoles=new HashSet<>();
		
		Role role=new Role();
		role.setRoleId(46L);
		role.setRoleName("NORMAL");
		
		UserRole userRole=new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		userRoles.add(userRole);
		try {
			return userService.createUser(user, userRoles);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("user with this username is already there in DB !! try with another username" + e.getMessage());
		}
		
	}
	
//	getting user by username
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) throws Exception {
		return userService.getUser(username);
	}
	
//	getting all user
	@GetMapping("/")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
//	updating user
	@PutMapping("/{id}")
	public User updateUser(@PathVariable("id") long id,@RequestBody User user) throws Exception {
		return userService.editUser(id, user);
	}
	
//	deleting user
	@DeleteMapping("/{id}")
	public boolean deleteUser(@PathVariable("id") long id) throws Exception {
		return userService.deleteUser(id);		
	}
	
//	exception handling
	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<?> exceptionHandler(UserFoundException ex){
		return ResponseEntity.ok(ex);
	}
}
