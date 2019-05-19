package com.wheeludrive.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "permissions")
public class Permission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERMISSION")
	private int id;


	@Column(name = "intitule")
	private String intitule;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "permission", fetch = FetchType.EAGER)
	private List<PermissionsRole> permissionsRoles;
	
	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}
	
	public List<PermissionsRole> getPermissionsRoles() {
		return this.permissionsRoles;
	}

	public void setPermissionsRoles(List<PermissionsRole> permissionsRoles) {
		this.permissionsRoles = permissionsRoles;
	}

	public PermissionsRole addPermissionsRole(PermissionsRole permissionsRole) {
		getPermissionsRoles().add(permissionsRole);
		permissionsRole.setPermission(this);

		return permissionsRole;
	}

	public PermissionsRole removePermissionsRole(PermissionsRole permissionsRole) {
		getPermissionsRoles().remove(permissionsRole);
		permissionsRole.setPermission(null);

		return permissionsRole;
	}
	
}
