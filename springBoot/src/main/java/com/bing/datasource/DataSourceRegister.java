/*package com.bing.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

public class DataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware{
	// 如配置文件中未指定数据源类型，使用该默认值
		private static final Object DATASOURCE_TYPE_DEFAULT = "org.apache.tomcat.jdbc.pool.DataSource";
		// 数据源
		private DataSource defaultDataSource;
		@Override
		public void setEnvironment(Environment env) {
			RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
			
			Map<String, Object> dsMap = new HashMap<>();
			dsMap.put("type", propertyResolver.getProperty("type"));
			dsMap.put("driver-class-name", propertyResolver.getProperty("driver-class-name"));
			dsMap.put("url", propertyResolver.getProperty("url"));
			dsMap.put("username", propertyResolver.getProperty("username"));
			dsMap.put("password", propertyResolver.getProperty("password"));

			defaultDataSource = buildDataSource(dsMap);
			
			//dataBinder(defaultDataSource, env);
		}

		@Override
		public void registerBeanDefinitions(AnnotationMetadata arg0,
				BeanDefinitionRegistry arg1) {
			
			
		}
		@SuppressWarnings("unchecked")
		public DataSource buildDataSource(Map<String, Object> dsMap) {
			try {
				Object type = dsMap.get("type");
				if (type == null)
					type = DATASOURCE_TYPE_DEFAULT;// 默认DataSource

				Class<? extends DataSource> dataSourceType;
				dataSourceType = (Class<? extends DataSource>) Class.forName((String) type);

				String driverClassName = dsMap.get("driver-class-name").toString();
				String url = dsMap.get("url").toString();
				String username = dsMap.get("username").toString();
				String password = dsMap.get("password").toString();

				DataSourceBuilder factory = DataSourceBuilder.create().driverClassName(driverClassName).url(url)
						.username(username).password(password).type(dataSourceType);
				return factory.build();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return null;
		}
}
*/