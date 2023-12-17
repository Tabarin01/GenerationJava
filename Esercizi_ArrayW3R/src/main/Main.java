package main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		while (true) {
			printMenu();
			int choice = Integer.parseInt(input.nextLine());


			switch (choice) {
			case 0:
				System.out.println("Exiting the program. Goodbye!");
				input.close();
				System.exit(0);
				break;
			case 1:
				exercise1();
				break;


			default:
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
	}

	private static String space() {
		return "\n\n\n//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\\n\n\n";
	}

	private static void printMenu() {
		System.out.println(space()+"\tChoose an exercise:" +"\n"
				+ "0. Exit; \n" 
				+ "1. Exercise 1; \n" 
				+ "2. Exercise 3; \n" 
				+ "3. Exercise 5; \n" 
				+ "4. Exercise 6; \n" 
				+ "5. Exercise 7; \n" 
				+ "6. Exercise 8; \n" 
				+ "7. Exercise 9; \n" 
				+ "8. Exercise 10; \n" 
				+ "9. Exercise 11; \n" 
				+ "10. Exercise 12; \n" 
				+ "11. Exercise 13; \n" 
				+ "12. Exercise 14; \n" 
				+ "13. Exercise 15; \n" 
				+ "14. Exercise 16; \n" 
				+ "15. Exercise 20; \n" 
				+ "16. Exercise 24; \n" 
				+ "17. Exercise 27; \n" 
				+ "18. Exercise 29; \n" 
				+ "19. Exercise 30; \n" 
				+ "20. Exercise 31; \n"
				+ "21. Exercise 32; \n");
		System.out.print("Enter your choice: ");
	}

	public static void exercise1() {

		//Write a Java program to sort a numeric array and a string array.

		int[] arrayN = {1789, 2035, 1899, 1456, 2013, 
				1458, 2458, 1254, 1472, 2365, 
				1456, 2165, 1457, 2456 };

		String[] arrayS = {"Java","Python","PHP","C#","C Programming","C++" };

		System.out.println("Numeric array: " + Arrays.toString(arrayN));

		System.out.println("String array: "+ Arrays.toString(arrayS));

		Arrays.sort(arrayN);
		Arrays.sort(arrayS);

		System.out.println("Sorted numeric array: " + Arrays.toString(arrayN));
		System.out.println("Sorted string array: "+ Arrays.toString(arrayS));
	}

	public static void exercise2() {

	}

}
