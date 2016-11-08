package com.jkxy.poetry.entity;

import java.util.Date;

public class Poetry implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String content;
	private String title;
	private Date createdAt;
	private Date updatedAt;
	private Poet poet;

	public Poetry() {
	}

	public Poetry(String content, String title, Date createdAt, Date updatedAt) {
		this.content = content;
		this.title = title;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Poet getPoet() {
		return poet;
	}

	public void setPoet(Poet poet) {
		this.poet = poet;
	}

}
