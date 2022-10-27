package com.sel.bm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sel.bm.DAO.BookDAO;
import com.sel.bm.DAO.BookDAOImpl;
import com.sel.bm.api.Book;

@Controller
public class BookController {

	@Autowired
	private BookDAO BookDAO = new BookDAOImpl();

	@GetMapping("/")
	public String getIndex() {
		return "index";
	}

	// controller to get all the books in the page showBook
	@GetMapping("/showBook")
	public String showBookList(Model model) {

		List<Book> bookList = BookDAO.loadBooks();

//		for (Book tempBook : bookList) {
//			System.out.println(tempBook);
//		}

		model.addAttribute("books", bookList);

		return "book-list";
	}

	// controller to get all the books in the page showBook
	@GetMapping("/bookform")
	public String showForm(Model m) {
		m.addAttribute("command", new Book());
		return "bookform";
	}

	//insert new book function
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("book") Book book) {
		BookDAO.save(book);
		return "redirect:/showBook";// will redirect to show book list
	}
	
	//connected with function below to pass selected book
	@RequestMapping(value = "editbook/{id}", method = RequestMethod.GET)
	public String editredirect(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		Book book = BookDAO.getBookById(id);
		redirectAttributes.addAttribute("id", id);
		redirectAttributes.addFlashAttribute("book", book);
		return "redirect:/bookeditform";
	}
	
	//controller to redirect to edit form
	@GetMapping("/bookeditform")
	public String goeditform() {
		return "bookeditform";
	}

	//update book values to the database function
	@RequestMapping(value = "/updatebook", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("book") Book book) {
		BookDAO.update(book);
		return "redirect:/showBook";
	}
	
	//update book values to the database function
	@RequestMapping(value = "/deletebook/{id}")
	public String editsave(@PathVariable("id") int id) {
		Book book = BookDAO.getBookById(id);
		BookDAO.delete(book);
		return "redirect:/showBook";
	}
	
	
}
