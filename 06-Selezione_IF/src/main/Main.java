package main;

import java.util.Scanner;

public class Main {
	
	
	public static String checkAge (int age) {
		String answer = "";
		if(age >= 18) answer = "Maggiorenne";
		if(age<18 && age>0)  answer= "Minorenne";
		return answer;
	}

	public static void main(String[] args) {
		
		Scanner input;
		int age;
		String name;
		
		input = new Scanner(System.in);
		
		
		System.out.println("Your name: ");
		name = input.nextLine();
		System.out.println("Your age: ");
		age = Integer.parseInt(input.nextLine());
		
		 
		System.out.println("Hello sir "+ name + " you are: "+ checkAge(age));
		
		input.close();
		
	}

}
