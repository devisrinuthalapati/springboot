package com.bankapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entity.TransactionLog;
import com.bankapp.model.entity.User;
import com.bankapp.model.service.TransactionalLogService;
import com.bankapp.model.service.UserService;
import com.bankapp.web.beanconfig.UserRequestBean;

@RestController
@RequestMapping(path="api")
public class UserController {
	/*@GetMapping(path="/admin")
	public String admin(){
		return "hello to admin";
	}
	@GetMapping(path="/mgr")
	public String mgr(){
		return "hello to mgr";
	}
	@GetMapping(path="/clerk")
	public String clerk(){
		return "hello to clerk";
	}*/
	@Autowired
	private UserService userService;
	
	@Autowired
	private TransactionalLogService transactionLogService;
	@GetMapping(path="/user",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> findAllUsers(){
		return new ResponseEntity<List<User>>(userService.findAll(),HttpStatus.OK);
		
	}
	@GetMapping(path="/user/{email}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findByEmail(@PathVariable(name="email")String email){
		return new ResponseEntity<User>(userService.findByEmail(email),HttpStatus.OK);
	}
	@PostMapping(path="/user",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addNewUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.addUser(user),HttpStatus.OK);
	}
	@DeleteMapping(path="/user/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteUser(@PathVariable(name="id")Long id){
		userService.deleteUser(id);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	@GetMapping(path="/user/accountstransactionlog",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionLog>>transactionLog(){
		return new ResponseEntity<List<TransactionLog>>(transactionLogService.findAll(),HttpStatus.OK);
		
	}
	@PutMapping(path="/user/{id}",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Void>update(@PathVariable(name="id") Long id,@RequestBody User user){
		userService.update(user, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
