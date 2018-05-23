package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Connection con;
	static Statement stat;
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
			System.out.println("Connection successful");
			
			stat = con.createStatement();
			
			System.out.println("Connected...");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//scanner
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Mimmys Resturaunt");
		System.out.println("1.Login");
		System.out.println("2.Register");
		System.out.println("3.Guest User");
		int choice = scan.nextInt();
		switch(choice){
			case 1: System.out.println("Not yet supported");
				break;
			case 2: System.out.println("Not yet supported");
			break;
			case 3: menu();
			break;
		}
	}
	
	private static void menu(){
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------Menu------------------");
		ArrayList<Menu> menArr = new ArrayList<Menu>();
		MenuServices menServ = new MenuServices(con);
		menArr = menServ.getAll();
		int count = 1;
		for(Menu men:menArr){
			System.out.println(count + ". " + men.getName());
			count++;
		}
		int choice = scan.nextInt();
		Menu m = menArr.get(choice-1);
		System.out.println(m.getName() + "\n" + m.getDescription() + "\n$" + m.getPrice());
		
	}

}
