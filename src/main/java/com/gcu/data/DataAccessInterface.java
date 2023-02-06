package com.gcu.data;

import java.util.List;

public interface DataAccessInterface <T> {

	public List<T> findAll();
	public T findByUsername(String username);
	public T findByEmail(String email);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);

}
