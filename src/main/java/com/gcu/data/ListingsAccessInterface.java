package com.gcu.data;

import java.util.List;

public interface ListingsAccessInterface <T>{
	public List<T> findAllNF();
    public List<T> findAll();
    public T findById(Long id);
    public T findById(int id);
    public List<T> findByUser_Id(Long id);
    public List<T> findActiveByUser_Id(Long id);
    public boolean create (T t);
    public int update(T t);
    public boolean delete(T t);
    public int updateStatus(T t);
    
}
