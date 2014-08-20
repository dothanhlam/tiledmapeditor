package org.catapult.test.tiledmapeditor.entity;

import java.util.Date;

import org.catapult.app.tiledmapeditor.entity.Project;
import org.junit.Assert;
import org.junit.Test;

public class ProjectTest extends EntityBasedTest {

	@Test
	public void testPersist() {
		Project project = new Project();
		String projectId = project.getId();
		
		em.persist(project);
		em.getTransaction().commit();
		
		Project projectDB = em.find(Project.class, projectId);
		Assert.assertNotNull(projectDB);
	}
	
	@Test
	public void testUpdate() {
		Project project = new Project();
		String projectId = project.getId();
		
		Date creationDate = project.getCreationDate();
		Date lastUpdate = project.getLastUpdate();
		
		em.persist(project);
		em.getTransaction().commit();
	
		Project projectToBeUpdated = em.find(Project.class, projectId);
		projectToBeUpdated.setName("updated project");
				
		em.getTransaction().begin();
		em.persist(projectToBeUpdated);
		em.getTransaction().commit();
		
		Assert.assertNotEquals(projectToBeUpdated.getLastUpdate(), lastUpdate);
		Assert.assertEquals(projectToBeUpdated.getCreationDate(), creationDate);
	}
}
