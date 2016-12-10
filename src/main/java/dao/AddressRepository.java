package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.mappers.IMapResultSetToEntity;
import dao.uow.IUnitOfWork;
import domain.Address;
import domain.Entity;

public class AddressRepository extends RepositoryBase<Address> {

	protected AddressRepository(Connection conection,
			IMapResultSetToEntity<Address> mapper, IUnitOfWork uow) {
		super(conection, mapper, uow);
	}

	protected void setUpInsert(Address address) throws SQLException {
		insert.setString(1, address.getCity());
		insert.setString(2, address.getStreet());
		insert.setInt(3, address.getHouseNumber());
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getCreateTableQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getUpdateQuery() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected void setUpUpdate(Address p) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setUpInsert(Entity person) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setUpUpdate(Entity p) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
