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
import dao.uow.IUnitOfWorkRepository;
import domain.Entity;
import domain.IHaveId;
import domain.Person;

public abstract class RepositoryBase<TEntity extends Entity>
	implements IUnitOfWorkRepository{


	protected Connection connection;


	IMapResultSetToEntity<TEntity> mapper;
	
	protected Statement createTable;
	protected PreparedStatement insert;
	protected PreparedStatement selectById;
	protected PreparedStatement delete;
	protected PreparedStatement selectAll;
	protected PreparedStatement update;
	protected IUnitOfWork uow;
	
	protected RepositoryBase(Connection conection,
			IMapResultSetToEntity<TEntity> mapper, 
			IUnitOfWork uow){
		try {
			connection.setAutoCommit(false);
			this.uow = uow;
			this.mapper = mapper;
			this.connection = connection;
			createTable = connection.createStatement();
			createTableIfNotExists();
			insert = connection.prepareStatement(getInsertQuery());
			selectById = connection.prepareStatement(getSelectByIdQuery());
			delete = connection.prepareStatement(getDeleteQuery());
			selectAll = connection.prepareStatement(getSelectAllQuery());
			update = connection.prepareStatement(getUpdateQuery());
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
	protected abstract String getUpdateQuery();
	protected abstract void setUpInsert(Entity person) throws SQLException;
	protected abstract void setUpUpdate(Entity p) throws SQLException;


	protected String getDeleteQuery() {
		return "DELETE FROM "
				+ getTableName()
				+ " WHERE id=?";
	}
	protected String getSelectByIdQuery() {
		return "SELECT * FROM "
				+ getTableName()
				+ " WHERE id = ?"; 
	}
	protected String getSelectAllQuery() {
		return "SELECT * FROM "
				+ getTableName();
	}

	public void persistDelete(Entity p){
		try{
			delete.setInt(1, p.getId());
			delete.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void delete(TEntity entity){
		uow.markAsDeleted(entity, this);
	}

	public void persistUpdate(Entity p){
		try{
			setUpUpdate(p);
			update.executeUpdate();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void update(TEntity p){
		uow.markAsChanged(p, this);
	}

	public void persistInsert(Entity person){
		try{
		setUpInsert(person);
		insert.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void add(TEntity entity){
		uow.markAsNew(entity, this);
	}
	

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
