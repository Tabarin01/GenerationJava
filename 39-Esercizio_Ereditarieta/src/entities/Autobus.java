package entities;

public class Autobus extends Veicolo{
	
	private boolean doppioPiano;

	public Autobus(String linea, int postiSedere, int postiPiedi, boolean notturno, boolean doppioPiano) {
		super(linea, postiSedere, postiPiedi, notturno);
		
		setDoppioPiano(doppioPiano);
		
	}

	public boolean isDoppioPiano() {
		return doppioPiano;
	}

	public void setDoppioPiano(boolean doppioPiano) {
		this.doppioPiano = doppioPiano;
	}

	@Override
	public String toString() {
		return "\n\tAUTOBUS\n"        +
				super.toString() +
			   "\nDoppio piano: " + (doppioPiano ? "Si" : "No") + 
			   "\n--------------------------------------------------\n";
	}

	
	
	
	

}
