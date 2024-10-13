package com.example.Practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practice.bean.ResponseBean;
import com.example.Practice.entity.Books;
import com.example.Practice.service.BooksService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BooksController {

	@Autowired
	private BooksService booksService;

	@GetMapping("/get")
	public ResponseEntity<ResponseBean> fetchAllBooks() {

		return new ResponseEntity<>(booksService.fetchAllBooks(), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<ResponseBean> saveBooksDetails(@RequestBody Books book) {

		return new ResponseEntity<>(booksService.saveBooksDetails(book), HttpStatus.CREATED);
	}

	@DeleteMapping("/deletebook/{id}")
	public ResponseEntity<ResponseBean> deleteBooksDetails(@PathVariable Long id) {

		return new ResponseEntity<>(booksService.deleteBooksDetails(id), HttpStatus.OK);
	}

	@PutMapping("/updatebook/{id}")
	public ResponseEntity<ResponseBean> updateBookDetails(@PathVariable Long id, @RequestBody Books bookRequest) {

		return new ResponseEntity<>(booksService.updateBookDetails(id, bookRequest), HttpStatus.OK);
	}

}
