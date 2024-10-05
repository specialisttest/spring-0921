package ru.specialist.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CourseRowMapper  implements RowMapper<Course>{

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Course( rs.getInt("id"),
				rs.getString("title"),
				rs.getInt("length"),
				rs.getString("description"));
	}

}
