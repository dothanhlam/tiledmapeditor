package org.catapult.app.tiledmapeditor.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="user_info")
public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6413268640843853044L;

	@Id
	@Column(name="user_id", unique=true, nullable=false)
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="user"))  
	private String userId;
	
	@Length(max=512)
	@Column(name="first_name")
	private String firstName;
	
	@Length(max=512)
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
    private User user;
	
	public UserInfo() {
	}

	public UserInfo(String userId, String firstName, String lastName, Date dateOfBirth) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	public UserInfo(String firstName, String lastName, Date dateOfBirth) {	
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
		
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
