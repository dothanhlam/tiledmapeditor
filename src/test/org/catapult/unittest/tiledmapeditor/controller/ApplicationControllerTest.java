package org.catapult.unittest.tiledmapeditor.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.catapult.app.tiledmapeditor.controller.ApplicationController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationControllerTest extends BaseControllerTest {

	@InjectMocks
	private ApplicationController controller;
		
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void defaultURLShouldBeHandled() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index.html"));
	}
	
	@Test
	public void unexpectedURLShouldBeReturnedBy404() throws Exception {
		mockMvc.perform(get("/foo")).andExpect(status().isNotFound());
	}
	
	@Test
	public void defaultURLShouldNotBePost() throws Exception {
		mockMvc.perform(post("/")).andExpect(status().is(405));
	}
}