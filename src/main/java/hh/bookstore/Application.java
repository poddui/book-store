package hh.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.bookstore.domain.Book;
import hh.bookstore.domain.BookRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
		@Bean
		public CommandLineRunner demo(BookRepository repository) 
		{return (args) -> {
			Book k1 = new Book("Testikirja1", "Joonas Mäki", 2000, "304509", 13.40);
			Book k2 = new Book("Testikirja2", "Jarkko Oja", 2002, "304355", 13.40);
			Book k3 = new Book("Testikirja3", "Jussi Matka", 2004, "304534", 13.40);
			
			repository.save(k1);
			repository.save(k2);
			repository.save(k3);
			
		};
		

		
	}

}
