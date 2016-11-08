package com.jkxy.poetry.entity;

import java.util.Date;
import java.util.Set;

public class Poet implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Date createdAt;
	private Date updatedAt;
	private Set<Poetry> poetries;

	public Poet() {
	}

	public Poet(String name, Date createdAt, Date updatedAt) {
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set<Poetry> getPoetries() {
		return poetries;
	}

	public void setPoetries(Set<Poetry> poetries) {
		this.poetries = poetries;
	}

}
