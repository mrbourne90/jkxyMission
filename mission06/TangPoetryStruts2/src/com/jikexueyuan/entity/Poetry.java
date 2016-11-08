package com.jikexueyuan.entity;

public class Poetry extends IdEntity {

	private String poetName;
	private String content;
	private String title;

	public String getPoetName() {
		return poetName;
	}

	public void setPoetName(String poetName) {
		this.poetName = poetName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
