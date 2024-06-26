package main;

import java.io.FileNotFoundException;

import entities.Blockbuster;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
//		Creare la classe Film, con le proprietà:
//		    String titolo, int durataMin, String regista, boolean oscar
//		e i metodi: 
//		String scheda()
//		double prezzo() ----------------> calcola il prezzo in base al regista e alla durata.
//		boolean filmValido(int durata) -> Controlla che la durata sia valida per essere un film (minimo 65 minuti)
//
//		Creare la classe SerieTv, con le proprietà:
//		    String titolo, int durataMediaEpisodi, int nStagioni, int nPuntateStagione, boolean conclusa, 
//		e i metodi:
//		String scheda()
//		int durataMediaStagione() ------------------------> indica in minuti quanto dura una stagione
//		int durataMediaSerie() ---------------------------> indica quanti minuti servono per vedere 
//		                                                                  l'intera serie tv
//		boolean serieValida(int nStagioni, int nPuntate) -> Controlla che la serie possa esistere sapendo che serve minimo 1 stagione e 3 episodi
//
//		Creare un file con i dati di film e serie tv formattato così:
//		    serietv,titolo,durataMediaEpisodi,nStagioni,nPuntateStagione,conclusa
//		    film,titolo,durataMin,regista,oscar
//
//		Creare una classe Blockbuster che legga i dati da file e li inserisca in 2 AL
//		e che abbia i metodi:
//		String listaFilm()---------> solo le schede dei film
//		String listaSerie() -------> solo le schede delle serietv
//		String listaCompleta ------> le schede sia di film che di serie
//		double durataMediaFilm() --> durata media dei film
//		String filmCaro() ---------> la scheda del film più caro
//		String invalidi() ---------> le schede dei film o delle serie che non sono valide
//		String registaFrequente() -> il nome del regista che ha fatto più film del file e il numero di film in cui è presente

		Blockbuster b = new Blockbuster("src/res/Dati.txt");
		
		System.out.println(b.listaFilm());
		System.out.println(b.listaSerieTv());
		System.out.println(b.listaCompleta());
		System.out.println(b.durataMediaFilm());
		System.out.println(b.filmCaro());
		System.out.println(b.invalidi());
		System.out.println(b.registaFrequente());
		System.out.println(b.registaFrequenteS());
		
		
	}//main

}//class
