package com.assignment.File;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileReadWriteAppend {

	/**
     * The main method displays a menu with options to list files in ascending order,
     * perform business-level file operations, or exit the program.
     */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while (choice != 3) {
			System.out.println("***File Opeartions***");
			System.out.println("1. List files in ascending order");
			System.out.println("2. Business level operations (create, remove, search)");
			System.out.println("3. Exit");
			System.out.print("Enter action number (1-3): ");
			choice = sc.nextInt();
			sc.nextLine();// consume the newline character after the integer input
			switch (choice) {
			case 1:
				listFiles();
				break;

			case 2:
				businessOperations();
				break;

			case 3:
				System.out.println("Exit from the project");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice . Please enter a number form 1 to 3");

			}
		}
	}

	 /**
     * The listFiles method lists all the files in the current directory in ascending order.
     */
	public static void listFiles() {
		File directory = new File(".");
		File[] fileList = directory.listFiles();
		Arrays.sort(fileList);
		System.out.println("List of files in current directory( ascending order) ");
		for (File file : fileList) {
			if (file.isFile()) {
				System.out.println(file.getName());
			}
		}
	}

	/**
     * The businessOperations method displays a sub-menu with options to create, remove,
     * search for files, or return to the main menu.
     */
	public static void businessOperations() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while (choice != 4) {
			System.out.println("*** Business Operations ***");
			System.out.println("1. Create a file");
			System.out.println("2. Remove a file");
			System.out.println("3. Search for a file");
			System.out.println("4. Return to main menu");
			System.out.print("Enter action number (1-4): ");
			choice = sc.nextInt();
			sc.nextLine();// consume the newline character after the integer input
			switch (choice) {
			case 1:
				createFile();
				break;
			case 2:
				removeFile();
				break;
			case 3:
				searchFile();
				break;
			case 4:
				System.out.println("Returning to main menu.");
				break;
			default:
				System.out.println("Invalid choice. Please enter a number from 1 to 4.");

			}
		}
	}


    /**
     * The createFile method prompts the user for a file name and creates a new file with that name.
     */
	public static void createFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your file name:");
		String fileName = sc.nextLine();
		File file = new File(fileName);

		try {
			if (file.createNewFile()) {
				System.out.println("File cretaed:" + file.getName());

			} else {
				System.out.println("File Already exists: ");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("An error occured while creatiing the new file: ");
			e.printStackTrace();
		}

	}
	
	 /**
     * The removeFile method prompts the user for a file name and removes the file with that name.
     */
	public static void removeFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your file name:");
		String fileName = sc.nextLine();
		File file = new File(fileName);

		if (file.delete()) {
			System.out.println("File deleted:" + fileName);
		} else {
			System.out.println("File not found:");
		}
	}

	 /**
     * The searchFile method prompts the user for a file name and searches for a file with that name.
     */
	public static void searchFile() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your file name:");
		String fileName = sc.nextLine();
		File file = new File(fileName);

		if (file.exists()) {
			System.out.println("File Already exists:" + fileName);
		} else {
			System.out.println("File not found:");
		}

	}

}
