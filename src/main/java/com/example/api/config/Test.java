package com.example.api.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.api.entities.Category;
import com.example.api.entities.Employee;
import com.example.api.entities.Order;
import com.example.api.entities.User;
import com.example.api.entities.enums.OrderStatus;
import com.example.api.repositories.CategoryRepository;
import com.example.api.repositories.EmployeeRepository;
import com.example.api.repositories.OrderRepository;
import com.example.api.repositories.UserRepository;

@Configuration
@Profile("test")
public class Test implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria", "maria@gmail.com", "915472611", "maria123");
		User u2 = new User(null, "Carlos", "carlos@gmail.com", "982031595", "carlos123");
		User u3 = new User(null, "Charles", "charles@gmail.com", "902541635", "charles123");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		
		Category c1 = new Category(null, "Mudanças");
		Category c2 = new Category(null, "Encanador");
		Category c3 = new Category(null, "Eletricista");
		
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Employee e1 = new Employee(null, "Denise", "denise@gmail.com", "948523065", "denise123", c1);
		Employee e2 = new Employee(null, "Marcos", "marcos@gmail.com", "948523065", "marcos123", c2);
		Employee e3 = new Employee(null, "Paulo", "paulo@gmail.com", "948523065", "paulo123", c3);
		
		employeeRepository.saveAll(Arrays.asList(e1, e2, e3));
		
		e1.getUser().add(u1);
		e2.getUser().add(u2);
		e3.getUser().add(u3);
		
		e1.getUser().add(u1);
		e2.getUser().add(u2);
		e3.getUser().add(u3);
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), 200.00, u1 ,OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), 150.00, u2 ,OrderStatus.CANCELED);
		Order o3 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), 20.00, u3 ,OrderStatus.WAITING_PAYMENT);
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
