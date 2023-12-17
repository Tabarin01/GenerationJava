package main;

import java.util.Scanner;



public class BasicExercise {




	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		//exercise6(input);
		//exercise11(input);
		//exercise15();
		//exercise17(input);
		//exercise19(input);


	}

	public static void exercise19(Scanner input) {

		System.out.println("Digit an integer and i will trasform it in binary: ");
		int number = Integer.parseInt(input.nextLine());
		int i=0;
		int[] binary = new int[100];



		while(number != 0) {
			binary[i++] = number %2;
			number = number/2;
		}
		System.out.println("Binary number is: ");
		for (int j = i -1; j >= 0; j--) {
			System.out.print(binary[j]);
		}
	}

	public static void exercise17(Scanner input) {
		long binary1, binary2;
		int[] sum = new int[20];
		int i = 0, remainder = 0;
		System.out.println("Input the first binary number: ");
		binary1 = input.nextLong();
		System.out.println("Input the second binary number: ");
		binary2 = input.nextLong();

		// Perform binary addition while there are digits in the binary numbers
		while (binary1 != 0 || binary2 != 0) 
		{
			// Calculate the sum of binary digits and update the remainder
			sum[i++] = (int)((binary1 % 10 + binary2 % 10 + remainder) % 2);
			remainder = (int)((binary1 % 10 + binary2 % 10 + remainder) / 2);
			binary1 = binary1 / 10;
			binary2 = binary2 / 10;
		}

		// If there is a remaining carry, add it to the sum
		if (remainder != 0) {
			sum[i++] = remainder;
		}

		// Decrement the index to prepare for printing
		--i;

		// Display the sum of the two binary numbers
		System.out.print("Sum of two binary numbers: ");
		while (i >= 0) {
			System.out.print(sum[i--]);
		}

		System.out.print("\n");  
	} 

	public static void exercise15() {
		//Swapping variables
		int var1, var2, temp;
		var1 = 10;
		var2 = 20;
		System.out.println(var1+" , "+var2);
		temp = var1;
		System.out.println(var1+" , "+var2+" , "+temp);
		var1 = var2;
		System.out.println(var1+" , "+var2+" , "+temp);
		var2 = temp;
		temp = 0;
		System.out.println(var1+" , "+var2);
	}

	public static void exercise11(Scanner input) {
		//Perimeter and Area of a circle
		double radius;
		System.out.println("Digit the radius to calculate perimeter and area: ");
		radius = Double.parseDouble(input.nextLine());
		double perimeter = 2 * Math.PI * radius;
		double area = Math.PI * radius * radius;
		System.out.println("Perimeter = " + perimeter + "\nArea = " + area);
	}

	public static void exercise6(Scanner input) {
		int num1, num2, num3, num4, num5;
		System.out.println("First number: ");
		num1 = Integer.parseInt(input.nextLine());
		System.out.println("Second number: ");
		num2 = Integer.parseInt(input.nextLine());
		int choise = 0;
		System.out.println("1.Sum \n2.Difference \n3.Product \n4.Divide");
		choise = Integer.parseInt(input.nextLine());
		input.close();

		switch (choise) {
		case 1:
			System.out.println("Sum = "+ (num1 + num2));
			break;
		case 2:
			System.out.println("Difference = "+ (num1 - num2));
			break;
		case 3:
			System.out.println("Product = "+ (num1 * num2));
			break;
		case 4:
			System.out.println("Divide = "+ (num1 / num2));
			break;
		case 5:
			System.out.println("Module = "+ (num1 / num2));
			break;
		case 6:
			System.out.println("Enter third number: ");
			num3 = Integer.parseInt(input.nextLine());
			System.out.println("Enter fourth number: ");
			num4 = Integer.parseInt(input.nextLine());
			System.out.println("Enter fifth number: ");
			num5 = Integer.parseInt(input.nextLine());
			System.out.println("Average of five numbers = "+ (num1 + num2 + num3+ num4 + num5)/5);
			break;
		default:
			System.out.println("Wrong choise!");
			return;

		}
	}

}
