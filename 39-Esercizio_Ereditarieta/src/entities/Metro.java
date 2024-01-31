package entities;

public class Metro extends Veicolo{
	
	private int numeroVagoni;
	private boolean superficie;
	
	public Metro(String linea,int numeroVagoni, int postiSedere, int postiPiedi, boolean notturno, boolean superficie) {
		super(linea, postiSedere, postiPiedi, notturno);
		
		setNumeroVagoni(numeroVagoni);
		setSuperficie(superficie);
		
	}

	public int getNumeroVagoni() {
		return numeroVagoni;
	}

	public void setNumeroVagoni(int numeroVagoni) {
		this.numeroVagoni = numeroVagoni;
	}

	public boolean isSuperficie() {
		return superficie;
	}

	public void setSuperficie(boolean superficie) {
		this.superficie = superficie;
	}

	@Override
	public String toString() {
		return "\n\tMETRO\n"        +
				super.toString() +
			   "\nVagoni: " + numeroVagoni + 
			   "\nTratta in superficie: " + (superficie ? "Si" : "No") + 
			   "\n--------------------------------------------------\n";
	}
	
	

}
