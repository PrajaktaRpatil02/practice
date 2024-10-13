package com.example.Practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Practice.entity.Books;

@Repository
public interface BooksRepository  extends JpaRepository<Books, Long>{

}
