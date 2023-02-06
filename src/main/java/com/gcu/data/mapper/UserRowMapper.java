package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.UsersEntity;

public class UserRowMapper implements RowMapper<UsersEntity>{

	@Override
	public UsersEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new UsersEntity(rs.getLong("ID"),
				rs.getString("USERNAME"),
				rs.getString("PASSWORD"),
				rs.getString("FIRST_NAME"), 
				rs.getString("LAST_NAME"), 
				rs.getString("EMAIL"), 
				rs.getString("ADDRESS"), 
				rs.getString("CITY"), 
				rs.getString("STATE"), 
				rs.getString("ZIPCODE"), 
				rs.getString("PHONE_NUMBER"), 
				rs.getInt("TOTAL_NUM_LISTINGS"), 
				rs.getInt("TOTAL_NUM_SALES"), 
				rs.getInt("TOTAL_REVENUE"));
	}

}
