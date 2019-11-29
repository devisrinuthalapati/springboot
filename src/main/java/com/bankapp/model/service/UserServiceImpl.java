package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entity.User;
import com.bankapp.model.repository.CustomerRepository;
import com.bankapp.model.repository.TransactionRepository;
import com.bankapp.model.repository.UserRepository;
import com.bankapp.model.serviceexception.UserNotFoundException;
import com.bankapp.web.beanconfig.UserRequestBean;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired 
	private UserRepository userRepository;
	@Autowired 
	private TransactionRepository transactionRepository;
	@Autowired 
	private CustomerRepository customerRepository;
	
	@Override
	public User findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	

	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public void blockUser(Long userId) {
		
		
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
		
	}

	@Override
	public void update(User user,Long userId) {
		User userToBeUpdate=userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
		userToBeUpdate.setAddress(user.getAddress());
		userRepository.save(userToBeUpdate);
	}



	@Override
	public User addUser(User user) {
		
		return userRepository.save(user);
	}

}
