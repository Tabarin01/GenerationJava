package entities;

public class ContenutoMultimediale {
	
	String titolo;
	
	public ContenutoMultimediale(String titolo) 
	{
		setTitolo(titolo);
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	@Override
	public String toString() {
		return "\nTitolo: " + titolo;
	}
	
	
	
	

}
