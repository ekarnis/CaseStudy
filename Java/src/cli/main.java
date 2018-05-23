package cli;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		System.out.println("q: quit	b:go back #:select option");
		
		ArrayList<String> options = new ArrayList<String>();
		options.add("Login");
		options.add("Register");
		options.add("Menu");
		printOptions(options);
		
		Scanner sc = new Scanner(System.in);
	    int input = sc.nextInt();
	    
	    
	    
	
		
	    sc.close();
	}
	
	public static void printOptions(ArrayList<String> options){
		int count = 0;
		for(String option : options) {
			count++;
			System.out.println("\n" + count + ". " + option);
		}
		
	}

}
