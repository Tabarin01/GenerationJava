package main;

import java.io.FileNotFoundException;

import entities.Ristorante;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {


		Ristorante r = new Ristorante("src/res/ListaPiatti.txt");
		
		String[] ingredienti = {"sale","drago"};
		
		//System.out.println(r.getPiatti());
		//System.out.println(r.listaPiatti("dolce"));
		//System.out.println(r.piattiConIngrediente("sale"));
		//System.out.println(r.piattiConIngredienti(ingredienti));
		//System.out.println(r.piuCostoso());
		//System.out.println(r.menuOrdinatoPerPrezzo());
		//System.out.println(r.costoMedioMenu());
		//System.out.println(r.piattiNonValidi());
		//System.out.println(r.tipoRicorrente());
		//System.out.println(r.ingredienteRicorrente());
		//System.out.println(r.tipiRicorrenti());
		//System.out.println(r.ingredientiRicorrenti());
		System.out.println(r.menuOrdinatoPerNome());
		
	}

}
