package com.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Book;
import com.example.repository.ReadingListRepository;

@Service
public class BookServiceImpl implements BookService {

	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	private ReadingListRepository readingListRepository;

	@Autowired
	public void setReadingListRepository(ReadingListRepository readingListRepository) {
		this.readingListRepository = readingListRepository;
	}

	@Override
	public List<Book> findByReader(String reader) {
		logger.info("findByReader");

		List<Book> readingList = readingListRepository.findByReader(reader);
		return readingList;
	}

	@Override
	public void save(Book book) {
		logger.info("save");

		readingListRepository.save(book);
	}

}
