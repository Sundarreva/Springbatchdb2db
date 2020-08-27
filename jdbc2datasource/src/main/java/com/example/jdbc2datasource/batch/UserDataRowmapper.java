package com.example.jdbc2datasource.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.jdbc2datasource.model.Userdata;

@Component
public class UserDataRowmapper implements RowMapper<Userdata> {

	@Override
	public Userdata mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Userdata user = new Userdata();
		user.setId(rs.getInt(1));
		user.setUser(rs.getString(2));
		user.setDesignation(rs.getString(3));
		return user;
	}

}
