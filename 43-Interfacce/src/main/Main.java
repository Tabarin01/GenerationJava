package main;


import java.io.FileNotFoundException;
import entities.Scuola;
import entities.IScuola;


public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scuola s = new Scuola("src/res/Dati.txt");
		
		IScuola iS = new Scuola("src/res/Dati.txt");
		
		System.out.println(iS.anziano());
		
		// ATTENZIONE!
		// Dato che sfrutto il polimorfismo alla riga 15, l'oggetto creato avra'
		// accesso solo ai metodi presenti dentro l'interfaccia 
		// (che sia solo la firma o l'intero corpo poco importa)
		// se si vuole usare un metodo presente solo nell'aggregratrice, bisognera' castare l'oggetto Scuola s
		
	
	}

}
