package com.jkxy.entity;

/**
 * 搜索条件
 * 
 * @author Administrator
 *
 */
public class Conditions {

	private String searchKey;
	private int index = 1;
	private String searchCondition;

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

}
