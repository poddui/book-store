package hh.bookstore.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.bookstore.domain.Book;
import hh.bookstore.domain.BookRepository;
import hh.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	@GetMapping("/index")
	public String IndexController() {
		return "index.html";
	}
	
	// RESTful service to get all books
    @RequestMapping(value="jsonbooks", method = RequestMethod.GET)
    public @ResponseBody List<Book> studentListRest() {
        return (List<Book>) repository.findAll();
    }

    // RESTful service to get find by id
    @RequestMapping (value ="jsonbooks/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional <Book> findBookRest(@PathVariable("id") Long id){
        return repository.findById(id);
    }
	
	@GetMapping("/booklist")
	public String BooklistController(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBook(Model model) {
		model.addAttribute("books", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	
	
}
