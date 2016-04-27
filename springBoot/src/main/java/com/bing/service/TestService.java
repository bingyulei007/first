package com.bing.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bing.base.config.EpicConfig;
import com.bing.base.config.SpringTestConfig;

@Service
public class TestService {
	private final static Logger logger = LoggerFactory
			.getLogger(TestService.class);

	@Autowired
	private EpicConfig epicConfig;
	@Value("${system.property.value}")
	private String systemV;
	@Autowired
	private SpringTestConfig testConfig;

	public Date getDate() {
		double random = Math.random();
		if (random > 0.5) {
			throw new RuntimeException("for test exception");
		}
		return new Date();
	}

	public void addEbs() {
		logger.debug("create ebs");
		System.out.println(epicConfig.getOpenstackRemoteUrl());
		logger.info("the result is successful");
	}

	public void getSysV() {
		System.out.println(systemV);
	}
}
