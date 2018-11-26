package com.ems.menus;

import java.util.List;
import java.util.Scanner;

import com.ems.bean.Employee;
import com.ems.daoImpl.EmployeeDAOImpl;
import com.ems.main.EmployeeManagement;

public class EmployeeDetails {

	static Scanner sc = new Scanner(System.in);
	static EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

	public static void adminMenu() {
		System.out.println("-----------------------------------");
		System.out.println("|       ADMIN MAIN MENU           |");
		System.out.println("-----------------------------------");
		System.out.println("|   1. ADD EMPLOYEE               |");
		System.out.println("|   2. VIEW EMPLOYEE              |");
		System.out.println("|   3. VIEW ALL EMPLOYEES         |");
		System.out.println("|   4. UPDATE EMPLOYEE            |");
		System.out.println("|   5. DELETE EMPLOYEE            |");
		System.out.println("|   6. BACK                       |");
		System.out.println("------------------------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			employeeDAO.addEmployee();
			adminMenu();
			break;
		case 2:
			System.out.println("Enter Search Employee Number ?");
			Employee employee = employeeDAO.viewEmployee(sc.nextInt());
			System.out.println("EMPID" + "\t" + "ENAME" + "\t" + "SALARY");
			System.out.println("---------------------------------");
			System.out.println(employee);
			adminMenu();
			break;
		case 3:
			List<Employee> employees = employeeDAO.viewAllEmployees();
			System.out.println("EMPID" + "\t" + "ENAME" + "\t" + "SALARY");
			System.out.println("---------------------------------");
			for (Employee e : employees) {
				System.out.println(e);
			}
			adminMenu();
			break;
		case 4:
			System.out.println("Enter Employee Number ?");
			employeeDAO.updateEmployee(sc.nextInt());
			adminMenu();
			break;
		case 5:
			System.out.println("Enter Delete Employee Number ?");
			employeeDAO.deleteEmployee(sc.nextInt());
			adminMenu();
			break;
		case 6:
			EmployeeManagement.main(null);
			break;
		default:
			System.out.println("Please select choice range 1-6 only");
			break;

		}
	}

	public static void userMenu() {

		System.out.println("-----------------------------------");
		System.out.println("|       USER MAIN MENU            |");
		System.out.println("-----------------------------------");
		System.out.println("|   1. VIEW EMPLOYEE              |");
		System.out.println("|   2. UPDATE EMPLOYEE            |");
		System.out.println("|   3. BACK                       |");
		System.out.println("------------------------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter Search Employee Number ?");
			Employee employee = employeeDAO.viewEmployee(sc.nextInt());
			System.out.println("EMPID" + "\t" + "ENAME" + "\t" + "SALARY");
			System.out.println("---------------------------------");
			System.out.println(employee);
			userMenu();
			break;
		case 2:
			System.out.println("Enter Employee Number ?");
			employeeDAO.updateEmployee(sc.nextInt());
			userMenu();
			break;
		case 3:
			EmployeeManagement.main(null);
			break;
		default:
			System.out.println("Please select choice range 1-3 only");
			break;
		}
	}

}
