package dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mockito.Mockito;
import org.junit.Test;

import dao.mappers.IMapResultSetToEntity;
import dao.uow.IUnitOfWork;
import domain.Person;

public class PersonRepositoryTest extends Mockito {

	
	
	@Test
	public void testGet() throws SQLException {
		
		Connection connection = mock(Connection.class);
		IMapResultSetToEntity<Person> mapper = mock(IMapResultSetToEntity.class);
		IUnitOfWork uow = mock(IUnitOfWork.class);
		PreparedStatement stmt = mock(PreparedStatement.class);
		
		when(connection.prepareStatement(any(String.class))).thenReturn(stmt);
		
		Person person = new Person();
		person.setAge(30);
		person.setId(1);
		person.setName("jan");
		person.setSurname("kowalski");
		
		when(mapper.map(any(ResultSet.class))).thenReturn(person);
		
		PersonRepository sut = new PersonRepository(connection, mapper, uow);
		
		Person result = sut.get(1);
		
		assertEquals("jan", result.getName());
	}

}
