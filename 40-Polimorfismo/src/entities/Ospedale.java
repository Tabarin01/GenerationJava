package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ospedale {

	private ArrayList<Persona> persone;

	public Ospedale(String path) throws FileNotFoundException
	{
		persone = new ArrayList<Persona>();

		Scanner file= new Scanner(new File(path));

		Persona p = null;

		while(file.hasNextLine()) 
		{
			String[] info = file.nextLine().split(",");

			switch(info[0].toLowerCase()) 
			{
			case "pe":
				p =new Persona(
						info[1],
						info[2],
						info[3],
						info[4]
						);
				break;
			case "me":
				p = new Medico(
						info[1],
						info[2],
						info[3],
						info[4],
						info[5],
						info[6],
						Double.parseDouble(info[7])
						);
				break;
			case "pa":
				p = new Paziente(
						info[1],
						info[2],
						info[3],
						info[4],
						info[5],
						info[6].equalsIgnoreCase("S"),
						Integer.parseInt(info[7])
						);
				break;
			default:
				System.err.println("Riga errata nel file");
			}
			if(p!= null) 
				persone.add(p);

		}

		file.close();
	}

	public String listaCompleta() 
	{
		String ris = "";

		for(Persona p : persone) 
		{
			ris += p.toString();
		}

		return ris;
	}

	//Voglio vedere il nominativo delle persone piu giovani

	public String personaGiovane() 
	{
		String ris = "";
		int min = 145;

		for(Persona p : persone) 
		{
			if(p.eta() < min) 
			{
				min = p.eta();
				ris ="-" + p.getNome() + " " + p.getCognome();
			}
			else if(p.eta() == min) 
			{
				ris += "\n-" + p.getNome() + " " + p.getCognome();
			}
		}
		return ris.isEmpty() ? "Nessuna persona trovata" : "\nGiovani nel file: \n" + ris;
	}

	//Voglio vedere il nominativo del medico molto giovane

	public String medicoGiovane() 
	{
		String ris = "";
		int min = 145;

		for(Persona p : persone) 
		{
			if(p instanceof Medico) //INSTANCEOF controlla se il tipo concreto dell'oggetto p e' uguale al tipo Medico
			{
				if(p.eta() < min) 
				{
					min = p.eta();
					ris ="-" + p.getNome() + " " + p.getCognome();
				}
				else if(p.eta() == min) 
				{
					ris += "\n-" + p.getNome() + " " + p.getCognome();
				}
			}
		}


		return ris.isEmpty() ? "Nessuna persona trovata" : "\nMedici + giovani nel file: \n" + ris;
	}

	public String medicoPiuPagato() 
	{
		String ris = "";
		double max = 0;

		for(Persona p : persone) 
		{
			if(p instanceof Medico) 
			{
				//DUE MODI PER FARE IL CASTING:
				//METODO 1: Si chiamano solo casting e dura per l'intero blocco di appartenenza dell'oggetto m
				Medico m = (Medico)p; //CASTING crea oggetto m e gli casta dentro il medico p
				m.getStipendio();
				//METODO 2: Si chiama casting in linea ed e' temporaneo
				((Medico)p).getStipendio();


				//Il cast puo' sempre potenzialmente avvenire, apatto che staite attenti ad una cosa:
				//Il tipo su cui effettuiamo il casting(p) deve poter essere trasformato nel tipo di interesse(MEDICO)
				//Perche' altrimenti in fase di running il cast dara' vita ad una eccezione che blocchera'il programma
				//Per questo motivo e' fondamentale quando si tratta di oggetti, effettuare prima del cast il comando instanceof
				//cosi da evitare errori in fase di running

				double stipendio = ((Medico)p).getStipendio();

				if(stipendio > max) 
				{
					max = stipendio;
					ris = "-" + p.getNome() + " " + p.getCognome() + " con " + m.getStipendio() + "$";
				}
				else if(stipendio == max) 
				{
					ris += "\n-" + p.getNome() + " " + p.getCognome() + " con " + m.getStipendio() + "$";
				}
			}
		}

		return ris.isEmpty() ? "Nessuna persona trovata" : "\nMedico + pagato nel file: \n" + ris;
	}
	public double spesa (String malattia) 
	{
		double ris = 0;
		
		for(Persona paziente : persone) 
		{
			if(paziente instanceof Paziente) 
			{
				Paziente spesaPa = (Paziente)paziente;
				if(spesaPa.getMalattia().equalsIgnoreCase(malattia))
					ris+= spesaPa.spesaPaziente();
			}
			
		}
		
		return ris;
		
	}
	
	//Voglio sapere quanto spende in totale l'ospedale immaginando di trattare tutti i pazienti del file e di
	//pagare lo stipendio mensile di tutti i medici del file
	
	public double totaleSpesaOs() 
	{
		double totaleSpesa = 0;
		
		for(Persona p: persone) 
		{
			if(p instanceof Paziente) 
			{
				double spesa = ((Paziente)p).spesaPaziente();
				totaleSpesa += spesa;
			}
			else if(p instanceof Medico) 
			{
				Medico medico = (Medico)p;
				totaleSpesa += medico.getStipendio();
			}
		}
		
		return totaleSpesa;
	}
	
	//Fare lo stesso conto di prima, ma per ogni medico fuori sede, aggiungere alla spesa calcolata
	//un rimborso spese per il medico pari al 25% del suo stipendio
	
	public double totaleSpesaRimborso() 
	{
		double totaleSpese = totaleSpesaOs();
		for(Persona p: persone) 
		{
			if(p instanceof Medico) 
			{
				Medico m = (Medico)p;
				if(m.fuoriSede()) 
				{
					double rimborso =  0.25 * m.getStipendio();
					totaleSpese += rimborso;
				}
			}
		}
		return totaleSpese;
	}

}
