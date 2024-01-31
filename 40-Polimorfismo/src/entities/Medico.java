package entities;

public class Medico extends Persona
{
	
	private String specializzazione, ospedale;
	private double stipendio;
	
	public Medico(String nome, String cognome, String residenza, String dob, String specializzazione, String ospedale,
			double stipendio) 
	{
		super(nome, cognome, residenza, dob);
		setSpecializzazione(specializzazione);
		setOspedale(ospedale);
		setStipendio(stipendio);
	}

	public String getSpecializzazione() 
	{
		return specializzazione;
	}

	public void setSpecializzazione(String specializzazione) 
	{
		this.specializzazione = specializzazione;
	}

	public String getOspedale() 
	{
		return ospedale;
	}

	public void setOspedale(String ospedale) 
	{
		this.ospedale = ospedale;
	}

	public double getStipendio() 
	{
		return stipendio;
	}

	public void setStipendio(double stipendio) 
	{
		this.stipendio = stipendio;
	}

	@Override
	public String toString() 
	{
		return 
				super.toString().replace("\n\tPERSONA\n","\n\tMEDICO\n")     +
				"\nSpecializzazione: "   + specializzazione 				 + 
				"\nOspedale: " 			 + ospedale 		 				 + 
				"\nStipendio: " 		 + stipendio 		   + "$" 		 + 
										 (fuoriSede() ? "\nFuori sede" : "") +
				"\n--------------------------------------------------\n";
	}
	
	public boolean fuoriSede() 
	{
		String sedeOspedale = "";
		switch(ospedale.toLowerCase()) 
		{
		case"san raffaele":
		case"fatebene fratelli":	
		case"humanitas":
			sedeOspedale = "Milano";
			break;
		case "ponte san pietro":
			sedeOspedale = "Bergamo";
			break;
		case "spedali civili":
			sedeOspedale = "Brescia";
			break;
		default:
			sedeOspedale = "Non definita";
		}
		
		return !getResidenza().equalsIgnoreCase(sedeOspedale);
	}
	
}
