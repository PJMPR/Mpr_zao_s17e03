import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import org.mockito.Mockito;

import dao.uow.UnitOfWork;


public class UnitOfWorkTest extends Mockito{

	@Test
	public void commitTest() throws SQLException {
		Connection connection = mock(Connection.class);
		
		UnitOfWork sut = new UnitOfWork(connection);
		
		sut.saveChanges();
		
		verify(connection).commit();
	}

}
