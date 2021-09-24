package com.security;

import com.security.models.User;
import com.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringBootSecurityApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setEmail("abc@gmail.com");
		user.setUsername("abc");
		user.setPassword(bCryptPasswordEncoder.encode("abc"));
		user.setRoll("ROLE_NORMAL");

		this.userRepository.save(user);

		User user1 = new User();
		user1.setEmail("xyz@gmail.com");
		user1.setUsername("xyz");
		user1.setPassword(bCryptPasswordEncoder.encode("xyz"));
		user1.setRoll("ROLE_ADMIN");

		this.userRepository.save(user1);
	}
}
