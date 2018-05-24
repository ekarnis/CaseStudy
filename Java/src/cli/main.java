package cli;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class main {

	public static ServiceWrapper sw;
	
	public static void main(String[] args) {
		sw  = new ServiceWrapper();
		firstScreen();
	}
	
	public static void firstScreen(){
		ArrayList<String> options = new ArrayList<String>();
		options.add("Login");
		options.add("Register");
		options.add("Menu");
		int count = 0;
		for(String option : options) {
			count++;
			System.out.println("\n" + count + ". " + option);
		}
		
		Scanner sc = new Scanner(System.in);
	    String input = sc.next();
	    switch(input){
    		case "1":
    			loginScreen();
    		case "2":
    			registerScreen();    	
    		case "3":
    			menuScreen();
    		case "q":
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
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	    
	    sc.close();

	}
	public static void registerScreen(){
		
	}
	public static void menuScreen(){
		
	}
	public static void homeScreen(){
		
	}
	


}
