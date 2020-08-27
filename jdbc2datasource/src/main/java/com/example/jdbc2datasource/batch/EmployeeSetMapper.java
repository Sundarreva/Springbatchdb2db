package com.example.jdbc2datasource.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.example.jdbc2datasource.model.Employee;

public class EmployeeSetMapper implements FieldSetMapper<Employee> {

	@Override
	public Employee mapFieldSet(FieldSet fieldSet) throws BindException {
		
		Employee emp = new Employee();
		emp.setId(fieldSet.readInt(1));
		emp.setEmp_name(fieldSet.readString(2));
		emp.setLevel(fieldSet.readString(3));
		
		return emp;
	}

}
