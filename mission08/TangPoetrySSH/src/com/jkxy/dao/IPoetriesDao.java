package com.jkxy.dao;

import com.jkxy.entity.Poetries;
import com.jkxy.entity.common.PageModel;

public interface IPoetriesDao {

	// 返回记录数
	public int count(String hql);

	// 返回分页后的数据
	public PageModel<Poetries> findByPager(int pageNo, int pageSize, String hql);
}
