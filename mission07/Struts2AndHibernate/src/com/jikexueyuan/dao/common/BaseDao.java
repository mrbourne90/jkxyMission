package com.jikexueyuan.dao.common;

import java.util.List;

import com.jikexueyuan.entity.common.PageModel;

public interface BaseDao<T> {

	public void save(T entity);
	public void delete(int id);
	public T get(Integer id);
	public T load(Integer id);
	//返回所有结果
	public List<T> findAll();
	//返回记录数
	public int totalCount();
	//返回分页后的数据
	public PageModel<T> findByPager(int pageNo, int pageSize);
	//查找单个对象
	public T findUnique(String sql);
}
