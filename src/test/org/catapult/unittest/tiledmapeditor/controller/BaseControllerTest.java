package org.catapult.unittest.tiledmapeditor.controller;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
@WebAppConfiguration
public class BaseControllerTest {

	protected MockMvc mockMvc;

	public BaseControllerTest() {
	}

}
