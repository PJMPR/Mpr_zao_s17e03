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
import domain.Address;

public class AddressRepository extends RepositoryBase<Address> {

	protected AddressRepository(Connection conection,
			IMapResultSetToEntity<Address> mapper) {
		super(conection, mapper);
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
	
	@Override
	protected void setUpUpdate(Address p) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
