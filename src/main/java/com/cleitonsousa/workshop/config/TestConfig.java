package com.cleitonsousa.workshop.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cleitonsousa.workshop.entities.Category;
import com.cleitonsousa.workshop.entities.Order;
import com.cleitonsousa.workshop.entities.User;
import com.cleitonsousa.workshop.entities.enuns.OrderStatus;
import com.cleitonsousa.workshop.repositories.CategoryRepository;
import com.cleitonsousa.workshop.repositories.OrderRepository;
import com.cleitonsousa.workshop.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		Category cat4 = new Category(null, "Home Appliances");
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Cleiton Sousa", "cleiton@gmail.com", "999117145", "123456");
		User u4 = new User(null, "Amanda Estevam", "amanda@gmail.com", "912345115", "123456");
		
		
		Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2023-07-21T03:42:10Z"), OrderStatus.SHIPPED, u2);
		Order o3 = new Order(null, Instant.parse("2023-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u3);
		Order o4 = new Order(null, Instant.parse("2022-02-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u4);
		Order o5 = new Order(null, Instant.parse("2023-09-20T15:21:22Z"), OrderStatus.CANCELED, u3);
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5));
	}

}
