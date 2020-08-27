package com.example.jdbc2datasource.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.jdbc2datasource.batch.UserDataRowmapper;
import com.example.jdbc2datasource.model.Employee;
import com.example.jdbc2datasource.model.Userdata;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	JobBuilderFactory jbf;
	
	@Autowired
	StepBuilderFactory sbf;
	
	@Autowired
	@Qualifier("testDs")
	DataSource userDataSource;
	
	@Autowired
	@Qualifier("test1Ds")
	DataSource employeeDataSource;
		
	@Bean
	public Job job(JobBuilderFactory jbf, StepBuilderFactory sbf,
			ItemReader<Userdata> reader, 
			ItemProcessor<Userdata,Employee> processor,
			ItemWriter<Employee> writer,
			JobExecutionListener listener) {

		Step step = sbf.get("Step")
				.<Userdata,Employee>chunk(1)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
		
		return jbf.get("DbtoDB").incrementer(new RunIdIncrementer()).listener(listener).start(step).build();	
	}
	
	@Bean
	public ItemReader<Userdata> read() {
	
		JdbcCursorItemReader<Userdata> reader = new JdbcCursorItemReader<Userdata>();
		//reader.open(new ExecutionContext());
		//reader.setName("UserdataReader");
		reader.setDataSource(userDataSource);
		reader.setSql("SELECT * FROM userdata");
		reader.setRowMapper(new UserDataRowmapper());
	
		return reader;
	}
	
	@Bean
	public JdbcBatchItemWriter<Employee> writer() {
		JdbcBatchItemWriter<Employee> writer = new JdbcBatchItemWriter<Employee>();
		writer.setDataSource(employeeDataSource);
		writer.setSql("INSERT INTO employee (ID, emp_name, level) VALUES (:id, :emp_name, :level)");
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
		return writer;
	}


}
