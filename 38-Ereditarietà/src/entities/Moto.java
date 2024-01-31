package entities;


public class Moto extends Veicolo {
	
	
	private boolean passeggero;
	private boolean bauletto;

	public Moto(String marca, String modello, String colore, int capienzaSerbatoio, double chilometriLitro, boolean passeggero, boolean bauletto) 
	{
		//Richiama il costruttore del genitore Veicolo: se va bene, passa alla riga 14
		super(marca, modello, colore, capienzaSerbatoio, chilometriLitro);
		setPasseggero(passeggero);
		setBauletto(bauletto);
		
	}

	public boolean isPasseggero() 
	{
		return passeggero;
	}
	public void setPasseggero(boolean passeggero) 
	{
		this.passeggero = passeggero;
	}
	public boolean isBauletto() 
	{
		return bauletto;
	}
	public void setBauletto(boolean bauletto) 
	{
		this.bauletto = bauletto;
	}
	@Override
	public String toString() 
	{
		return "\n\tMOTO\n"        +
				super.toString() +
			   "\nPasseggero: "  + (passeggero ? "Annesso" : "Non annesso") + 
			   "\nBauletto: "    + (bauletto ? "Presente" : "Non presente") +
			   "\n--------------------------------------------------\n";
	}
	
	//Metodi
	
	
	
	

}//class
