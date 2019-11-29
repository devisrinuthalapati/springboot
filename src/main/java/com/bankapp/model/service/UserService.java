package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entity.User;


public interface UserService {
	public User findByEmail(String email);
	public User addUser(User user);
	public List<User> findAll();
	public void blockUser(Long userId);
	public void deleteUser(Long userId);
	public void update(User user,Long userId);
}
