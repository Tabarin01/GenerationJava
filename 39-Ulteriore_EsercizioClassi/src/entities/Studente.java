package entities;

import java.util.Arrays;

//Creare la classe Studente, figlia di Persona, che avrà come proprietà:
//	int classe;
//	String sezione;
//	double[] voti; (italiano[0],matematica[1],storia[2])
//e i metodi:
//	String toString();
//	int nInsuff() -> Conta il numero di insufficienze dallo studente
//	String esito() -> Stampa promosso se la media complessiva è maggiore di 6 e c'è al massimo 1 insufficienza
//	boolean erasmus() -> Ritorna true se lo studente: è in 4° o 5°, è promosso e ha una media complessiva di almeno 8

public class Studente extends Persona{

	private int classe;
	private String sezione;
	private double[] voti;
	
	public Studente(String nome, String dob, int classe, String sezione, double[] voti) {
		super(nome, dob);
		
		setClasse(classe);
		setSezione(sezione);
		setVoti(voti);
	}

	public int getClasse() {
		return classe;
	}

	public void setClasse(int classe) {
		this.classe = classe;
	}

	public String getSezione() {
		return sezione;
	}

	public void setSezione(String sezione) {
		this.sezione = sezione;
	}

	public double[] getVoti() {
		return voti;
	}

	public void setVoti(double[] voti) {
		this.voti = voti;
	}

	@Override
	public String toString() {
		 return super.toString().replace("\n\tPERSONA\n","\n\tSTUDENTE\n")     +
		        "\nClasse: " + classe + sezione +
		        "\nEta: " + eta()+
                "\nVoti: " +
	            "\n  - Italiano: " + voti[0] +
	            "\n  - Matematica: " + voti[1] +
		        "\n  - Inglese: " + voti[2] +
		        "\n--------------------------------------------------\n";
	}
	
	public int nInsuff() 
	{
		int conta = 0;
		for(int i = 0; i< voti.length; i++) 
		{
			if(voti[i]<6)
				conta++;
		}
		return conta;
	}
	
	public double mediaStudenti() 
	{
		double media = 0;
		int conta = 0;
		
		for(int i = 0; i<voti.length; i++) 
		{
			media += voti[i];
			conta++;
		}
		media /= conta;
		
		return media;
	}
	
	public String esito() 
	{
		String ris = "";
		
		return ris = mediaStudenti() >= 6 && nInsuff() < 2 ? "Promosso" : "Bocciato"; 
	}
	
	public boolean erasmus() {
		if((mediaStudenti() > 8 && esito().equalsIgnoreCase("promosso")) && (classe == 5 || classe == 4)){
            return true;
        }

        return false;
	}
	
	
	
	
	
	

}
