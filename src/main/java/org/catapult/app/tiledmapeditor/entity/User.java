package org.catapult.app.tiledmapeditor.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7590680496739079005L;

	@Id
	private String id;
	@Length(max=512)
	@NotEmpty	
	private String username;
	@Length(min=6, max=128)
	@NotEmpty
	private String password; // md5 hash
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="user", cascade=CascadeType.ALL)
	private UserInfo userInfo;
	
	public User() {};
	
	public User(String username, String password) {
		this.id = UUID.randomUUID().toString();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
