package com.exam.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.helper.UserFoundException;
import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	// creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User usr = userRepository.findByUsername(user.getUsername());
		if (usr != null) {
			System.out.println("user already registered!!");
			throw new UserFoundException();
		} else {

			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			usr = this.userRepository.save(user);
			return usr;
		}
		
	}

	@Override
	public User getUser(String username) throws Exception {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			return user;
		} else {
			System.out.println("user not found");
			throw new Exception("user not found");
		}
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User editUser(long id, User user) throws Exception {
		User usr = userRepository.findById(id);
		if (usr != null) {
			usr.setAbout(user.getAbout());
			usr.setEmail(user.getEmail());
			usr.setFirstName(user.getFirstName());
			usr.setIsenabled(user.isIsenabled());
			usr.setLastName(user.getLastName());
			usr.setPassword(user.getPassword());
			usr.setPhone(user.getPhone());
			usr.setProfile(user.getProfile());
			usr.setUsername(user.getUsername());
			return userRepository.save(usr);
		} else {
			System.out.println("user not fou nd");
			throw new Exception("User not found");
		}
	}

	@Override
	public boolean deleteUser(long id) throws Exception {
		User user = userRepository.findById(id);
		if (user != null) {
			try {
				userRepository.deleteById(id);
				return true;
			} catch (Exception e) {
				throw new Exception("can not delete user , try again!!");
			}
		} else {
			System.out.println("user not found");
			throw new Exception("User not found");
		}

	}

}
