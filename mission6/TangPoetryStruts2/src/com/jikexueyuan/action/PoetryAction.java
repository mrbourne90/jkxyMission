package com.jikexueyuan.action;

import java.util.List;
import com.jikexueyuan.entity.Poetry;
import com.jikexueyuan.service.PoetryService;
import com.jikexueyuan.util.Page;
import com.opensymphony.xwork2.ActionSupport;

public class PoetryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String searchKey;
	private String index;
	private String searchCondition;
	private List<Poetry> poetries;
	private Page page;

	@Override
	public String execute() throws Exception {

		String condition = searchCondition;
		String key = searchKey;
		List<Poetry> poetries = null;
		PoetryService pService = new PoetryService();
		int pageIndex = 1;
		int totalRow = 0;
		Page page = null;
		
		if (null != index) {
			pageIndex = Integer.parseInt(index);
		}
		if(condition.equals("poet")){
			totalRow = pService.countByPoet(key);
			page = new Page(totalRow, pageIndex, 10);
			poetries = pService.queryByPoet(key,page);
		}else if (condition.equals("title")) {
			totalRow = pService.countByTitle(key);
			page = new Page(totalRow, pageIndex, 10);
			poetries = pService.queryByTitle(key,page);
		}else{
			totalRow = pService.countByContent(key);
			page = new Page(totalRow, pageIndex, 10);
			poetries = pService.queryByContent(key,page);
		}
		// 将结果放到action属性中
		this.poetries = poetries;
		this.page = page;
		if (!poetries.isEmpty()) {
			return SUCCESS;
		} else {
			return "fail";
		}
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public List<Poetry> getPoetries() {
		return poetries;
	}

	public Page getPage() {
		return page;
	}
}
