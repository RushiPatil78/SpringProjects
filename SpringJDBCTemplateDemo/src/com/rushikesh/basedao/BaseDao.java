package com.rushikesh.basedao;

import java.util.List;

public interface BaseDao<T> {
	
	int save(T t);
	T get(int id);
	int update(T t);
	List<T> getAll();
	int delete(int id);
}
