package com.spring.dao;

import java.util.List;

public interface BaseDAO<T> {
	List<T> getList();
}
