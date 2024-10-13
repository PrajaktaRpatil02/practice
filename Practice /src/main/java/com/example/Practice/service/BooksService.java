package com.example.Practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.Practice.bean.ResponseBean;
import com.example.Practice.entity.Books;
import com.example.Practice.exception.EntityNotFound;
import com.example.Practice.repository.BooksRepository;

@Service
public class BooksService {

	@Autowired
	private BooksRepository booksRepository;

	public ResponseBean fetchAllBooks() {
		ResponseBean responseBean = new ResponseBean();
		List<Books> booksList = booksRepository.findAll();
		if (ObjectUtils.isEmpty(booksList)) {

			throw new EntityNotFound("Data not found");

		}
		responseBean.setData(booksList);
		responseBean.setMessage("sata fetch");
		return responseBean;

	}

	public ResponseBean saveBooksDetails(Books books) {

		ResponseBean responseBean = new ResponseBean();
		if (ObjectUtils.isEmpty(books)) {
			throw new EntityNotFound("Incorrect Request");

		}
		Books booksDetails = booksRepository.save(books);
		responseBean.setData(booksDetails);
		responseBean.setMessage("Details save succsesfully");
		return responseBean;

	}

	public ResponseBean deleteBooksDetails(Long id) {

		ResponseBean responseBean = new ResponseBean();

		booksRepository.deleteById(id);
		responseBean.setMessage("Data deleted");
		return responseBean;

	}

	public ResponseBean updateBookDetails(Long id, Books bookRequest) {
		ResponseBean responseBean = new ResponseBean();

		Books book = booksRepository.findById(id).get();
		book.setAuthor(bookRequest.getAuthor());
		book.setGenre(bookRequest.getGenre());
		book.setPrice(bookRequest.getPrice());
		book.setRating(bookRequest.getRating());
		book.setTitle(bookRequest.getTitle());

		booksRepository.save(book);
		responseBean.setData(book);
		responseBean.setMessage("Data updated");
		return responseBean;

	}

}
