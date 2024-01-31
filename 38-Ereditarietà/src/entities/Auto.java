package entities;



public class Auto extends Veicolo {
	
	private boolean ariaCondizionata, cerchiInLega;

	public Auto(String marca, String modello, String colore, int capienzaSerbatoio, double chilometriLitro, boolean ariaCondizionata, boolean cerchiInLega) 
	{
		super(marca, modello, colore, capienzaSerbatoio, chilometriLitro);
		setAriaCondizionata(ariaCondizionata);
		setCerchiInLega(cerchiInLega);
	}

	public boolean isAriaCondizionata() 
	{
		return ariaCondizionata;
	}
	public void setAriaCondizionata(boolean ariaCondizionata) 
	{
		this.ariaCondizionata = ariaCondizionata;
	}
	public boolean isCerchiInLega() 
	{
		return cerchiInLega;
	}
	public void setCerchiInLega(boolean cerchiInLega) 
	{
		this.cerchiInLega = cerchiInLega;
	}

	
	@Override
	public String toString() {
		return 	"\n\tAUTO\n" 		    +
				super.toString() 		+
				"\nAria condizionata: " + (ariaCondizionata ? "Presente" : "Non presente") + 
			   "\nCerchi in lega: "     + (cerchiInLega ? "Presenti" : "Non presenti")     + "\n";
	}
	
	//Metodi
	
	

}//class
