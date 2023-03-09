package com.lockers;

import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		System.out.println("\n****************************************************\n\n\n");	
		System.out.println("\tWelcome to LockeMe.com secure app\n\n\n\n\n");
		System.out.println("\tDeveloped by: Dakamanbha Ryngkhlem\n" + "\n\tSeptember, 2022");
		System.out.println("\n*****************************************************\n");
		
		displayInfo();
	
		boolean quit = false;
		while(!quit) {		
			System.out.println("\nEnter your choice: ");
			int choice = sc.nextInt();		
			switch(choice) {
			
				case 1: 
					UserInfo.userInteraction();
					break;
				case 2:
					quit=true;
					System.out.println("Exiting from the application...");
					break;
				default: 
					System.out.println("Please enter only numbers from 0-1");
					break;
			}		
		}		
	}
	
	public static void displayInfo() {
		System.out.println("Press #1 To continue");
		System.out.println("Press #2 To exit");			
	}
}
