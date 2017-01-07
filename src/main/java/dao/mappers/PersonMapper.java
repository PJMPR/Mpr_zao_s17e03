package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Person;

public class PersonMapper implements IMapResultSetToEntity<Person>{

	public Person map(ResultSet rs) throws SQLException {
		Person result = new Person();
		result.setId(rs.getInt("id"));
		result.setName(rs.getString("name"));
		result.setSurname(rs.getString("surname"));
		result.setAge(rs.getInt("age"));
		return result;
	}

}
