package com.cms.dao;

import java.util.List;

public interface BaseDAO<T> {
	int save(T t);
	int update(T t);
	int delete(int id);
	List<T> getList();
	T get(long id);
}
