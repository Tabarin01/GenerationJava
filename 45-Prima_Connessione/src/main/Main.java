package main;

import dao.DAOPersona;
import entities.Entity;
import entities.Persona;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("\tELENCO\n\n" + DAOPersona.getInstance().read());
		
		//System.out.println("\tELENCO\n\n" + DAOPersona.getInstance().delete(4));
		
		Entity e = DAOPersona.getInstance().find(1);
		System.out.println(e);
		//((Persona)e).setCognome("PIPPO");
		//System.out.println("\n\tUPDATE: " + DAOPersona.getInstance().update(e));
		
		//Entity e = new Persona(0,"Giulio","Cesare","1945-09-04","Roma","M","Imperatore");
		//System.out.println("\n\tINSERT: " + DAOPersona.getInstance().create(e));
		
		
		
	}// FINE METODO MAIN

}// FINE CLASSE MAIN
