package com.rushikesh.baseservice;

import java.util.List;

public interface BaseService<T> {
	int save(T t);
	T get(int id);
	int update(T t);
	List<T> getAll();
	int delete(int id);
}
