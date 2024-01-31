package entities;

public class Tram extends Veicolo{
	
	private int numeroVagoni;
	private boolean binarioSingolo;

	public Tram(String linea,int numeroVagoni, int postiSedere, int postiPiedi, boolean notturno, boolean binarioSingolo) {
		super(linea, postiSedere, postiPiedi, notturno);
		
		setNumeroVagoni(numeroVagoni);
		setBinarioSingolo(binarioSingolo);
	}

	public int getNumeroVagoni() {
		return numeroVagoni;
	}

	public void setNumeroVagoni(int numeroVagoni) {
		this.numeroVagoni = numeroVagoni;
	}

	public boolean isBinarioSingolo() {
		return binarioSingolo;
	}

	public void setBinarioSingolo(boolean binarioSingolo) {
		this.binarioSingolo = binarioSingolo;
	}

	@Override
	public String toString() {
		return "\n\tTRAM\n"        +
				super.toString() +
			   "\nVagoni: " + numeroVagoni + 
			   "\nBinario singolo: " + (binarioSingolo ? "Si" : "No") + 
			   "\n--------------------------------------------------\n";
	}
	
	
	
}
