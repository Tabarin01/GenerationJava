package main;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        String departureStation = "Milano Centrale";
        String arrivalStation, answer;
        double ticket;

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Which train station do you want to reach (type 'exit' to quit): ");
            arrivalStation = input.nextLine().toLowerCase();

            if (arrivalStation.equals("exit")) {
            	System.out.println("Goodbye!");
                break;
            }

            switch (arrivalStation) {
                case "bergamo":
                    ticket = 5.50;
                    answer = "Your ticket is " + ticket + " Euro";
                    break;
                case "brescia":
                    ticket = 8.60;
                    answer = "Your ticket is " + ticket + " Euro";
                    break;
                case "venezia":
                    ticket = 45.90;
                    answer = "Your ticket is " + ticket + " Euro";
                    break;
                case "napoli":
                    ticket = 79.90;
                    answer = "Your ticket is " + ticket + " Euro";
                    break;
                default:
                    answer = "Station doesn't exist!";
                    break;
            }

            System.out.println(answer);
        }

        input.close();
    }
}
