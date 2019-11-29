package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bankapp.model.entity.Account;
import com.bankapp.model.entity.Customer;
import com.bankapp.model.entity.User;
import com.bankapp.model.repository.AccountRepository;
import com.bankapp.model.repository.CustomerRepository;
import com.bankapp.model.repository.UserRepository;
import com.bankapp.model.service.AccountService;
@EnableTransactionManagement
/*@EnableJpaRepositories("com.bankapp.model.repository")
@EntityScan("com.bankapp.model.entity")
@ComponentScan("com.bankapp.model.service")
@SpringBootApplication(scanBasePackages={"com.bankapp.web","com.springdata.demo","com.bankapp.config"})*/
@SpringBootApplication
public class BankApplicationVer1Application implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(BankApplicationVer1Application.class, args);
	
	}

	@Override
	public void run(String... args) throws Exception {
		/*accountService.deposit(1L, 200.00);*/
		/*Customer customer=new Customer("devi", "devi@gmail.com", "342343546", "btm", "bnglr", "india");
		Customer customer1=new Customer("sai", "sai@gmail.com", "3423546", "huaq", "ongl", "india");
		Customer customer2=new Customer("teji", "teji@gmail.com", "3423436", "fsdf", "kavali", "india");
		Account account=new Account(2000.00,false,customer);
		Account account1=new Account(3000.00,false,customer1);
		Account account2=new Account(4000.00,false,customer2);
		account.setCustomer(customer);
		account1.setCustomer(customer1);
		account2.setCustomer(customer2);
		accountRepository.save(account);
		accountRepository.save(account1);
		accountRepository.save(account2);
		
		customer.setAccount(account);
		customer1.setAccount(account1);
		customer2.setAccount(account2);
		customerRepository.save(customer);
		customerRepository.save(customer1);
		customerRepository.save(customer2);*/
		
		
		
		/*User user=new User("sai", "sai@gmail.com", "sai", "ongl",new String[] {"ROLE_ADMIN","ROLE_MGR","ROLE_CLERK"}, true);
		User user1=new User("rai", "rai@gmail.com", "rai", "djf",new String[] {"ROLE_ADMIN"}, true);
		User user2=new User("teji", "teji@gmail.com", "teji", "dsd",new String[] {"ROLE_ADMIN","ROLE_MGR"}, true);
		User user3=new User("hai", "hai@gmail.com", "hai", "dds",new String[] {"ROLE_CLERK"}, true);

		userRepository.save(user);
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);*/
	}
}
