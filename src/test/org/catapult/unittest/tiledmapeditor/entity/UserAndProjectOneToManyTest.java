package org.catapult.unittest.tiledmapeditor.entity;

import java.security.NoSuchAlgorithmException;

import org.catapult.app.tiledmapeditor.entity.Project;
import org.catapult.app.tiledmapeditor.entity.User;
import org.catapult.app.tiledmapeditor.utils.MD5;
import org.junit.Assert;
import org.junit.Test;

public class UserAndProjectOneToManyTest extends EntityBasedTest {

	@Test
	public void createConstrain() {
		try {
			User user = new User("admin", MD5.getMD5Hex("admin"));
			Project firstProject = new Project("first project", "the first project for testing");
			Project secondProject = new Project("second project", "the second project for testing");
			
			
			firstProject.setUser(user);
			secondProject.setUser(user);
			
			session.save(user);
			session.save(firstProject);
			session.save(secondProject);
			
			session.getTransaction().commit();
			
			User userHasOwnedFirstProject = firstProject.getUser();
			User userHasOwnedSecondProject = secondProject.getUser();
			
			Assert.assertEquals(user.getId(), userHasOwnedFirstProject.getId());
			Assert.assertEquals(user.getId(), userHasOwnedSecondProject.getId());
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}