package com.bing;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication// same as @Configuration @EnableAutoConfiguration @ComponentScan
//@ServletComponentScan
@EnableTransactionManagement // 支持事务
@MapperScan(value="com.bing.dao")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@Import(DataSourceRegister.class)
public class Application  extends SpringBootServletInitializer{
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		String[] beanNames = ctx.getBeanDefinitionNames();
		for (String beanName : beanNames) {
            System.out.println(beanName);
        }
	}
	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}
}
