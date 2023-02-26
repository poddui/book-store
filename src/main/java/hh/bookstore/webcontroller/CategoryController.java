package hh.bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hh.bookstore.domain.Category;
import hh.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository repository;
	
	@GetMapping("/categorylist")
	public String CategoryFinder(Model model) {
		model.addAttribute("categories", repository.findAll());
		return "categorylist.html";
	}
	@RequestMapping(value = "/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("categories", new Category());
		return "addcategory.html";
	}
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String saveCategory(Category category) {
		repository.save(category);
		return "redirect:categorylist";
	}
	@RequestMapping(value = "/deletecategory/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") Long categoryid, Model model) {
		repository.deleteById(categoryid);
		return "redirect:../categorylist";
	}

	
}
