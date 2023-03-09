package com.lockers;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BusinessLevelOperations{
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void operation() {
		printInstructions();
		
		boolean quit = false;
		int choice = 1;	
		while(!quit) {
			System.out.println("Enter the operations you would like to perform in Business Operation: ");
			choice = sc.nextInt();
			switch(choice) {
			case 0:
				quit=true;
				break;
			case 1:
				addfile();
				break;
			case 2:
				deleteFile();
				break;				
			case 3:
				searchForFile();
				break;
			default: 
				System.out.println("Please enter only numbers from 0-3");
				break;
			}
		}
	}
	private static void printInstructions() {
		System.out.println("Entering Business Level-Operations"
		+"\n 1 - To add a user specified file to the application"
		+"\n 2 - To delete a user specified file from the application"
		+"\n 3 - To search a user specified file from the application"
		+"\n 0 - To go back to the User Interface Interaction");
	}
	private static void searchForFile() {
		System.out.println("Enter your file name you would like to search e.g, filename.txt: ");
		String inputFile = sc.next();
		sc.nextLine();
		File searchFile = new File(inputFile);
			if(searchFile.exists()){
				System.out.println("\n"+searchFile.getName()+" found. " );
			}
			else{
				System.out.println("\n" +searchFile.getName()+" file is not found or file does not exist");
			}		
	}
	private static void deleteFile() {
		System.out.println("Enter your file name you would like to delete e.g, filename.txt: ");
		String filename = sc.next();	
		File myfile = new File(filename);
		if(myfile.delete()) {
			System.out.println("\n"+myfile.getName() +" is deleted successfully ");
		}
		else {
			System.out.println("\n"+myfile.getName() +" failed to be deleted or file does not exist");
		}		
	}
	private static void addfile() {
		try {
			System.out.println("Enter your file name you would like to create e.g, filename.txt: ");
			String filename = sc.next();
			
			File myObj = new File(filename);
			if(myObj.createNewFile()) {
				System.out.println("\n" +filename+ " File Created Successfully");
			}
			else {
				System.out.println("\nFile already exist");
			}					
		}catch (IOException e) {
			System.out.println("\nAn error occured");
			e.printStackTrace();
		}
	}
}
