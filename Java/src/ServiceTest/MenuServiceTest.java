package ServiceTest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import services.Menu;
import services.MenuServices;

public class MenuServiceTest {
	static Connection con;
	static Statement stat;
	
	
	@BeforeClass
	public static void beforeAll(){
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
	}
	
	@After
	public void after(){
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void afterAll(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void addTest() {
		
		Menu men = new Menu("5", "Hamburger", 'n', "1", "A quarterpound hamburger with lettuce, cheese, and tomatoes", "0", null, (float) 3.45);
				
		MenuServices menServ = new MenuServices(con);
		
		menServ.add(men);
		
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT * FROM items WHERE item_id = '5'");
			rs.next();
			
			assertEquals("5",rs.getString("item_id"));
			assertEquals("Hamburger",rs.getString("name"));
			System.out.println("add working?");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			fail("Entered the catch section");
		}
		
	}
	
	@Test
	public void updateTest(){
		Menu men = new Menu("1", "Hamburger", 'n', "1", "A quarterpound hamburger with lettuce, cheese, and tomatoes", "0", null, (float) 3.45);
		MenuServices menServ = new MenuServices(con);
		
		menServ.update(men);
		
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT * FROM items WHERE item_id = '1'");
			rs.next();
			
			assertEquals("1",rs.getString("item_id"));
			assertEquals("Hamburger",rs.getString("name"));
			System.out.println("add working?");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			fail("Entered the catch section");
		}
		fail("Not yet implemented");
	}
	
	@Test
	public void getByIDTest(){
		MenuServices menServ = new MenuServices(con);
		Menu men = menServ.getById("0");
		assertEquals("0", men.getId());
		assertEquals("Rice", men.getName());
	}
	
	@Test
	public void getAllTest(){
		MenuServices menServ = new MenuServices(con);
		ArrayList<Menu> menArr = menServ.getAll();
		assertEquals("0", menArr.get(0).getId());
		assertEquals("Rice", menArr.get(0).getName());
		assertEquals("1", menArr.get(1).getId());
		assertEquals("Drink", menArr.get(1).getName());
	}

	@Test
	public void deleteByIDTest(){
		MenuServices menServ = new MenuServices(con);
		menServ.deleteById("5");
		Statement stat;
		try {
			stat = con.createStatement();
			ResultSet rs = stat.executeQuery(
					"SELECT Count(*) FROM items WHERE item_id = '5'");
			rs.next();
			
			assertEquals(0,rs.getInt("count(*)"));
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			fail("Entered the catch section");

		}
	}
}
