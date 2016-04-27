package com.bing.base.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(locations="classpath:config/epic.properties")
public class EpicConfig {
	private String openstackRemoteUrl;

	public String getOpenstackRemoteUrl() {
		return openstackRemoteUrl;
	}


}
