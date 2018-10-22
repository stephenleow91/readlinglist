package com.example.service;

import java.util.List;

import com.example.domain.Book;

public interface BookService {

	List<Book> findByReader(String reader);

	void save(Book book);

}
