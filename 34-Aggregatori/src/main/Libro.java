package main;

public class Libro 
{


	//ATTRIBUTI
	String titolo,autore,genere,casaEditrice;
	int numeroPagine,annoPubblicazione;
	boolean primaEdizione;


	//COSTRUTTORE
	Libro(String titolo, String autore, String genere, String casaEditrice, int numeroPagine,
			int annoPubblicazione, boolean primaEdizione) 
	{

		this.titolo = titolo;
		this.autore = autore;
		this.genere = genere;
		this.casaEditrice = casaEditrice;
		this.numeroPagine = numeroPagine;
		this.annoPubblicazione = annoPubblicazione;
		this.primaEdizione = primaEdizione;

	}


	//METODI
	String scheda() 
	{

		return "Titolo: " + titolo.toUpperCase()    +
				"\nAutore: " + autore.toUpperCase() +
				"\nGenere: " + genere.toUpperCase() +
				"\nEdito da: " + casaEditrice.toUpperCase() +
				"\nPubblicato nel: " + annoPubblicazione +
				"\nPrima edizione: " + (primaEdizione ? "Si" : "No") +
				"\nPagine: " + numeroPagine +
				"\nPrezzo: " + (int) prezzo() +
				"$\n-----------------------------------------------\n";
	}



	double prezzo() 
	{
		double ris = 3;

		ris += numeroPagine * 0.002;

		switch(casaEditrice.toLowerCase())
		{
		case "mondadori":
			ris+= 2.5;
			break;
		case "feltrinelli":
			ris += 1.1;
			break;
		case "hoepli":
			ris += 0.5;
			break;
		default:
			ris += 3.2;
		}

		ris += primaEdizione ? 5 : 0;

		return ris;
	}


}//classe modello
