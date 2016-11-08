package com.jkxy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jkxy.dao.IPoetriesDao;
import com.jkxy.entity.Poetries;
import com.jkxy.entity.common.PageModel;
import com.jkxy.service.IPoetriesService;

@Service
public class PoetriesService implements IPoetriesService {

	@Resource
	private IPoetriesDao poetriesDao;

	@Override
	public PageModel<Poetries> getResults(String condition, String key, int pageNo, int pageSize) {

		PageModel<Poetries> results = null;
		String hql = null;
		// 根据不同的条件生成不同的查询语句
		if (condition.equals("poet")) {
			hql = "select a from Poetries a left join fetch a.poet b where b.name='" + key + "'";
		} else if (condition.equals("title")) {
			hql = "select a from Poetries a left join fetch a.poet b where a.title ='" + key + "'";
		} else if (condition.equals("content")) {
			hql = "select a from Poetries a left join fetch a.poet b where a.content like '%" + key + "%'";
		}
		// 调用DAO获取结果
		results = poetriesDao.findByPager(pageNo, pageSize, hql);
		return results;
	}

	public IPoetriesDao getPoetriesDao() {
		return poetriesDao;
	}

	public void setPoetriesDao(IPoetriesDao poetriesDao) {
		this.poetriesDao = poetriesDao;
	}

}
