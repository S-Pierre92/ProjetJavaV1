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
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROLE")
	private int id;
	
	@Column(name = "intitule")
	private String intitule;
	
	@OneToMany(mappedBy="role", fetch=FetchType.EAGER)
	private List<Utilisateur> utilisateurs;
	
	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private List<PermissionsRole> permissionsRoles;
	
	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
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
		permissionsRole.setRole(this);

		return permissionsRole;
	}

	public PermissionsRole removePermissionsRole(PermissionsRole permissionsRole) {
		getPermissionsRoles().remove(permissionsRole);
		permissionsRole.setRole(null);

		return permissionsRole;
	}
	
	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setRole(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setRole(null);

		return utilisateur;
	}
	
}
