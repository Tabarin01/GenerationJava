package main;

import dao.DAOAutore;
import dao.DAOLibro;

public class Main {

	public static void main(String[] args) {
		
		
		DAOAutore a = null;

		a = new DAOAutore("libreria");

		DAOLibro l = new DAOLibro("libreria");

		
		System.out.println(l.list());
		
	}

}
