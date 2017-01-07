package dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import dao.mappers.IMapResultSetToEntity;
import dao.mappers.PersonMapper;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;
import domain.Person;

public class PersonRepositoryCRUDTest {

	@Test
	public void testAdd() {
		try {
		Connection	connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
		
		IMapResultSetToEntity<Person> mapper = new PersonMapper();
		IUnitOfWork uow = new UnitOfWork(connection);
		PersonRepository repo = new PersonRepository(connection, mapper, uow);
		Person p = new Person();
		p.setName("jan");
		p.setSurname("kowalski");
		p.setAge(30);
		
		repo.add(p);
		uow.saveChanges();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
