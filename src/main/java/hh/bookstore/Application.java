package hh.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.bookstore.domain.Book;
import hh.bookstore.domain.BookRepository;
import hh.bookstore.domain.Category;
import hh.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
		@Bean
		public CommandLineRunner demo(BookRepository repository) 
		{return (args) -> {
			Book k1 = new Book("Testikirja1", "Joonas Mäki", 2000, "304509", 13.40);
			Book k2 = new Book("Testikirja2", "Jarkko Oja", 2002, "304355", 11.60);
			Book k3 = new Book("Testikirja3", "Jussi Matka", 2004, "304534", 9.40);
			
			repository.save(k1);
			repository.save(k2);
			repository.save(k3);
			
		};
	}
		
		@Bean
		public CommandLineRunner kategoriat(CategoryRepository repository) 
		{return (args) -> {
			Category c1 = new Category(null, "scifi");
			Category c2 = new Category(null, "comic");
			Category c3 = new Category(null, "war");
			
			repository.save(c1);
			repository.save(c2);
			repository.save(c3);
			
		};
		
		

		
	}

}
