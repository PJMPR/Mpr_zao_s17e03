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
import domain.Person;

public abstract class RepositoryBase<TEntity> {


	protected Connection connection;


	IMapResultSetToEntity<TEntity> mapper;
	
	protected Statement createTable;
	protected PreparedStatement insert;
	protected PreparedStatement selectById;
	protected PreparedStatement delete;
	protected PreparedStatement selectAll;
	
	protected RepositoryBase(Connection conection,
			IMapResultSetToEntity<TEntity> mapper){
		
		try {

			this.mapper = mapper;
			this.connection = connection;
			createTable = connection.createStatement();
			createTableIfNotExists();
			insert = connection.prepareStatement(getInsertQuery());
			selectById = connection.prepareStatement(getSelectByIdQuery());
			delete = connection.prepareStatement(getDeleteQuery());
			selectAll = connection.prepareStatement(getSelectAllQuery());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void createTableIfNotExists() throws SQLException {
		boolean tableExists = false;
		ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
		while(rs.next()){
			if(getTableName().equalsIgnoreCase(rs.getString("TABLE_NAME"))){
				tableExists=true;
				break;
			}
		}
		
		if(!tableExists)
			createTable.executeUpdate(getCreateTableQuery());
	}
	
	protected abstract String getTableName();
	protected abstract String getCreateTableQuery();
	protected abstract String getInsertQuery();
	protected abstract String getDeleteQuery();
	protected abstract String getSelectByIdQuery();
	protected abstract String getSelectAllQuery();
	
	public TEntity get(int id){
		try{
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			while(rs.next()){
				return mapper.map(rs);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}

	public List<TEntity> getAll(){
		List<TEntity> result = null;
		try{
			
			ResultSet rs = selectAll.executeQuery();
			result = new ArrayList<TEntity>();
			while(rs.next()){
				result.add(mapper.map(rs));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return result;
	}
}
