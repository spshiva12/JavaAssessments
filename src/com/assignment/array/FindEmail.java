package com.assignment.array;

import java.util.Arrays;

public class FindEmail {

	//1st approach using forloop
	public static void findEmail(String emails[], String searchEmail) {

		boolean found = false;
		for (String email : emails) {
			if (email.equals(searchEmail)) {
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("Email found!");
		} else {
			System.out.println("Email not found!");
		}

	}
	
    //2nd approach using Arrays.binarySearch() method
	public static String findEmails(String[] emails, String search_Emails) {
		int index = Arrays.binarySearch(emails, search_Emails);
		if (index >= 0) {
			return "Email found at index " + index;
		} else {
			return "Email not found";
		}
	}

	
	//3rd approach using binarysearch algorithm
	public static void find_email(String[] email, String searchEmail) {
		int low = 0;
		int high = email.length - 1;
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (email[mid].compareTo(searchEmail) < 0) {
				low = mid + 1;
			} else if (email[mid].compareTo(searchEmail) > 0) {
				high = mid - 1;
			} else {
				System.out.println("Email found at index:" + mid + "!");
				break;
			}
		}

		if (low > high) {
			System.out.println("Email not found");
		}
	}

	public static void main(String[] args) {

		String[] emails = { "john@example.com", "jane@example.com", "doe@example.com" };
		String searchEmail = "jane@example.com";
		findEmail(emails, searchEmail);
		System.out.println();
		System.out.println(findEmails(emails, searchEmail));
		System.out.println();
		find_email(emails, searchEmail);

	}

}
