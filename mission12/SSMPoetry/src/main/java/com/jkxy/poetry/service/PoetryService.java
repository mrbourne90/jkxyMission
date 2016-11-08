package com.jkxy.poetry.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jkxy.poetry.dao.IPoetryDao;
import com.jkxy.poetry.entity.Poetry;

@Service
public class PoetryService {

	@Resource
	private IPoetryDao poetryDao;

	public List<Poetry> getPoetry(String condition, String key, int pageNo, int pageSize) {

		// 将参数放入Map中
		HashMap<String, Object> params = new HashMap<>();
		params.put("condition", condition);
		params.put("key", key);
		params.put("offset", ((pageNo - 1)) * pageSize);
		params.put("size", pageSize);
		List<Poetry> pList = null;
		// 调用Dao接口的方法获取结果集
		pList = poetryDao.getPoetry(params);
		return pList;
	}

	public Long getRecordCount(String condition, String key) {

		HashMap<String, String> params = new HashMap<>();
		params.put("condition", condition);
		params.put("key", key);
		// 调用Dao结构方法获取结果条数
		return poetryDao.getRecordCount(params);
	}

}
