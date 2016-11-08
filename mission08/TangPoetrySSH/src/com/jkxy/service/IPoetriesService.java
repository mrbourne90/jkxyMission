package com.jkxy.service;

import com.jkxy.entity.Poetries;
import com.jkxy.entity.common.PageModel;

public interface IPoetriesService {

	public PageModel<Poetries> getResults(String condition, String key, int pageNo, int pageSize);

}
