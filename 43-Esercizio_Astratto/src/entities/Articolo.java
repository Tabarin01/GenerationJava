package entities;

public abstract class Articolo extends Entity{

	private String marca;
	private int annoProduzione;

	public Articolo(int id, String marca, int annoProduzione) 
	{
		super(id);
		setMarca(marca);
		setAnnoProduzione(annoProduzione);
	}
	
	public String getMarca() 
	{
		return marca;
	}

	public void setMarca(String marca) 
	{
		this.marca = marca;
	}

	public int getAnnoProduzione() 
	{
		return annoProduzione;
	}

	public void setAnnoProduzione(int annoProduzione) 
	{
		this.annoProduzione = annoProduzione;
	}

	@Override
	public String toString() {
		return 	
				super.toString()   					+
				"\nMarca: " + marca.toUpperCase() 	+ 
				"\nAnno di produzione: " + annoProduzione;
	}

	public int eta() 
	{
		int annoCorrente = java.time.Year.now().getValue();
		return annoCorrente - annoProduzione;
	}

	public abstract double prezzo();




}
