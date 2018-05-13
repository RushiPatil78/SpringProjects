package com.rushikesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushikesh.dao.BookDao;
import com.rushikesh.dto.Book;
@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookDao bookDao;
	@Override
	public List<Book> getAll() {
		return this.bookDao.getAll();
	}
	@Override
	public int save(Book book) {
		return this.bookDao.save(book);
	}
	@Override
	public Book get(int id) {
		return this.bookDao.get(id);
	}
	@Override
	public int update(Book book) {
		return this.bookDao.update(book);
	}
	@Override
	public int delete(int id) {
		return this.bookDao.delete(id);
	}
}
