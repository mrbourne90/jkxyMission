package com.jikexueyuan.entity;

import java.io.Serializable;

public class Poetry implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Poet poet;
	private String content;
	private String title;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Poet getPoet() {
		return poet;
	}

	public void setPoet(Poet poet) {
		this.poet = poet;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
