package main;

import java.io.FileNotFoundException;

import entities.Ospedale;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		Ospedale o = new Ospedale("src/res/Dati.txt");
		
		System.out.println(o.listaCompleta());
		System.out.println(o.personaGiovane());
		System.out.println(o.medicoGiovane());
		System.out.println(o.medicoPiuPagato());
		System.out.println(o.spesa("appendicite"));
		System.out.println(o.totaleSpesaOs());
		System.out.println(o.totaleSpesaRimborso());
	}

}
