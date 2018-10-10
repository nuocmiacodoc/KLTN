package com.packt.webbi.domain;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = 2284040482222162898L;

	private int roleId;
	private String name;
	private String role;

	public Role(int id) {
		this.roleId = id;
	}

	public Role() {
		super();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
