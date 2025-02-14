package com.example.jdbc2datasource.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {

	@Bean(name = "testDs")
	@ConfigurationProperties(prefix = "spring.datasource1")
	public DataSource getTestDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "test1Ds")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource2")
	public DataSource getTest1DataSource() {
		return DataSourceBuilder.create().build();
	}
	
}
