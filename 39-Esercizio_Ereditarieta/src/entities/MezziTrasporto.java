package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MezziTrasporto {
	
	private ArrayList<Tram> tram;
	private ArrayList<Metro> metro;
	private ArrayList<Autobus> autobus;
	
	public MezziTrasporto(String path) throws FileNotFoundException
	{
		tram = new ArrayList<Tram>();
		metro = new ArrayList<Metro>();
		autobus = new ArrayList<Autobus>();
		
		Scanner file = new Scanner(new File(path));
		
		while(file.hasNextLine()) 
		{
			String[] info = file.nextLine().split(",");
			
			switch(info[0].toLowerCase()) 
			{
			case "tram":
				tram.add(
						new Tram(
								info[1],
								Integer.parseInt(info[2]),
								Integer.parseInt(info[3]),
								Integer.parseInt(info[4]),
								info[5].equalsIgnoreCase("s"),
								info[6].equalsIgnoreCase("s")
								)
						);
				break;
			case "metro":
				metro.add(
						new Metro(
								info[1],
								Integer.parseInt(info[2]),
								Integer.parseInt(info[3]),
								Integer.parseInt(info[4]),
								info[5].equalsIgnoreCase("s"),
								info[6].equalsIgnoreCase("s")
								)
						);
				
				break;
			case "autobus":
				autobus.add(
						new Autobus(
								info[1],
								Integer.parseInt(info[2]),
								Integer.parseInt(info[3]),
								info[4].equalsIgnoreCase("s"),
								info[5].equalsIgnoreCase("s")
								)
						);
				break;
			default:
				System.out.println("Riga Errata nel file dati");
			
			}
		}
		file.close();
	}//costruttore
	public String elencoTram() 
	{
		String ris = "";

		for(Tram t : tram)
			ris += t.toString();
		return ris;
	}
	public String elencoMetro() 
	{
		String ris = "";

		for(Metro m : metro)
			ris += m.toString();
		return ris;
	}
	public String elencoAutobus() 
	{
		String ris = "";

		for(Autobus a : autobus)
			ris += a.toString();
		return ris;
	}
	public String trovaNotturni() {
	    String lineeTramNotturni = "";
	    String lineeAutobusNotturni = "";
	    String lineeMetroNotturni = "";

	    for (Tram t : tram) {
	        if (t.isNotturno()) {
	            lineeTramNotturni += t.getLinea() + "-";
	        }
	    }

	    for (Autobus a : autobus) {
	        if (a.isNotturno()) {
	            lineeAutobusNotturni += a.getLinea() + "-";
	        }
	    }

	    for (Metro m : metro) {
	        if (m.isNotturno()) {
	            lineeMetroNotturni += m.getLinea() + "-";
	        }
	    }

	    
	    if (!lineeTramNotturni.isEmpty()) {
	        lineeTramNotturni = "Linea Tram: " + lineeTramNotturni.substring(0, lineeTramNotturni.length() - 1) + "\n";
	    }else 
	    {
	    	lineeTramNotturni = "Tram: Nessuna linea fa servizio notturno";
	    }
	    
	    if (!lineeAutobusNotturni.isEmpty()) {
	        lineeAutobusNotturni = "Linea Autobus: " + lineeAutobusNotturni.substring(0, lineeAutobusNotturni.length() - 1) + "\n";
	    }else 
	    {
	    	lineeAutobusNotturni = "Autobus: Nessuna linea fa servizio notturno";
	    }

	    if (!lineeMetroNotturni.isEmpty()) {
	        lineeMetroNotturni = "Linea Metro: " + lineeMetroNotturni.substring(0, lineeMetroNotturni.length() - 1) + "\n";
	    }else 
	    {
	    	lineeMetroNotturni = "Metro: Nessuna linea fa servizio notturno";
	    }

	    return "\nLINEE NOTTURNE: \n" + lineeTramNotturni + lineeAutobusNotturni + lineeMetroNotturni + "\n----------------------------------\n";
	}
	public String mezzoPerLinea(String lineaCercata) {
		String ris = "";
	    for (Tram t : tram) {
	        if (t.getLinea().equalsIgnoreCase(lineaCercata)) {
	            ris += t.toString();
	        }
	    }

	    for (Autobus a : autobus) {
	        if (a.getLinea().equalsIgnoreCase(lineaCercata)) {
	        	ris += a.toString();
	        }
	    }

	    for (Metro m : metro) {
	        if (m.getLinea().equalsIgnoreCase(lineaCercata)) {
	        	ris += m.toString();
	        }
	    }

	    return ris.isEmpty() ? "Nessun mezzo trovato per la linea: " + lineaCercata : "Risultati per la linea: " + lineaCercata + "\n" + ris;
	}
	//	trovare il mezzo migliore per gestire il numero di persone dato
	public String migliorGestione(int numeroPersone) 
	{
		String ris = "";
        int closeDimension = Integer.MAX_VALUE;


        for (Tram t : tram)     {
            if (numeroPersone <= t.postiTotali() && t.postiTotali()<closeDimension)    {
            ris = t.toString(); 
            closeDimension = t.postiTotali();

            }
        }


        for (Metro m : metro)     {
            if (numeroPersone <= m.postiTotali() && m.postiTotali()<closeDimension)    {
                ris = m.toString();
                closeDimension = m.postiTotali();

            }
        }
        for (Autobus a : autobus)     {
            if (numeroPersone <= a.postiTotali()  &&  a.postiTotali()<closeDimension)    {
                ris = a.toString();
                closeDimension= a.postiTotali();

            }
        }
        
        return ris.isEmpty() ? "Non ci sono mezzi disponibili" : "\n\nIl mezzo migliore per gestire " + numeroPersone + "\n" + ris;
		
	}
	//	trovare il mezzo con minore capienza
	public String minorCapienza() 
	{
		String ris = "";
		int min = Integer.MAX_VALUE;
		
		for(Tram t : tram) 
		{
			
			if(t.postiTotali() < min) 
			{
				min = t.postiTotali();
				ris = t.toString();
			}
			else if(t.postiTotali() == min) 
			{
				ris += t.toString();
			}
		}
		for(Metro m : metro) 
		{
			if(m.postiTotali() < min) 
			{
				min = m.postiTotali();
				ris = m.toString();
			}
			else if(m.postiTotali() == min) 
			{
				ris += m.toString();
			}
		}
		for(Autobus a : autobus) 
		{
			if(a.postiTotali() < min) 
			{
				min = a.postiTotali();
				ris = a.toString();
			}
			else if(a.postiTotali() == min) 
			{
				ris += a.toString();
			}
			
		}
		
		return ris.isEmpty() ? "Nessun veicolo trovato" : "\nMinor capienza: \n" + ris;
	}
	
		
}//class
