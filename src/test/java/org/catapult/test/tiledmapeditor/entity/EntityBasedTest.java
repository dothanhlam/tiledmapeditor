package org.catapult.test.tiledmapeditor.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class EntityBasedTest {


	public static EntityManagerFactory emf;
	protected EntityManager em;

	@BeforeClass
	public static void setUp() {
		emf = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
	}

	@Before
	public void initEntityManager() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}

	@After
	public void closeEntityManager() {
		em.close();
	}

	@AfterClass
	public static void closeEntityManagerFactory() {
		emf.close();
	}

	public EntityBasedTest() {
		// TODO Auto-generated constructor stub
	}

}
