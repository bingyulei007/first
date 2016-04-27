package com.bing.springBoot;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bing.controller.MvcTestController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class AppTest 
{
	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new MvcTestController()).build();
	}

	@Test
	public void getHello() throws Exception {
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/test/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())	;
		System.out.println(resultActions.andReturn().getResponse().getContentAsString());
	}
	@Test
	public void deleteHello() throws Exception {
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.delete("/test/delete").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())	;
		System.out.println(resultActions.andReturn().getResponse().getContentAsString());
	}
	@Test
	public void testGetDate() throws Exception {
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/test/date").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())	;
		System.out.println(resultActions.andReturn().getResponse().getContentAsString());
	}
}
