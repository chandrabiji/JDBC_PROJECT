package com.ems.main;

import java.util.Scanner;

import com.ems.menus.EmployeeDetails;

public class EmployeeManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("-----------------------------------");
			System.out.println("|   EMPLOYEE MANANGEMENT SYSTEM   |");
			System.out.println("-----------------------------------");
			System.out.println("|    1. ADMIN                     |");
			System.out.println("|    2. USER                      |");
			System.out.println("|    3. EXIT                      |");
			System.out.println("------------------------------------");
			System.out.println("Enter Your Choice ?");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				EmployeeDetails.adminMenu();
				break;
			case 2:
				EmployeeDetails.userMenu();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Please select choice range 1-3 only");
				break;
			}
		}
	}

}
