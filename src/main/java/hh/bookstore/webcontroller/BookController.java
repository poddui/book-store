package hh.bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;
import hh.bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@GetMapping("/index")
	public String IndexController(Model model) {
		model.addAttribute("kirjat", repository.findAll())
		return "index.html";
	}
}
