package entities;

public class Film extends ContenutoMultimediale{

	//	String titolo, int durataMin, String regista, boolean oscar
	private int durataMin;
	private String regista;
	private boolean oscar;

	public Film(String titolo,int durataMin, String regista, boolean oscar) {
		super(titolo);

		setDurataMin(durataMin);
		setRegista(regista);
		setOscar(oscar);

	}

	public int getDurataMin() {
		return durataMin;
	}

	public void setDurataMin(int durataMin) {
		this.durataMin = durataMin;
	}

	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}

	public boolean isOscar() {
		return oscar;
	}

	public void setOscar(boolean oscar) {
		this.oscar = oscar;
	}

	@Override
	public String toString() {
		return 	"\n\tFILM\n"        +
				super.toString() +
				"\nDurata: " + durataMin + " minuti" +
				"\nRegista: " + regista + 
				"\nOscar: " + (oscar ? "Si" : "No") + 
				"\nPrezzo: " + prezzo() + " milioni" +
				"\nFilm valido: " + (filmValido() ? "Valido" : "Cortometraggio") +
				"\n--------------------------------------------------\n";
	}

	//Metodi

	public double prezzo() 
	{
		double costoBase = 2;
		costoBase *= durataMin;

		switch(regista) 
		{
		case "James Cameron":
			costoBase += 100.0;
			break;
		case "Christopher Nolan":
			costoBase += 50.0;
			break;
		case "Quentin Tarantino":
			costoBase += 40.0;
			break;
		default:
			costoBase += 20.0;
		}

		return costoBase;
	}

	//	boolean filmValido(int durata) -> Controlla che la durata sia valida per essere un film (minimo 65 minuti)

	public boolean filmValido() 
	{
		return durataMin > 65 ? true : false;
	}




}
