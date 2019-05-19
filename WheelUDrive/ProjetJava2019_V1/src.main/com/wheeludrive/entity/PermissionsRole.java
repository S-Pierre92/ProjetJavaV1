package com.wheeludrive.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "permissions_roles")
public class PermissionsRole {

	// bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name = "ID_PERMISSION")
	private Permission permission;

	// bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name = "ID_ROLE")
	private Role role;

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	

}
