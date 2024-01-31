package dao;

import java.util.List;

import entities.Entity;

public interface IDAO {
	
	public List<Entity> read();
	public boolean delete(int id);
	public boolean update(Entity e);
	public boolean create(Entity e);

}
