package entities;

public abstract class Entity {
	
	//PROPRIETA
	private int id;
	
	//COSTRUTTORE
	public Entity(int id) {
		setId (id);
	}
	
	//GET
	public int getId() {
		return id;
	}
	
	//SET
	public void setId(int id) {
		this.id = id;
	}
	
	//METODI - TOSTRING
	public String toString() {
		return "\n\tID " + id;
	}
}
