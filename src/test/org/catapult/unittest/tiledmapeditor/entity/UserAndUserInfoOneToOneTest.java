package org.catapult.unittest.tiledmapeditor.entity;

import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

import org.catapult.app.tiledmapeditor.entity.User;
import org.catapult.app.tiledmapeditor.entity.UserInfo;
import org.catapult.app.tiledmapeditor.utils.MD5;
import org.junit.Assert;
import org.junit.Test;


public class UserAndUserInfoOneToOneTest extends EntityBasedTest {
		
	@Test
	public void createConstrain() throws NoSuchAlgorithmException {
					
		Calendar c = Calendar.getInstance();
		c.set(1980,  1, 1);
		User user = new User("admin", MD5.getMD5Hex("admin"));
		UserInfo userInfo = new UserInfo(user.getId(), "Michael", "Mike", c.getTime());
		user.setUserInfo(userInfo);
		userInfo.setUser(user);
		
		session.save(user);
		session.getTransaction().commit();
		

		User userDb = em.find(User.class, user.getId());
		UserInfo userInfoDb = userDb.getUserInfo();
		Assert.assertEquals(userInfo, userInfoDb);		
	}
}