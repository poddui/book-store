package hh.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.bookstore.domain.Book;
import hh.bookstore.domain.BookRepository;
import hh.bookstore.domain.Category;
import hh.bookstore.domain.CategoryRepository;
import hh.bookstore.domain.User;
import hh.bookstore.domain.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
		@Bean
		public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) 
		{return (args) -> {
			Category c1 = new Category("Scifi");
			Category c2 = new Category("Toiminta");
			Category c3 = new Category("Rikos");
			
			crepository.save(c1);
			crepository.save(c2);
			crepository.save(c3);
			
			Book k1 = new Book("Testikirja1", "Joonas Mäki", 2000, "304509", 13.40, c1);
			Book k2 = new Book("Testikirja2", "Jarkko Oja", 2002, "304355", 11.60, c2);
			Book k3 = new Book("Testikirja3", "Jussi Matka", 2004, "304534", 9.40, c3);
			
			repository.save(k1);
			repository.save(k2);
			repository.save(k3);
			
			User user1 = new User("matti", "$2a$10$qB7UV0AMXjqnnyxKztm5vOrqWFhXUitlnlbLt2DQ2T/CXJHS68/BG", "matti.testi@hotmail.com", "USER");
			User user2 = new User("jori","$2a$10$ymhZCrzJerS0iSgzKEZGhOo36lNjIIQsMGsQ/COBODCmzGM.XFflO", "jori.koponen@hotmail.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

		};

		
	}

}
