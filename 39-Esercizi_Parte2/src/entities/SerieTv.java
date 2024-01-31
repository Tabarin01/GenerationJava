package entities;

public class SerieTv extends ContenutoMultimediale{

//	String titolo, int durataMediaEpisodi, int nStagioni, int nPuntateStagione, boolean conclusa, 

	private int durataMediaEpisodi, nStagioni, nPuntateStagione;
	boolean conclusa;
	
	public SerieTv(String titolo, int durataMediaEpisodi, int nStagioni, int nPuntateStagione, boolean conclusa) {
		super(titolo);
		
		setDurataMediaEpisodi(durataMediaEpisodi);
		setnStagioni(nStagioni);
		setnPuntateStagione(nPuntateStagione);
		setConclusa(conclusa);
		
	}

	public int getDurataMediaEpisodi() {
		return durataMediaEpisodi;
	}

	public void setDurataMediaEpisodi(int durataMediaEpisodi) {
		this.durataMediaEpisodi = durataMediaEpisodi;
	}

	public int getnStagioni() {
		return nStagioni;
	}

	public void setnStagioni(int nStagioni) {
		this.nStagioni = nStagioni;
	}

	public int getnPuntateStagione() {
		return nPuntateStagione;
	}

	public void setnPuntateStagione(int nPuntateStagione) {
		this.nPuntateStagione = nPuntateStagione;
	}

	public boolean isConclusa() {
		return conclusa;
	}

	public void setConclusa(boolean conclusa) {
		this.conclusa = conclusa;
	}

	@Override
	public String toString() {
		return "\n\tSerie TV\n"        +
				super.toString() +
				"\nDurata Media Episodi: " + durataMediaEpisodi + " minuti" +
				"\nStagioni: " + nStagioni + 
				"\nPuntate: "+ nPuntateStagione + 
				"\nConclusa: " + (conclusa ? "Si" : "No") +
				"\n--------------------------------------------------\n";
	}
	
	//Metodi
	
//	int durataMediaStagione() ------------------------> indica in minuti quanto dura una stagione
	
	public int durataMediaStagione() 
	{
		if(serieValida()) 
		{
			return (durataMediaEpisodi * nPuntateStagione) / nStagioni;
		}else 
		{
			return 0;
		}
	}
	
//	int durataMediaSerie() ---------------------------> indica quanti minuti servono per vedere 
//	                                                                  l'intera serie tv
	public int durataMediaSerie() 
	{
		return serieValida() ? durataMediaStagione() * nStagioni : 0;
	}
	
//	boolean serieValida(int nStagioni, int nPuntate) -> Controlla che la serie possa esistere sapendo che serve minimo 1 stagione e 3 episodi
	
	public boolean serieValida() 
	{
		return nStagioni >= 1 && nPuntateStagione >=3;
	}
	
	
	

	
}
