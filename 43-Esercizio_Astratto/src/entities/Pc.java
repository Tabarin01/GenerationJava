package entities;

public abstract class Pc extends Articolo
{
	private String modello, cpu, tipoHd;
	private int ram, hd;
	
	
	public Pc(int id, String marca, int annoProduzione, String modello, String cpu, String tipoHd, int ram, int hd) {
		super(id, marca, annoProduzione);
		setModello(modello);
		setCpu(cpu);
		setTipoHd(tipoHd);
		setRam(ram);
		setHd(hd);
	}


	public String getModello() {
		return modello;
	}


	public void setModello(String modello) {
		this.modello = modello;
	}


	public String getCpu() {
		return cpu;
	}


	public void setCpu(String cpu) {
		this.cpu = cpu;
	}


	public String getTipoHd() {
		return tipoHd;
	}


	public void setTipoHd(String tipoHd) {
		this.tipoHd = tipoHd;
	}


	public int getRam() {
		return ram;
	}


	public void setRam(int ram) {
		this.ram = ram;
	}


	public int getHd() {
		return hd;
	}


	public void setHd(int hd) {
		this.hd = hd;
	}
	
	
	
	
	@Override
	public String toString() {
		return 	super.toString() +
				"\nModello: " + modello + 
				"\nCpu: " + cpu + 
				"\nRam: " + ram + 
				"\nTipo di Hd: " + tipoHd + 
				"\nHd: " + hd;
	}


	public double prezzo() 
	{
		double totale = 100;
		switch(getMarca().toLowerCase()) 
		{
		case "asus":
			totale += 300;
			break;
		case "lenovo": 
			totale += 400;
			break;
		case "msi": 
			totale += 800;
			break;
		case "raiontech":
			totale += 2000;
			break;
		default: 
			totale += 100;
			
		}
		
		switch(cpu.toLowerCase()) {
        case "i5":
            totale += 200;
            break;
        case "i7": 
            totale += 400;
            break;
        case "ryzen 5": 
            totale += 250;
            break;
        default: 
            totale += 100;
		}
		
		
		return totale;
		
	}
	
	public boolean gaming() 
	{
		if(cpu.equalsIgnoreCase("i7") && tipoHd.equals("hhd"))
			return true;
		
		return false;
	}
	

}
