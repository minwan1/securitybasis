package com.wan.basis.dto;

public class UserPermission {

	private Long id;
	private String name;

	public UserPermission(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
