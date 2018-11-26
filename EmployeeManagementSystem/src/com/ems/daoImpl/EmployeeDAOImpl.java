package com.ems.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ems.bean.Employee;
import com.ems.dao.EmployeeDAO;
import com.ems.db.DBUtility;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	Scanner sc = new Scanner(System.in);
	Employee employee = null;
	PreparedStatement ps = null;

	@Override
	public void addEmployee() {
		try {
			int i =1;
			while(i==1)
			{
				employee = new Employee();
				System.out.println("Enter Employee Number ?");
				employee.setEmpno(sc.nextInt());
				System.out.println("Enter Employee Name ?");
				employee.setEname(sc.next());
				System.out.println("Enter Employee Salary ?");
				employee.setSalary(sc.nextDouble());
				Connection con = DBUtility.getConnection();
				ps = con.prepareStatement("insert into employee values(?,?,?)");
				ps.setInt(1, employee.getEmpno());
				ps.setString(2, employee.getEname());
				ps.setDouble(3, employee.getSalary());
				int n = ps.executeUpdate();
				System.out.println("Do you want add more employee press 1 else any number");
				i = sc.nextInt();
				if(n!=0)
				{
					System.out.println("Emplyee Records Successfully added.");
				}else{
					System.out.println("Employee Record Not Added.Please try again..");
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Employee viewEmployee(int empno) {
		employee = new Employee();
		try {
			Connection con = DBUtility.getConnection();
			ps = con.prepareStatement("select * from employee where empid="+empno);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				employee.setEmpno(rs.getInt(1));
				employee.setEname(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employee;
	}

	@Override
	public List<Employee> viewAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			Connection con = DBUtility.getConnection();
			ps = con.prepareStatement("select * from employee ");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				employee = new Employee();
				employee.setEmpno(rs.getInt(1));
				employee.setEname(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
				employees.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public void updateEmployee(int empno) {
		try {
			employee = new Employee();
			System.out.println("Enter Updated Employee Name ?");
			employee.setEname(sc.next());
			System.out.println("Enter Updated Employee Salary ?");
			employee.setSalary(sc.nextDouble());
			Connection con = DBUtility.getConnection();
			ps = con.prepareStatement("update employee set ename=?,salary=? where empid=?");
			ps.setString(1, employee.getEname());
			ps.setDouble(2, employee.getSalary());
			ps.setInt(3, employee.getEmpno());
			int n = ps.executeUpdate();
			if(n!=0)
			{
				System.out.println("Employee Records Successfully Updated");
			}else{
				System.out.println("Employee Record Not Updated. Please try again..");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteEmployee(int empno) {
		try {
			
		
			Connection con = DBUtility.getConnection();
			ps = con.prepareStatement("delete from employee where empid=?");
			ps.setInt(1, employee.getEmpno());
			int n = ps.executeUpdate();
			if(n!=0)
			{
				System.out.println("Employee Records Successfully Deleted");
			}else{
				System.out.println("Employee Record Not Deleted. Please try again..");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
