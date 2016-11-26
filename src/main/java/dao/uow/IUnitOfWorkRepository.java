package dao.uow;

import domain.Entity;

public interface IUnitOfWorkRepository {

	public void persistInsert(Entity entity);
	public void persistUpdate(Entity entity);
	public void persistDelete(Entity entity);
	
}
