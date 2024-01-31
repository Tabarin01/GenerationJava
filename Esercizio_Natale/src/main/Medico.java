package main;

public class Medico {

	String nome,cognome,dob,residenza,reparto;
	int anniDiSkill,pazientiCurati,pazientiPersi;



	Medico(String nome, String cognome, String dob, String residenza, String reparto, int anniDiSkill,
			int pazientiCurati, int pazientiPersi) 
	{
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.residenza = residenza;
		this.reparto = reparto;
		this.anniDiSkill = anniDiSkill;
		this.pazientiCurati = pazientiCurati;
		this.pazientiPersi = pazientiPersi;
	}


	String schedaMedici() 
	{
		String scheda = String.format("| %-12s | %-12s | %-15s | %-12s | %-15s | %-16s | %-15s | %-15s |\n",
				nome, cognome, dob, residenza, reparto, anniDiSkill, pazientiCurati, pazientiPersi);
		return scheda;
	}

	boolean buonDottore() 
	{
		boolean ris = false;
		int pazientiTotali = pazientiCurati + pazientiPersi;

		if((pazientiCurati*100/pazientiTotali) > 80)
			ris = true;

		return ris;
	}

	boolean cattivoDottore() 
	{
		boolean ris = false;
		int pazientiTotali = pazientiCurati + pazientiPersi;

		if((pazientiPersi*100/pazientiTotali) > 50)
			ris = true;

		return ris;
	}

	boolean killer() 
	{
		boolean ris = false;

		if(cattivoDottore() == true && anniDiSkill > 20) {
			ris = true;
		}

		return ris;
	}


}