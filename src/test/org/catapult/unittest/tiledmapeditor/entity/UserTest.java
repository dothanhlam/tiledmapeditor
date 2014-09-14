package org.catapult.unittest.tiledmapeditor.entity;

import java.security.NoSuchAlgorithmException;

import org.catapult.app.tiledmapeditor.entity.User;
import org.catapult.app.tiledmapeditor.utils.MD5;
import org.junit.Assert;
import org.junit.Test;

public class UserTest extends EntityBasedTest {

	@Test
	public void testPersist() throws NoSuchAlgorithmException {
		User user = new User("admin", MD5.getMD5Hex("admin"));
		em.persist(user);
		em.getTransaction().commit();

		User userDB = em.find(User.class, user.getId());
		Assert.assertEquals(user.getId(), userDB.getId());
	}

	@Test
	public void testUpdate() throws NoSuchAlgorithmException {
		User user = new User("admin", MD5.getMD5Hex("admin"));
		String password = user.getPassword();
		String userId = user.getId();
		em.persist(user);
		em.getTransaction().commit();

		em = emf.createEntityManager();
		em.getTransaction().begin();
		User userDb = em.find(User.class, userId);
		userDb.setPassword(MD5.getMD5Hex("test"));
		em.merge(userDb);
		em.getTransaction().commit();

		Assert.assertNotEquals(password, userDb.getPassword());
	}

	@Test
	public void testRemove() throws NoSuchAlgorithmException {
		User user = new User("admin", MD5.getMD5Hex("admin"));
		String userId = user.getId();
		em.persist(user);
		em.getTransaction().commit();
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		User userDb = em.find(User.class, userId);
		em.remove(userDb);
		em.getTransaction().commit();
		
		Assert.assertNull(em.find(User.class, userId));
	}
}