package cli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import domain.Menu;
import domain.Order;
import domain.User;
import services.MenuServices;
import services.OrderService;
import services.UserService;

public class Tiger{

	public static ServiceWrapper sw;
	public static Connection con;
	public static User currentUser;
	public static Order currentOrder;

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
	    
		UserService us = new UserService(con);
		User candidate = us.getByEmail(email);
	    
	    currentUser = candidate;
	    if(currentUser != null) homeScreen();
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
    			currentOrderScreen();    	
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
		ServiceWrapper.printMenuItems(menus);
		Scanner sc = new Scanner(System.in);
	    int input = sc.nextInt();
	    if(input==menus.size()+1) homeScreen();
	    else if(input==menus.size()+2) System.exit(0);
	    else menuItemScreen(menus.get(input));
	    sc.close();
	}
	public static void menuItemScreen(Menu menu){
		System.out.println(menu.getName());
		System.out.println(menu.getDescription());
		System.out.println(menu.getPrice());
		System.out.println("1. Enter Quantity");
		System.out.println("2. Go Back");
		Scanner sc = new Scanner(System.in);
	    int input = sc.nextInt();
	    if(input==1) itemQuantityScreen(menu);
	    else if(input==2) System.exit(0);
	    sc.close();
	}
	//TODO finish this
	public static void itemQuantityScreen(Menu menu){
		System.out.println("Enter Quantity");
		Scanner sc = new Scanner(System.in);
	    int input = sc.nextInt();
	    //OrderItemService ois = new OrderItemService(con);
	    for(int i=0;i<input;i++){
	    	//create order item and it to item
	    }
	    sc.close();
	}
	public static void currentOrderScreen() {
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
		Scanner sc = new Scanner(System.in);
	    int input = sc.nextInt();
	    if(input==1 && confirm()) sw.cancelOrder(currentOrder);
	    if(input==2) viewOrderItems(currentOrder);
	    if(input==3) editOrder(currentOrder);
	    if(input==4 && confirm()) sw.submitOrder(currentOrder);
	    else if(input==2) System.exit(0);
	    sc.close();
	}

	private static void editOrder(Order order) {
		// TODO Auto-generated method stub
		
	}
	
	//TODO get item from item id here
	private static void viewOrderItems(Order order) {
		/*ArrayList<String> items = order.getItem_ids();
		ArrayList<String> itemNames = sw.getItemNames();
		ServiceWrapper.printOptions(items);
		Scanner sc = new Scanner(System.in);
	    int input = sc.nextInt();
	    if(input==items.size()+1) homeScreen();
	    else if(input==items.size()+2) System.exit(0);
	    else orderItemScreen(items.get(input));
	    sc.close();*/
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
	    else if(input==2) System.exit(0);
	    sc.close();*/
	}

	public static void accountScreen(){
		
	}
	public static void allOrdersScreen(){
		OrderService os = new OrderService(con);
		ArrayList<Order> orders = os.getUserOrders(currentUser.getUserId());
		ServiceWrapper.printOrders(orders);
		Scanner sc = new Scanner(System.in);
	    int input = sc.nextInt();
	    if(input==orders.size()+1) homeScreen();
	    else if(input==orders.size()+2) System.exit(0);
	    else oldOrderScreen(orders.get(input));
	    sc.close();
	}
	public static void oldOrderScreen(Order order) {
		System.out.println("Placed: " +order.getPlaced_timestamp());
		System.out.println("Delivered: " +order.getDelivery_timestamp());
		System.out.println("Total price: " +order.getTotal_price());
		System.out.println("Method: " +order.getDelivery_method_id());
		System.out.println("Status: " +order.getDelivery_status_id());
		System.out.println("1. Reorder");
		System.out.println("2. Go Back");
		Scanner sc = new Scanner(System.in);
	    int input = sc.nextInt();
	    if(input==1 && confirm()) {
	    	currentOrder=order;
	    	//TODO find out what the status id this thing needs is
	    	currentOrder.setDelivery_status_id("1");
	    }
	    else if(input==2) System.exit(0);
	    sc.close();
	}
	public static void storeDetailsScreen(){
		
	}
	public static void contactScreen(){
		
	}
	public static boolean confirm(){
		System.out.println("1. Yes");
		System.out.println("2. No");
		Scanner sc = new Scanner(System.in);
	    int input = sc.nextInt();
	    sc.close();
	    if(input==1) return true;
	    return false;
	}
}
