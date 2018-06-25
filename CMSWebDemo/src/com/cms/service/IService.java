package com.cms.service;

import java.util.List;

public interface IService<T> {

	int save(T t);
	List<T> getList();
	int update(T t);
	int delete(int id);
	T get(long id);
}
