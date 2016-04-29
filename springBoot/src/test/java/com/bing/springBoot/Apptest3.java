package com.bing.springBoot;

import java.net.URL;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.bing.base.vo.AjaxResult;

public class Apptest3 {
	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:8088/");
		template = new TestRestTemplate();
	}

	@Test
	public void getHello() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString()+"test/", String.class);
		//assertThat(response.getBody(), equalTo("Greetings from Spring Boot!"));
		System.out.println(response.getBody());
	}
	@Test
	public void deleteHello() throws Exception {
		ResponseEntity<String> response = template.exchange(base.toString()+"test/delete", HttpMethod.DELETE, null, String.class);
		//assertThat(response.getBody(), equalTo("Greetings from Spring Boot!"));
		System.out.println(response.getBody());
	}
	@Test
	public void testGetDate() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString()+"test/date", String.class);
		System.out.println(response.getBody());
	}
	@Test
	public void testAddPeople() throws Exception {
		ResponseEntity<String> response = template.exchange(base.toString()+"test/add",HttpMethod.POST, null,String.class);
		System.out.println(response.getBody());
	}
	@Test
	public void testAddPeoples() throws Exception {
		ResponseEntity<String> response = template.exchange(base.toString()+"test/addlist",HttpMethod.POST, null,String.class);
		System.out.println(response.getBody());
	}
	@Test
	public void testgetPeople() throws Exception {
		ResponseEntity<AjaxResult> response = template.getForEntity(base.toString()+"test/getP/e9e6a79e21a34da18bbb8131fcbc348d",AjaxResult.class);
		System.out.println(response.getBody());
	}
	@Test
	public void testgetP() throws Exception {
		ResponseEntity<AjaxResult> response = template.getForEntity(base.toString()+"test/testP",AjaxResult.class);
		System.out.println(response.getBody());
	}
	@After
	public void after(){
		base=null;
		template=null;
		System.gc();
	}
	@Test
	public void testme(){
		String randomAscii = RandomStringUtils.randomAlphabetic(3);
		System.out.println(randomAscii);
	}
}
