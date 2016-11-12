package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

import domain.Address;

public class AddressRepository {
	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	private Connection connection;
	private Statement createTable;
	
	private String createTableSql = (
        "CREATE TABLE Address(" +
            "id BIGINT GENERATED BY DEFAULT AS IDENTITY," +
            "city VARCHAR(200)," +
            "street VARCHAR(255)," +
            "house_number INT" +
        ")"
    );

    private PreparedStatement selectById;
    private PreparedStatement deleteById;
	private PreparedStatement insert;

    private String selectByIdSql = "select * from Address where id = ?";
	private String insertSql ="INSERT INTO Address (city, street, house_number) VALUES(?,?,?)";
	private String deleteSql = "DELETE FROM Address WHERE id = ?";
	
	public AddressRepository() {
		try {
			connection = DriverManager.getConnection(url);
			createTable = connection.createStatement();

            selectById = connection.prepareStatement(selectByIdSql);
            deleteById = connection.prepareStatement(deleteSql);
            insert = connection.prepareStatement(insertSql);

			boolean tableExists = false;
			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			while(rs.next()){
				if("Address".equalsIgnoreCase(rs.getString("TABLE_NAME"))){
					tableExists=true;
					break;
				}
			}
			
			if(!tableExists)
				createTable.executeUpdate(createTableSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Address get(int id){
		Address result = null;
		try{
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			while(rs.next()){
				result = new Address();
				result.setId(rs.getInt("id"));
				result.setCity(rs.getString("city"));
				result.setStreet(rs.getString("street"));
				result.setHouseNumber(rs.getInt("house_number"));
				return result;
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public void delete(Address p){
		try{
			deleteById.setInt(1, p.getId());
			deleteById.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void add(Address address){
		try{
            insert.setString(1, address.getCity());
            insert.setString(2, address.getStreet());
            insert.setInt(3, address.getHouseNumber());
            insert.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
}
