package cli;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		System.out.println("q: quit	b:go back #:select option");

		initialScreen();
	}
	
	public static void initialScreen(){
		ArrayList<String> options = new ArrayList<String>();
		options.add("Login");
		options.add("Register");
		options.add("Menu");
		printOptions(options);
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
		System.out.println("q: quit	b:go back #:select option");
	    String input = sc.next();

	    
	    
	    sc.close();

	}
	public static void registerScreen(){
		
	}
	public static void menuScreen(){
		
	}
	
	public static void printOptions(ArrayList<String> options){
		int count = 0;
		for(String option : options) {
			count++;
			System.out.println("\n" + count + ". " + option);
		}
		
	}

}
