package entities;

// Classe Modello: Questa classe rispecchia la colonna id PK delle tabelle di SQL.
// Un oggetto solo Entity non mi serve a nulla, la classe mi serve solo dal punto di vista
// strutturale. Per questo motivo rendo la classe ASTRATTA grazie all'aggiunta del termine ABSTRACT
// Le classi astratte funzionano come classi "normali" (classi concrete) tranne che impediscono la 
// creazione di oggetti (nella pratica non potremo mai fare Entity e = new Entity())
// La caratteristica ABSRTACT non si eredita
public abstract class Entity {
	
	private int id;
	
	public Entity(int id) {
		setId(id);;
	}
	
	public int getID() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "\n\tID " + id;
	}
}
