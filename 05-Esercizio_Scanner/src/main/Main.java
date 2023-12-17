package main;

import java.util.Scanner;

public class Main {

/*Programma che calcoli le entrate annuali di un lavoratore
 * Dati: nome, stipendio medio mensile, mensilita' contrattuali (13esima), 
 * Stampare in console "Buonasera sign. [cognome] il suo lordo annuale vale [calcolo]"
 * */	
	
	public static double salaryPerYear(double salary, double months) {
		
		double totalSalary = (salary * months);
		return totalSalary;
	}
	
	public static double annualSalary ( double salary, double bonus) {
		double totalSalary = (salary * 12) + bonus;
		return totalSalary;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Your name: ");
		String name = input.nextLine();
		
		System.out.println("Your surname: ");
		String surname = input.nextLine();
		
		System.out.println("Insert your salary: ");
		double salary = Double.parseDouble(input.nextLine());
		System.out.println("Insert how many months: ");
		int months = Integer.parseInt(input.nextLine());
		
		
		System.out.println("Hello sir "+ surname + " your annual salary is: "+ salaryPerYear(salary,months));
		
		
		
		input.close();
	}
	


}
