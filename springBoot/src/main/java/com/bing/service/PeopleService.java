package com.bing.service;

import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bing.dao.PeopleModelMapper;
import com.bing.model.PeopleModel;

@Service
@Transactional
public class PeopleService {
	@Autowired
	private PeopleModelMapper peopleModelMapper;
	private final static Logger logger = LoggerFactory
			.getLogger(PeopleService.class);

	/**
	 * @param name
	 * @return
	 */
	@Transactional
	public PeopleModel addNew(String name) {
		PeopleModel model = new PeopleModel();
		model.setName(name);
		model.setAge(23);
		model.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		peopleModelMapper.insert(model);
		throwsE();
		return model;
	}

	@Transactional
	public void addList() {
		logger.debug("add list");
		for (int i = 0; i < 5; i++) {
			String name = RandomStringUtils.randomAlphabetic(3);
			addNew(name);
		}
		
	}
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public PeopleModel getById(String id) {
		PeopleModel model = peopleModelMapper.getById(id);
		return model;
	}

	private void throwsE() {
		if (Math.random() > 0.5) {
			throw new RuntimeException();
		}
	}
}
