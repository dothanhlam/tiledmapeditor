package org.catapult.test.tiledmapeditor.entity;

import java.util.Calendar;
import java.util.UUID;

import org.catapult.app.tiledmapeditor.entity.UserInfo;
import org.junit.Assert;
import org.junit.Test;

public class UserInfoTest extends EntityBasedTest {
	
	@Test
	public void testPersist() {
		String userId = UUID.randomUUID().toString();
		Calendar c = Calendar.getInstance();
		c.set(1980, 1, 1); 
		UserInfo userInfo = new UserInfo(userId, "Michael", "Mike", c.getTime());
	
		em.persist(userInfo);
		em.getTransaction().commit();
		
		UserInfo userInfoDb = em.find(UserInfo.class, userId);
		
		Assert.assertEquals(userInfo.getFirstName(), userInfoDb.getFirstName());
	}
	
	@Test
	public void testUpdate() {
		
	}
}
