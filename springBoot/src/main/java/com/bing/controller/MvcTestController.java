package com.bing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bing.base.vo.AjaxResult;
import com.bing.model.PeopleModel;
import com.bing.service.PeopleService;
import com.bing.service.TestService;

@RestController
@RequestMapping("/test")
public class MvcTestController {
	@Autowired
	TestService serverice;
	@Autowired
	PeopleService peopleService;
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home() {
		return "Hello World!";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String delete() {
		return "Hello delete";
	}

	@RequestMapping(value = "/date", method = RequestMethod.GET)
	public AjaxResult getdate() {
		return AjaxResult.okResult(serverice.getDate());
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public AjaxResult addPeople(){
		PeopleModel p = peopleService.addNew("hello2");
		return AjaxResult.okResult(p);
	}
	@RequestMapping(value = "/addlist", method = RequestMethod.POST)
	public AjaxResult addPeoples(){
		peopleService.addList();
		return AjaxResult.okResult(null);
	}
	@RequestMapping(value = "/getP/{id}", method = RequestMethod.GET)
	public AjaxResult getPeople(@PathVariable String id){
		
		return AjaxResult.okResult(peopleService.getById(id));
	}
	@RequestMapping(value = "/testP", method = RequestMethod.GET)
	public AjaxResult testProperty(){
		serverice.addEbs();
		serverice.getSysV();
		return AjaxResult.okResult();
	}
	
}
