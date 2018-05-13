package com.rushikesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rushikesh.dto.Book;

@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Book> getAll() {
		String sql = "select * from book";
		return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper(Book.class));
	}

	@Override
	public int save(Book book) {
		String sql = "insert into book values(?,?,?)";
		return this.jdbcTemplate.update(sql, new Object[] { "", book.getName(), book.getCode() });
	}

	@Override
	public Book get(int id) {
		String sql = "select * from book where id = ?";

		/*
		 * return(Book) jdbcTemplate.query(sql, new Object[] { id }, new
		 * RowMapper<Book>() {
		 * 
		 * @Override public Book mapRow(ResultSet rs, int row) throws SQLException {
		 * System.out.println("sdhdfhdfh "+row); if (!rs.isBeforeFirst() ) { return
		 * null; } else { Book book=new Book(); book.setId(rs.getInt(1));
		 * book.setName(rs.getString(2)); book.setCode(rs.getString(3)); return book; }
		 * }
		 * 
		 * });
		 */

		return (Book) this.jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper<Book>() {

			@Override
			public Book mapRow(ResultSet rs, int row) throws SQLException {
				System.out.println("sdhdfhdfh " + row);
				
				if (rs == null || !rs.first()) {
					return null;
				} else {
					Book book = new Book();
					book.setId(rs.getInt(1));
					book.setName(rs.getString(2));
					book.setCode(rs.getString(3));
					return book;
				}
												
			}

		});

		// return (Book) this.jdbcTemplate.queryForObject(sql, new Object[] { id }, new
		// BeanPropertyRowMapper(Book.class));
	}

	@Override
	public int update(Book book) {
		String sql = "update book set name=?,code=? where id=?";
		return this.jdbcTemplate.update(sql, new Object[] { book.getName(), book.getCode(), book.getId() });
	}

	@Override
	public int delete(int id) {
		String sql = "delete from book where id = ?";
		return this.jdbcTemplate.update(sql, new Object[] { id });
	}

}
