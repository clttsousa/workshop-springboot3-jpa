package com.cleitonsousa.workshop.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cleitonsousa.workshop.entities.Category;
import com.cleitonsousa.workshop.entities.Order;
import com.cleitonsousa.workshop.entities.OrderItem;
import com.cleitonsousa.workshop.entities.Product;
import com.cleitonsousa.workshop.entities.User;
import com.cleitonsousa.workshop.entities.enuns.OrderStatus;
import com.cleitonsousa.workshop.repositories.CategoryRepository;
import com.cleitonsousa.workshop.repositories.OrderItemRepository;
import com.cleitonsousa.workshop.repositories.OrderRepository;
import com.cleitonsousa.workshop.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		Category cat4 = new Category(null, "Home Appliances");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Cleiton Sousa", "cleiton@gmail.com", "999117145", "123456");
		User u4 = new User(null, "Amanda Estevam", "amanda@gmail.com", "912345115", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		
		Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2023-07-21T03:42:10Z"), OrderStatus.SHIPPED, u2);
		Order o3 = new Order(null, Instant.parse("2023-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u3);
		Order o4 = new Order(null, Instant.parse("2022-02-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u4);
		Order o5 = new Order(null, Instant.parse("2023-09-20T15:21:22Z"), OrderStatus.CANCELED, u3);
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Uma saga épica na Terra Média:"
				+ " o bem luta contra o mal. Frodo lidera para destruir um anel maligno. "
				+ "Aventura inesquecível de Tolkien.", 90.5, "");
		
		Product p2 = new Product(null, "Smart TV", "Uma Smart TV impressionante de 55 polegadas, 4K, "
				+ "com streaming suave e aplicativos. "
				+ "Entretenimento em casa no seu melhor.", 2190.0, "");
		
		Product p3 = new Product(null, "Macbook Pro", "O MacBook Pro: uma obra-prima de design e desempenho."
				+ " Tela retina brilhante, poder de processamento incrível "
				+ "e portabilidade excepcional.", 1250.0, "");
		
		Product p4 = new Product(null, "PC Gamer", "PC Gamer de alto desempenho: potência bruta e gráficos incríveis."
				+ " Domine os jogos mais exigentes com este monstro de velocidade.", 6200.0, "");
		
		Product p5 = new Product(null, "Rails for Dummies", "Um guia Rails para iniciantes. "
				+ "Aprenda a criar aplicativos da web com facilidade."
				+ " Orientações práticas para dominar o desenvolvimento web.", 100.99, ""); 
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		
		p1.getCategories().add(cat2);
		
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		
		p3.getCategories().add(cat3);
		
		p4.getCategories().add(cat3);
		
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
	}

}
