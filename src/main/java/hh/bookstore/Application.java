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
		public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) 
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
			
		};

		
	}

}
