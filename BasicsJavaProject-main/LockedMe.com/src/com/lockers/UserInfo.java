package com.lockers;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class UserInfo{
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void userInteraction() {
			
		boolean quit = false;
		int choice = 0;
		
		printInstructions();
		
		 while(!quit){
			System.out.println("Enter the action to perform in User Interaction: "
					+ "(1 - Display Instructions) ");
			choice = sc.nextInt();
			
			switch(choice) {		
				case 1:
					UserInfo.printInstructions();
					break;
				case 2:
					sortFiles();
					break;
				case 3:
					BusinessLevelOperations.operation();
					break;
				case 0:
					quit = true;
					Main.displayInfo();
					break;
				default: 
					System.out.println("Please enter only numbers from 0-3");
					break;
			}
		}
	}
	
	private static void printInstructions() {
		System.out.println("User Interaction Information");
		System.out.println("\t 1 - Display all instructions");
		System.out.println("\t 2 - To retrieve the file names in an ascending order");
		System.out.println("\t 3 - To enter to Business-level operations");
		System.out.println("\t 0 - To go back to the main screen");
	}
	
	private static void sortFiles() {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file path: ");
	    String dirPath = sc.nextLine(); // Takes the directory path as the user input

	    File folder = new File(dirPath);
	    if(folder.isDirectory()) {
	    	
	        File[] fileList = folder.listFiles();
	        
	        Arrays.sort(fileList);
	        
	        System.out.println("\nTotal number of items present in the directory: " + fileList.length );
	        
	        System.out.println("\nPrinting all available files in the directory");
	        
	        // Lists only files since we have applied file filter
	        for(File file:fileList) {        
	            System.out.println("\t" +file.getName());
	        }
	        System.out.println("----------------------------------------\n");
	        
	        // Creating a filter to return only files.
	        FileFilter fileFilter = new FileFilter()
	        {
	            @Override
	            public boolean accept(File file) {
	                return !file.isDirectory();
	            }
	        };

	        fileList = folder.listFiles(fileFilter);

	        // Sort files in ascending order alphabetically
	        Arrays.sort(fileList, new Comparator<Object>()
	        {
	            @Override
	            public int compare(Object f1, Object f2) {
	                return ((File) f1).getName().compareToIgnoreCase(((File) f2).getName());
	            }
	        });
	        System.out.println("Printing only files in ascending order\n ");
	        //Prints the files in file name ascending order
	        for(File file:fileList)
	        {
	        	      System.out.println(file.getName());
	        }
	        System.out.println("**********************************************");
	   }
	    else {
	    	System.out.println("Wrong Directory Path or Path doesn't exists");
	   }   
	}
}
