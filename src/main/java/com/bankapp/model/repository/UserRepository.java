package com.bankapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public User findByname(String name);
	public User findByEmail(String email);

}
