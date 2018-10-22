package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.Book;
import com.example.service.BookService;

@Controller
@RequestMapping("/")
public class ReadingListController {

	private static final Logger logger = LoggerFactory.getLogger(ReadingListController.class);

	private BookService bookService;

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/{reader}", method = RequestMethod.GET)
	public String readersBooks(@PathVariable("reader") String reader, Model model) {
		logger.info("readersBooks");

		List<Book> readingList = bookService.findByReader(reader);

		if (readingList != null) {
			model.addAttribute("books", readingList);
		}

		return "readingList";
	}

	@RequestMapping(value = "/{reader}", method = RequestMethod.POST)
	public String addToReadingList(@PathVariable("reader") String reader, Book book) {
		logger.info("addToReadingList");

		book.setAuthor(reader);
		bookService.save(book);

		return "redirect:/{reader}";
	}

}
