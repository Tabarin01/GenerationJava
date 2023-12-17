package main;

//Scrivere un file coi dati delle figurine di un gioco.
//Delle figurine sapete: nome del personaggio, attacco, difesa, vita, abilità(boolean), raro(boolean)
//Scrivete minimo 5 personaggio.
//Leggete il file e stampate in console:
//La scheda di ogni personaggio
//Il nome del/dei personaggi con difesa maggiore
//La scheda del/dei personaggio/i con vita minore
//Il numero di personaggi rari presenti
//Il valore medio di attacco dei personaggi che hanno abilità come true
//Il valore medio di vita dei personaggi rari con attacco superiore a 10
//La scheda dei personaggi la cui difesa è superiore almeno del 5% rispetto al loro attacco
//
//Usate una volta sola il comando System.out.println();

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) throws FileNotFoundException {

		Scanner file;
		String name, answer = "", highDefense = "", lowLife = "", defSup = "", special ;
		int rareName = 0, 
			life, 
			majorDefense = Integer.MIN_VALUE, 
			minLife = Integer.MAX_VALUE,
			countAbility = 0,
			countLifeRare = 0,
		    i = 1;

		double lifeRareSum = 0;
		double attackSumWithAbility = 0;
		double atk, def;
		boolean ability, rare;

		file = new Scanner(new File("src/res/Cards.txt"));

		while(file.hasNextLine()) {

			name = file.nextLine();
			atk = Double.parseDouble(file.nextLine());
			def = Double.parseDouble(file.nextLine());
			life = Integer.parseInt(file.nextLine());
			special = file.nextLine();
			rare = Boolean.parseBoolean(file.nextLine());

			answer +=
				    "\nNome " + i + "° personaggio: " + name + "\n" +
				    "Attacco: " + atk + "\n" +
				    "Difesa: " + def + "\n" +
				    "Vita: " + life + "\n" +
				    "Abilita': " + (special.isEmpty() ? "Nessuna" : special) + "\n" +
				    "Raro: " + rare +
				    "\n-----------------------------\n";
			i++;

			if(def > majorDefense) {
				majorDefense = (int) def;
				highDefense += name + ", ";
			}
			if(life < minLife) {
				minLife = life;
				lowLife ="\nNome personaggio: "+name + "\n"+
						"Attacco: "+ atk +"\n"+
						"Difesa: "+ def +"\n"+
						"Vita: "+ life +"\n"+
						"Abilita': " + (special.isEmpty() ? "Nessuna" : special) + "\n" +
						"Raro: "+ rare +
						"\n-----------------------------";;
			}

			rareName += (rare == true) ? 1 : 0;

			if(!special.isEmpty()) {
				attackSumWithAbility += atk;
				countAbility++;
			}
			if(rare == true && atk > 10) {
				lifeRareSum += life;
				countLifeRare ++;
			}
			if(def > atk + (atk*5/100) ) {
				defSup = "\nNome personaggio: "+name + "\n"+
						"Attacco: "+ atk +"\n"+
						"Difesa: "+ def +"\n"+
						"Vita: "+ life +"\n"+
						"Abilita': " + (special.isEmpty() ? "Nessuna" : special) + "\n" +
						"Raro: "+ rare +";\n"+
						"-----------------------------\n";
			}
		}

		lifeRareSum = countLifeRare > 0 ?  lifeRareSum / countLifeRare : 0;
		attackSumWithAbility = countAbility > 0 ? attackSumWithAbility / countAbility : 0;

		file.close();

		System.out.println(
				"\tELENCO PERSONAGGI: "+ answer +
				"*********************************"+
				"\nMAGGIOR DIFESA: "+highDefense+ 
				"\n--------------------------- "+
				"\nMINOR VITA: "+ lowLife + 
				"\nNumero personaggi rari: "+ rareName +
				"\n----------------------------"+
				"\nValore medio ATT personaggi con AB: "+ 
				(int)attackSumWithAbility +
				"\n----------------------------"+
				"\nValore medio di vita personaggi rari(con ATT>10): "+ 
				lifeRareSum +
				"\n----------------------------"+
				"\nDifesa superiore almeno del 5% rispetto al loro attacco: "+ 
				(defSup.isEmpty() ? "Nessun personaggio" : defSup));
	}

}
