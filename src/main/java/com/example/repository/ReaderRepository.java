package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Reader;

public interface ReaderRepository extends JpaRepository<Reader, String> {

	Reader findByUsername(String username);

}
