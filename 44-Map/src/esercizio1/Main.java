package esercizio1;

import java.util.*;

public class Main {

	public static void main(String[] args) 
	{
		// Chiedere all'utente una serie di informazioni legate alla sua anagrafica
		// Inserirle in una Map
		// Stampare poi la scheda riassuntiva ordinata delle informazioni prese da console
		
		Scanner scanner = new Scanner(System.in);
        Map<String, String> anagrafica = new LinkedHashMap<>(); // Usiamo LinkedHashMap per mantenere l'ordine di inserimento

        System.out.println("Inserisci le informazioni anagrafiche:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        anagrafica.put("Nome", nome);

        System.out.print("Cognome: ");
        String cognome = scanner.nextLine();
        anagrafica.put("Cognome", cognome);

        System.out.print("Data di nascita (formato AAAA-MM-GG): ");
        String dataDiNascita = scanner.nextLine();
        anagrafica.put("Data di Nascita", dataDiNascita);

        System.out.print("Luogo di nascita: ");
        String luogoDiNascita = scanner.nextLine();
        anagrafica.put("Luogo di Nascita", luogoDiNascita);

        System.out.print("Indirizzo: ");
        String indirizzo = scanner.nextLine();
        anagrafica.put("Indirizzo", indirizzo);

        System.out.println("\n\tScheda riassuntiva");

        for(String s : anagrafica.keySet()) 
        {
        	System.out.println(s.toUpperCase() + ": "+ anagrafica.get(s).toUpperCase());
        }
        
        
//        for (Map.Entry<String, String> entry : anagrafica.entrySet()) 
//        {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }

        scanner.close();
    }

}
