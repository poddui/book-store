package hh.bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@GetMapping("/index")
	public String IndexController() {
		return "index.html";
	}
	
	@GetMapping("/booklist")
	public String BooklistController(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
}
