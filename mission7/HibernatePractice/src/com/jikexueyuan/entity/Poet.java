package com.jikexueyuan.entity;

import java.io.Serializable;
import java.util.Set;

public class Poet implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Set<Poetry> poetries;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Poetry> getPoetries() {
		return poetries;
	}

	public void setPoetries(Set<Poetry> poetries) {
		this.poetries = poetries;
	}

}
