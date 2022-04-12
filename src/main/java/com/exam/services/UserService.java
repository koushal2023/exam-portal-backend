package com.exam.services;

import java.util.List;
import java.util.Set;
import com.exam.models.User;
import com.exam.models.UserRole;

public interface UserService {
// creating user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
//	getting user by username
	public User getUser(String username) throws Exception;
	
	
//	getting all the users
	public List<User> getAllUsers();
	
//	updating user
	public User editUser(long id,User user) throws Exception;
	
//	deleting user
	public boolean deleteUser(long id) throws Exception;
}
