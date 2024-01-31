package entities;

public class Veicolo {
	
	 private String linea;
	 private int postiSedere;
	 private int postiPiedi;
	 private boolean notturno;
	 
	 
	public Veicolo(String linea, int postiSedere, int postiPiedi, boolean notturno) {
		
		setLinea(linea);
		setPostiSedere(postiSedere);
		setPostiPiedi(postiPiedi);
		setNotturno(notturno);
	}


	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public int getPostiSedere() {
		return postiSedere;
	}
	public void setPostiSedere(int postiSedere) {
		this.postiSedere = postiSedere;
	}
	public int getPostiPiedi() {
		return postiPiedi;
	}
	public void setPostiPiedi(int postiPiedi) {
		this.postiPiedi = postiPiedi;
	}
	public boolean isNotturno() {
		return notturno;
	}
	public void setNotturno(boolean notturno) {
		this.notturno = notturno;
	}


	
	@Override
	public String toString() {
		return "\nLinea: " + linea.toUpperCase() + 
			   "\nPosti a sedere: " + postiSedere + 
			   "\nPosti in piedi: " + postiPiedi + 
			   "\nNotturno: " + (notturno ? "Si" : "No");
	}
	
	public int postiTotali() 
	{
		return postiSedere + postiPiedi;
	}
	
	
	 
	 
	

}
