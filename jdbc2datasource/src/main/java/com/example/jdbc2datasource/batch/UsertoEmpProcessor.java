package com.example.jdbc2datasource.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.jdbc2datasource.model.Employee;
import com.example.jdbc2datasource.model.Userdata;

@Component
public class UsertoEmpProcessor implements ItemProcessor<Userdata, Employee> {

	@Override
	public Employee process(Userdata item) throws Exception {
		System.out.println("Processor" + item);
		Employee emp = new Employee();
		emp.setId(item.getId());
		emp.setEmp_name(item.getUser());
		emp.setLevel(item.getDesignation());
		return emp;
	}

}
