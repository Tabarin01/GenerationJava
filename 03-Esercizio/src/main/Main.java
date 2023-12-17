package main;

import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in); 
		
		
		System.out.println("Welcome to calculate your BMI, what's your name: ");
		String name = scanner.nextLine();
		
		System.out.print("Digit you're height: ");
		double height = scanner.nextDouble();
		
		System.out.print("Digit you're weight: ");
		double weight = scanner.nextDouble();
		
		double bmi = weight/ Math.pow(height, 2);
		
		System.out.println( name + " your BMI is: "+ bmi);
		scanner.close();
		
	}

}
