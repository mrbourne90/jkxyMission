package com.jkxy.poetry.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jkxy.poetry.entity.Poetry;

@Repository("poetryDao")
public interface IPoetryDao {

	Long getRecordCount(HashMap<String, String> params);

	List<Poetry> getPoetry(HashMap<String, Object> params);

}
