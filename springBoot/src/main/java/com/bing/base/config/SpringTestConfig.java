package com.bing.base.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.test")
public class SpringTestConfig {
	private String a;
	private String b;

	public String getA() {
		return a;
	}

	public String getB() {
		return b;
	}

}
