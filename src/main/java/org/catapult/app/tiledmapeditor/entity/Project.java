package org.catapult.app.tiledmapeditor.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="project")
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8857804866758853841L;

	@Id
	private String id;
	
	@Length(max=512)
	@Column(name="name")
	private String name;
	
	@Length(max=1024)
	@Column(name="description")
	private String description;
		
	@Column(name="creation_date")
	private Date creationDate;
		
	@Column(name="last_update")
	private Date lastUpdate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false, insertable=false, updatable=false)
	private User user;
	
	public Project() {
		this.id = UUID.randomUUID().toString();
		this.name = "default project";
		this.description = "default project";
		creationDate = Calendar.getInstance().getTime();
		lastUpdate = creationDate;
	}
	
	public Project(String name, String description) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.description = description;
		creationDate = Calendar.getInstance().getTime();
		lastUpdate = creationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		lastUpdate = Calendar.getInstance().getTime();
		this.name = name;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		lastUpdate = Calendar.getInstance().getTime();
		this.user = user;
	}

	public String getId() {
		return id;
	}
}
