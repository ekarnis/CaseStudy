package cli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import domain.Menu;
import domain.Order;
import domain.Store;
import domain.User;
import services.MenuServices;
import services.OrderService;
import services.StoreService;
import services.UserService;

public class Tiger{

	public static ServiceWrapper sw;
	public static Connection con;
	public static User currentUser;
	public static Order currentOrder;
	public static Store currentStore;
	
	static Scanner sc;

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "pass", "pass");
		} catch (Exception e) {
			e.printStackTrace();
		}
		sw  = new ServiceWrapper(con);
		sc = new Scanner(System.in);
		firstScreen();
		sc.close();
	}
	
	public static void firstScreen(){
		System.out.println(" __  __ _                     _ _        _____       __     \n|  \\/  (_)                   (_| )      / ____|     / _|    \n| \\  / |_ _ __ ___  _ __ ___  _|/ ___  | |     __ _| |_ ___ \n| |\\/| | | '_ ` _ \\| '_ ` _ \\| | / __| | |    / _` |  _/ _ \\\n| |  | | | | | | | | | | | | | | \\__ \\ | |___| (_| | ||  __/\n|_|  |_|_|_| |_| |_|_| |_| |_|_| |___/  \\_____\\__,_|_| \\___|");
		ArrayList<String> options = new ArrayList<String>();
		options.add("Login");
		options.add("Register");
		options.add("Quit");
		int count = 0;
		for(String option : options) {
			count++;
			System.out.println(count + ". " + option);
		}
		
	    int input = sc.nextInt();
	    switch(input){
    		case 1:
    			loginScreen();
    		case 2:
    			registerScreen();    	
    		case 3:
    			System.out.println("Goodbye");
    			System.exit(0);
    		case 4:
    			AdminAndManager aam = new AdminAndManager(con);
    			aam.adminScreen();
	    }

	}
		
	public static void loginScreen(){
		System.out.println("*Login*");
		System.out.println("Enter email:");
	    String email = sc.next();
		System.out.println("Enter password:");
	    String password = sc.next();
	    
		UserService us = new UserService(con);
		User candidate = us.getByEmail(email);
		if(password.equals(candidate.getPassword())){
			currentUser = candidate;
			currentOrder = new Order();
			currentOrder.setOrder_id(Double.toString(Math.random()* 10001));
			currentOrder.setUser_id(currentUser.getUserId());
			currentOrder.setDelivery_status_id("0");
			//currentOrder.setCard_id();
			StoreService ss = new StoreService(con);
			currentStore = ss.getById("0");
	    	System.out.println("Welcome " + currentUser.getFirstName());
	    	homeScreen();
	    }
	    else{
	    	System.out.println("Wrong email or password");
	    	try {
				TimeUnit.SECONDS.sleep(1);
				loginScreen();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }


	}
	public static void registerScreen(){
		System.out.println("*Register*");
		System.out.println("Enter email:");
	    String email = sc.next();
		System.out.println("Enter password:");
	    String password = sc.next();
		System.out.println("Enter first name:");
	    String first = sc.next();
		System.out.println("Enter last name:");
	    String last = sc.next();
		System.out.println("Enter phone:");
	    String phone = sc.next();
		/*System.out.println("Enter street:");
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
	    String status = sc.next();*/
	    //, street, city, state, country, zip, status
	    if(sw.register(first, last, phone, email, password)) {
	    	System.out.println("Registered");
	    	homeScreen();
	    }
	    else{
	    	System.out.println("Wrong email or password");
			loginScreen();
	    }
	    

	}

	public static void homeScreen(){
		System.out.println("*Home*");
		ArrayList<String> options = new ArrayList<String>();
		options.add("Menu");
		options.add("Order");
		options.add("Account");
		options.add("Store Details");
		options.add("Logout");
		options.add("Quit");
		int count = 0;
		for(String option : options) {
			count++;
			System.out.println(count + ". " + option);
		}
	    int input = sc.nextInt();
		if(input==1) menuScreen();
		if(input==2) currentOrderScreen();    	
		if(input==3) accountScreen();
		if(input==4) storeDetailsScreen();   	
		if(input==5) loginScreen();
		if(input==6) {
			System.out.println("Goodbye");
    		System.exit(0);
	    }
	}
	
	public static void menuScreen(){
		System.out.println("*Menu*");
		MenuServices ms = new MenuServices(con);
		ArrayList<Menu> menus = ms.getAll();
		ServiceWrapper.printMenuItems(menus);
	    int input = sc.nextInt();
	    if(input==menus.size()+1) homeScreen();
	    else menuItemScreen(menus.get(input-1));
	}
	public static void menuItemScreen(Menu menu){
		System.out.println(menu.getName());
		System.out.println(menu.getDescription());
		System.out.println("$" + menu.getPrice());
		System.out.println("1. Enter Quantity");
		System.out.println("2. Go Back");
	    int input = sc.nextInt();
	    if(input==1) itemQuantityScreen(menu);
	    else if(input==2) menuScreen();
	}
	//TODO finish this
	public static void itemQuantityScreen(Menu menu){
		System.out.println("Enter Quantity");
	    int input = sc.nextInt();
	    for(int i=0;i<input;i++) currentOrder.addItem_id(menu.getId());
		System.out.println("Item(s) added");
		menuScreen();
	}
	public static void currentOrderScreen() {
		System.out.println("*Current Order*");
		System.out.println("Placed: " +currentOrder.getPlaced_timestamp());
		System.out.println("Delivered: " +currentOrder.getDelivery_timestamp());
		System.out.println("Total price: " +currentOrder.getTotal_price());
		System.out.println("Method: " +currentOrder.getDelivery_method_id());
		System.out.println("Status: " +currentOrder.getDelivery_status_id());
		System.out.println("1. Cancel");
		System.out.println("2. View Items");
		System.out.println("3. Edit Order");
		System.out.println("4. Submit Order");
		System.out.println("5. Go Back");
	    int input = sc.nextInt();
	    if(input==1 && confirm()) sw.cancelOrder(currentOrder);
	    if(input==2) viewOrderItems(currentOrder);
	    if(input==3) editOrder(currentOrder);
	    if(input==4 && confirm()) sw.submitOrder(currentOrder);
	    else if(input==5) homeScreen();
	}

	private static void editOrder(Order order) {
		// TODO Auto-generated method stub
		System.out.println("Edit Order");

		
	}
	
	//TODO get item from item id here
	private static void viewOrderItems(Order order) {
		System.out.println("*View Items*");
		ArrayList<String> itemIds = currentOrder.getItem_ids();
		System.out.println("Order items: " + itemIds);
		ArrayList<Menu> items = sw.getMenuItems(itemIds);
		System.out.println("Menu items: " + items);
		ServiceWrapper.printMenuItems(items);
	    int input = sc.nextInt();
	    if(input==items.size()) homeScreen();
	    else if(input==items.size()+1) currentOrderScreen();
	    else orderItemScreen(items.get(input));
	}
	public static void orderItemScreen(Menu menu){
		/*System.out.println(menu.getName());
		System.out.println(menu.getDescription());
		System.out.println(menu.getPrice());
		System.out.println("1. Enter Quantity");
		System.out.println("2. Go Back");
		Scanner sc = new Scanner(System.in);
	    int input = sc.nextInt();
	    if(input==1) itemQuantityScreen(menu);
	    else if(input==2) System.exit(0);*/
	}

	//TODO
	public static void submitOrder(){
		System.out.println("*Submit*");

	    //OrderService os = new OrderService(con);
	    //input should be equal to number of items in order
	    //Menu menu = null;
	   // int input = 0;
	    //for(int i=0;i<input;i++){
	    	//create order item and add to item
	    	//os.addItem_id(menu.getId(), currentOrder.getOrder_id());
	   // }
	}
	
	public static void accountScreen(){
		System.out.println("*Account*");
		ArrayList<String> options = new ArrayList<String>();
		options.add("Edit First Name");
		options.add("Edit Last Name");
		options.add("Edit Email");
		options.add("Edit Password");
		options.add("Edit Phone Number");
		options.add("Edit Payment Options");
		options.add("Edit Saved Locations");
		options.add("View Orders");
		options.add("Go Back");
		int count = 0;
		for(String option : options) {
			count++;
			System.out.println(count + ". " + option);
		}
	    int input = sc.nextInt();
    		if(input==1){
    			String newFirstName = editString();
    			currentUser.setFirstName(newFirstName);
    			System.out.println("First Name Changed to: " + newFirstName);
    		}
    		if(input==2){
    			String newLastName = editString();
    			currentUser.setLastName(newLastName);
    			System.out.println("Last Name Changed to: " + newLastName);
    		}
    		if(input==3){
    			String newEmail = editString();
    			currentUser.setEmail(newEmail);
    			System.out.println("Email Changed to: " + newEmail);
    		}
    		if(input==4){
    			String newPassword = editString();
    			currentUser.setPassword(newPassword);
    			System.out.println("Password Changed to: " + newPassword);
    		}
    		if(input==5){

    			String newPhoneNumber = editString();
    			currentUser.setPhone(newPhoneNumber);
    			System.out.println("Phone Number Changed to: " + newPhoneNumber);
    		}
    		if(input==6) editCards();
    		if(input==7) editLocations();
    		if(input==8) allOrdersScreen();
    		if(input==9) homeScreen();
	    
	    UserService us = new UserService(con);
	    us.update(currentUser);
	    accountScreen();
	}
	private static void editLocations() {
		// TODO Auto-generated method stub
		
	}

	private static void editCards() {
		// TODO Auto-generated method stub
		
	}

	private static String editString() {
		System.out.println("Enter new value");
	    String inp = sc.next();
		return inp;
	}

	public static void allOrdersScreen(){
		System.out.println("*All orders*");
		OrderService os = new OrderService(con);
		ArrayList<Order> orders = os.getUserOrders(currentUser.getUserId());
		ServiceWrapper.printOrders(orders);
	    int input = sc.nextInt();
	    if(input==orders.size()) homeScreen();
	    else oldOrderScreen(orders.get(input));
	}
	public static void oldOrderScreen(Order order) {
		System.out.println("Placed: " +order.getPlaced_timestamp());
		System.out.println("Delivered: " +order.getDelivery_timestamp());
		System.out.println("Total price: " +order.getTotal_price());
		System.out.println("Method: " +order.getDelivery_method_id());
		System.out.println("Status: " +order.getDelivery_status_id());
		System.out.println("1. Reorder");
		System.out.println("2. Go Back");
	    int input = sc.nextInt();
	    if(input==1 && confirm()) {
	    	currentOrder=order;
	    	//TODO find out what the status id this thing needs is
	    	currentOrder.setDelivery_status_id("1");
	    }
	    else if(input==2) accountScreen();
	}
	public static void storeDetailsScreen(){
		System.out.println("*Store*");
		System.out.println("Name: " + currentStore.getStoreName());
		System.out.println("Phone Number: " + currentStore.getPhoneNumber());
		System.out.println("Location: " + currentStore.getLocationId());
		System.out.println("Open: " + currentStore.getOpenTime());
		System.out.println("Close: " + currentStore.getCloseTime());
		homeScreen();
	}

	public static boolean confirm(){
		System.out.println("*Confirm*");
		System.out.println("1. Yes");
		System.out.println("2. No");
	    int input = sc.nextInt();
	    if(input==1) return true;
	    return false;
	}
}
