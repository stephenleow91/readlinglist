package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Reader;
import com.example.repository.ReaderRepository;

@Service
public class ReaderServiceImpl implements ReaderService {

	private static final Logger logger = LoggerFactory.getLogger(ReaderServiceImpl.class);

	private ReaderRepository readerRepository;

	@Autowired
	public void setReaderRepository(ReaderRepository readerRepository) {
		this.readerRepository = readerRepository;
	}

	@Override
	public Reader findByUsername(String username) {
		logger.info("findByUsername");

		return readerRepository.findByUsername(username);
	}

}
