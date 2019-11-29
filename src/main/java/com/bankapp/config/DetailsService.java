package com.bankapp.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entity.User;
import com.bankapp.model.service.UserService;
@Service
@Transactional
public class DetailsService implements UserDetailsService{
	@Autowired 
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user=userService.findByEmail(email);
		if(user==null){
			throw new UsernameNotFoundException("user with this "+email+"not found");
		}else
			return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),AuthorityUtils.createAuthorityList(user.getRoles()));
		
		
		
	}

}
