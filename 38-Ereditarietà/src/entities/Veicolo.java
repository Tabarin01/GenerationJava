package entities;

//Classe genitore(superclasse) 

public class Veicolo {


	//Attributes
	private String marca, modello, colore;
	private int capienzaSerbatoio;
	private double chilometriLitro;





	//Constructor
	public Veicolo(String marca, String modello, String colore, int capienzaSerbatoio, double chilometriLitro) 
	{
		//Il costruttore vuoto con super indica che Veicolo e' figlio di Object 
		//quindi se vuole potrebbe usare il costruttore vuoto
		//di Object grazie al comando SUPER.
		
		//super();  nel nostro caso qui non serve, quindi si potrebbe cancellare
		setMarca(marca);
		setModello(modello);
		setColore(colore);
		setCapienzaSerbatoio(capienzaSerbatoio);
		setChilometriLitro(chilometriLitro);
	}


	//Getter e setter
	public String getMarca() 
	{
		return marca;
	}
	public void setMarca(String marca) 
	{
		this.marca = marca;
	}
	public String getModello() 
	{
		return modello;
	}
	public void setModello(String modello) 
	{
		this.modello = modello;
	}
	public String getColore() 
	{
		return colore;
	}
	public void setColore(String colore) 
	{
		this.colore = colore;
	}
	public int getCapienzaSerbatoio() 
	{
		return capienzaSerbatoio;
	}
	public void setCapienzaSerbatoio(int capienzaSerbatoio) 
	{
		this.capienzaSerbatoio = capienzaSerbatoio;
	}
	public double getChilometriLitro() 
	{
		return chilometriLitro;
	}
	public void setChilometriLitro(double chilometriLitro) 
	{
		this.chilometriLitro = chilometriLitro;
	}


	
	
	//Metodi
	@Override
	public String toString() {
		return  "Marca: "				   + marca  		   + 
				"\nModello: " 			   + modello 		   + 
				"\nColore: "               + colore 		   + 
				"\nCapienza serbatoio: "   + capienzaSerbatoio + 
				"\nKm al litro: "  		   + chilometriLitro   +
				"\nAutonomia: " 		   + autonomia()       + "Km/L";
	}


	public double autonomia() 
	{
		return capienzaSerbatoio * chilometriLitro;
	}
	
	

	





}//class
