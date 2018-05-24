package cli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import domain.Menu;
import services.MenuServices;

public class main {

	public static ServiceWrapper sw;
	public static Connection con;

	
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "pass", "pass");
		} catch (Exception e) {
			e.printStackTrace();
		}
		sw  = new ServiceWrapper(con);
		firstScreen();
	}
	
	public static void firstScreen(){
		ArrayList<String> options = new ArrayList<String>();
		options.add("Login");
		options.add("Register");
		options.add("Quit");
		int count = 0;
		for(String option : options) {
			count++;
			System.out.println("\n" + count + ". " + option);
		}
		
		Scanner sc = new Scanner(System.in);
	    int input = sc.nextInt();
	    switch(input){
    		case 1:
    			loginScreen();
    		case 2:
    			registerScreen();    	
    		case 3:
    			System.exit(0);
	    }
	    sc.close();

	}
		
	public static void loginScreen(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email:");
	    String email = sc.next();
		System.out.println("Enter password:");
	    String password = sc.next();
	    if(sw.login(email, password)) homeScreen();
	    else{
	    	System.out.println("Wrong email or password");
	    	try {
				TimeUnit.SECONDS.sleep(3);
				loginScreen();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	    sc.close();

	}
	public static void registerScreen(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email:");
	    String email = sc.next();
		System.out.println("Enter password:");
	    String password = sc.next();
		System.out.println("Enter first name:");
	    String first = sc.next();
		System.out.println("Enter last name:");
	    String last = sc.next();
		System.out.println("Enter street:");
	    String street = sc.next();
		System.out.println("Enter city:");
	    String city = sc.next();
		System.out.println("Enter state:");
	    String state = sc.next();
		System.out.println("Enter country:");
	    String country = sc.next();
		System.out.println("Enter zip:");
	    String zip = sc.next();
		System.out.println("Enter status:");
	    String status = sc.next();

	    if(sw.register(first, last, email, password, street, city, state, country, zip, status)) homeScreen();
	    else{
	    	System.out.println("Wrong email or password");
	    	try {
				TimeUnit.SECONDS.sleep(3);
				loginScreen();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	    
	    sc.close();

	}

	public static void homeScreen(){
		ArrayList<String> options = new ArrayList<String>();
		options.add("Menu");
		options.add("Order");
		options.add("Account");
		options.add("Store Details");
		options.add("Contact");
		options.add("Logout");
		ServiceWrapper.printOptions(options);
		Scanner sc = new Scanner(System.in);
	    int input = sc.nextInt();
	    switch(input){
    		case 1:
    			menuScreen();
    		case 2:
    			orderScreen();    	
    		case 3:
    			accountScreen();
    		case 4:
    			storeDetailsScreen();
    		case 5:
    			contactScreen();    	
    		case 6:
    			loginScreen();
    		case 7:
    			System.exit(0);
	    }
	    sc.close();
	}
	
	public static void menuScreen(){
		MenuServices ms = new MenuServices(con);
		ArrayList<Menu> menus = ms.getAll();
		sw.printMenuOptions(menus);
		Scanner sc = new Scanner(System.in);
	    int input = sc.nextInt();
	    if(input==menus.size()+1) homeScreen();
	    else if(input==menus.size()+2) System.exit(0);
	    else itemScreen(menus.get(input));
	}
	public static void itemScreen(Menu menu){
		System.out.println(menu.getName());
		System.out.println(menu.getDescription());
		System.out.println(menu.getPrice());
		System.out.println("1. Enter Quantity");
		System.out.println(menu.getPrice());
	}
	public static void orderScreen(){
		
	}
	public static void accountScreen(){
		
	}
	public static void storeDetailsScreen(){
		
	}
	public static void contactScreen(){
		
	}

	


}
