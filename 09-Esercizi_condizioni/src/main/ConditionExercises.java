package main;

import java.util.Scanner;

//Exercise from W3Resources.com CONDITIONAL STATEMENT

public class ConditionExercises {

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
				exercise1(input);
				break;
			case 2:
				exercise3(input);
				break;
			case 3:
				exercise5(input);
				break;
			case 4:
				exercise6(input);
				break;
			case 5:
				exercise7(input);
				break;
			case 6:
				exercise8(input);
				break;
			case 7:
				exercise9(input);
				break;
			case 8:
				exercise10();
				break;
			case 9:
				exercise11(input);
				break;
			case 10:
				exercise12(input);
				break;
			case 11:
				exercise13(input);
				break;
			case 12:
				exercise14(input);
				break;
			case 13:
				exercise15(input);
				break;
			case 14:
				exercise16(input);
				break;
			case 15:
				exercise20(input);
				break;
			case 16:
				exercise24(input);
				break;
			case 17:
				exercise27(input);
				break;
			case 18:
				exercise29(input);
				break;
			case 19:
				exercise30(input);
				break;
			case 20:
				exercise31(input);
				break;
			case 21:
				exercise32(input);
				break;

			default:
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
	}

	private static void printMenu() {
		System.out.println("\tChoose an exercise:" +"\n"
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

	public static void exercise1(Scanner input) {
		//Exercise 1
		//Write a Java program to get a number from 
		//the user and print whether it is positive or negative.

		String result = "";
		int num = 0;
		System.out.println("Inserisci un numero: ");
		num = Integer.parseInt(input.nextLine());
		if(num == 0) {
			result = "Numero nullo";
		}else if(num > 0) {
			result = "Numero positivo";
		}else {
			result = "Numero negativo";
		}
		System.out.println(result);
	}

	public static void exercise3(Scanner input) {
		//Write a Java program that takes three numbers
		//from the user and prints the greatest number.
		int a,b,c,max;


		System.out.println("Inserisci il primo numero: ");
		a = Integer.parseInt(input.nextLine());
		System.out.println("Inserisci il secondo numero: ");
		b = Integer.parseInt(input.nextLine());
		System.out.println("Inserisci il terzo numero: ");
		c = Integer.parseInt(input.nextLine());
		max = a;

		if(max < b) {
			max = b;
		}
		if(c > max) {
			max = c;
		}
		System.out.println(max);


		if (max > b && max >c) {
			System.out.println(max);
		}else if(b > max && b > c) {
			System.out.println(b);
		}else {
			System.out.println(c);
		}
	
	}

	public static void exercise5(Scanner input) {

		//Write a Java program that takes a number from the user 
		//and generates an integer between 1 and 7. It displays the weekday name.

		System.out.println("Input number from 1 to 7: ");
		int day = Integer.parseInt(input.nextLine());
		String dayName;
		switch(day) {
		case 1:
			dayName = "Monday";break;
		case 2:
			dayName = "Tuesday";break;
		case 3:
			dayName = "Wednesday";break;
		case 4:
			dayName = "Thursday";break;
		case 5:
			dayName = "Friday";break;
		case 6:
			dayName = "Saturday";break;
		case 7:
			dayName = "Sunday";break;
		default:
			System.out.println("Wrong choise");
			return;
		}
		System.out.println(dayName);
	

	}

	public static void exercise6(Scanner input) {

		//	Write a Java program that reads two floating-point numbers 
		//  and tests whether they are the same up to three decimal places.


		System.out.println("Digit the first floating number: ");
		double num1 = Double.parseDouble(input.nextLine());
		System.out.println("Digit the second floating number: ");
		double num2 = Double.parseDouble(input.nextLine());
		boolean result;

		//changes the double in integer and multiply 
		//*1000 to check if the three decimal places are the same
		num1 = (int)(num1*1000);
		num2 = (int)(num2*1000);

		result = num1 == num2;

		System.out.println("Are the two numbers equals? " + result);

	}

	public static void exercise7(Scanner input) {
		//Write a Java program to find the number of days in a month

		System.out.println("Digit the year: ");
		int year = Integer.parseInt(input.nextLine());
		System.out.println("Digit the month(1-12): ");
		int month = Integer.parseInt(input.nextLine());


		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("31 days");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30 days");
			break;
		case 2:
			if(year % 4 == 0 ){
				System.out.println("29 days");
			}else {
				System.out.println("28 days");
			}
			break;
		default:
			System.out.println("Month doesn't exist");

		}   	  	    	   	
	}

	public static void exercise8(Scanner input) {
		//Write a Java program that requires the user to enter a single character from the alphabet. Print Vowel or Consonant, depending on user input. If the user input is not a letter 
		//(between a and z or A and Z), 
		//or is a string of length > 1, print an error message.

		System.out.print("Enter a single character: ");
		String userInput = input.nextLine();
		input.close();

		if (userInput.length() == 1 && Character.isLetter(userInput.charAt(0))) {
			char letter = Character.toLowerCase(userInput.charAt(0));
			switch(letter) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'y':
				System.out.println(Character.toLowerCase(letter) + " is vowel");
				break;
			default:
				System.out.println(Character.toLowerCase(letter) + " is consonant");
			}

		} 
		else 
		{
			System.out.println("Error: Please enter a single letter.");
		}



	}

	public static void exercise9(Scanner input) {

		//Write a Java program that takes a year from the user and 
		//prints whether it is a leap year or not.
		System.out.println("Digit a year: ");
		int year = Integer.parseInt(input.nextLine());
		String answer = (year % 4) == 0 ? " is a leap year" : " is not a leap year";
		System.out.println(year + " -" + answer);

	}

	public static void exercise10() {

		//Write a Java program to display 
		//the first 10 natural numbers.
		System.out.println("First 10 natural numbers: ");

		for(int i = 1; i<11 ;i++) {

			System.out.println(i);

		}

	}

	public static void exercise11(Scanner input) {
		//Write a Java program to display 
		//n terms of natural numbers and their sum.

		int userIn, sum = 0;
		System.out.println("How many natura number you want to sum: ");
		userIn = Integer.parseInt(input.nextLine());

		for (int i = 1; i <= userIn; i++) {
			System.out.println(i);
			sum += i;
		}
		System.out.println("The sum of "+ userIn +" numbers is: "+ sum);



	}

	public static void exercise12(Scanner input) {

		int i,n=0,sum=0;
		double avg;
		{

			System.out.println("Input the 5 numbers : ");  

		}
		for (i=0;i<5;i++)
		{
			n = Integer.parseInt(input.nextLine());
			sum +=n;
		}
		avg=sum/5;
		System.out.println("The sum of 5 no is : " +sum+"\nThe Average is : " +avg);
	}

	public static void exercise13(Scanner input) {

		//Write a Java program to display the cube of 
		//the given number up to an integer
		System.out.print("Enter an integer: ");
		int n = input.nextInt();

		System.out.println("Cube of numbers from 1 to " + n + ":");

		// Displaying the cube of each number from 1 to n
		for (int i = 1; i <= n; i++) {
			int cube = i * i * i;
			System.out.println("Cube of " + i + " is: " + cube);
		}

		input.close();
	}

	public static void exercise14(Scanner userInput) {

		//Write a Java program to display the multiplication table of a given integer.
		int number;

		System.out.println("Digit an integer: ");
		number = Integer.parseInt(userInput.nextLine());

		for(int i = 0; i<=10; i++) {
			System.out.println(number +"X"+ i + " = " +(number*i));
		}

	}

	public static void exercise15(Scanner userInput) {
		//Write a Java program that displays the sum of n odd natural numbers.
		int num, sum = 0;

		System.out.println("How many odd natural numbers? ");
		num = Integer.parseInt(userInput.nextLine());

		for(int i = 0; i <= num; i++) {

			if(!(i%2==0)) {
				System.out.println(i);
				sum += i;
			}
		}
		System.out.println("Sum of odd numbers: " + sum);

	}

	public static void exercise16(Scanner userInput) {
		//Write a Java program to display the pattern like a right angle triangle with a number.
		int n;

		System.out.println("How many rows: ");
		n = Integer.parseInt(userInput.nextLine());

		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
				System.out.print(j);

			System.out.println("");
		}

	}

	public static void exercise20(Scanner userInput) {

		//Write a Java program to print Floyd's Triangle

		int row,n, column, number =1;

		System.out.println("How many numbers Floyd'triangle: ");
		n = Integer.parseInt(userInput.nextLine());

		for(row = 1; row<n ; row ++) {

			for(column = 1; column <=row; column ++) {
				System.out.print(number +" ");
				number++;
			}
			System.out.println();
		}

	}

	public static void exercise24(Scanner userInput) {
		//Write a Java program to generate the following @'s triangle.
		System.out.println("Input the number: ");
		int n = Integer.parseInt(userInput.nextLine());

		for (int i = 0; i < n; i++) 
		{
			for (int spazio = n - i; spazio > 0; spazio--) 
			{
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) 
			{
				System.out.print("@");
			}
			System.out.println();
		}
	}

	public static void exercise27(Scanner userInput) {

		//Write a Java program that reads an 
		//integer and check whether it is negative,
		//zero, or positive.

		int n;

		System.out.println("Input a number: ");
		n = Integer.parseInt(userInput.nextLine());

		if(n>0) {
			System.out.println(n + " is positive");
		}else if(n == 0) {
			System.out.println(n + " is zero");
		}else {
			System.out.println(n + " is negative");
		}


	}

	public static void exercise29(Scanner userInput) {

		long number;

		do {
			System.out.print("Enter a positive integer less than ten billion: ");
			while (!userInput.hasNextLong()) {
				System.out.println("Invalid input. Please enter a positive integer.");
				userInput.next(); // Consume the invalid input
			}
			number = userInput.nextLong();

			//to loop until the right input
		} while (number <= 0 || number >= 10_000_000_000L);

		int count = 0;
		long tempNumber = number;

		while (tempNumber > 0) {
			tempNumber /= 10;
			count++;
		}

		System.out.println("Number of digits in the number: " + count);

	}

	public static void exercise30(Scanner userInput) {

		//		Write a Java program that accepts three numbers and prints 
		//		"All numbers are equal" if all three numbers are equal,
		//		"All numbers are different" if all three numbers are different 
		//		and "Neither all are equal or different" otherwise

		int num1,num2,num3;

		System.out.println("Input first number: ");
		num1 = userInput.nextInt();
		System.out.println("Input second number: ");
		num2 = userInput.nextInt();
		System.out.println("Input third number: ");
		num3 = userInput.nextInt();

		if(num1 == num2 && num2 == num3) {
			System.out.println("All numbers are equal");
		}else if ((num1 == num2) || (num1 == num3) || (num3 == num2)){

			System.out.println("Neither all are equal or different");
		}else{

			System.out.println("All numbers are different");
		}

	}

	public static void exercise31(Scanner userInput) {

		//		Write a program that accepts three numbers from the user
		//		and prints "increasing" if the numbers are in increasing order, 
		//		"decreasing" if the numbers are in decreasing order,
		//		and "Neither increasing or decreasing order" otherwise.
		int num1,num2,num3;
		String ord = "";

		System.out.println("Input first number: ");
		num1 = userInput.nextInt();
		System.out.println("Input second number: ");
		num2 = userInput.nextInt();
		System.out.println("Input third number: ");
		num3 = userInput.nextInt();

		if(num1 > num2 && num2 > num3) {
			System.out.println("Decreasing order");
		}else if(num1 < num2 && num2 < num3) {
			System.out.println("Increasing order");
		}else {
			System.out.println("Neither increasing or decreasing order");
		}

	}

	public static void exercise32(Scanner userInput) {

		//		Write a Java program that accepts two floating­point 
		//		numbers and checks whether they are the same up to two decimal places.

		float num1, num2;

		System.out.println("Digit the first floating number: ");
		num1 = Float.parseFloat(userInput.nextLine());
		System.out.println("Digit the second floating number: ");
		num2 = Float.parseFloat(userInput.nextLine());

		if((int)num1*100 == (int)num2*100) {
			System.out.println("These numbers are equal up to 2 decimal places");
		}else {
			System.out.println("These numbers are different.");
		}
	}

}

