package entities;

public class Laptop extends Pc{

	public Laptop(int id, String marca, int annoProduzione, String modello, String cpu, String tipoHd, int ram,
			int hd) {
		super(id, marca, annoProduzione, modello, cpu, tipoHd, ram, hd);
	
	}

	@Override
	public String toString() {
		return 	"\nLaptop\n" + super.toString();
	}
	
	
	
	
	

}
