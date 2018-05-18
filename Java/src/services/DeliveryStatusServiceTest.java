package services;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeliveryStatusServiceTest {
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "chandler";
	private static final String DB_PASSWORD = "pass";
	
	static Connection con;

	@BeforeClass
	public static void beforeClass(){
		con = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			con = DriverManager.getConnection(
				DB_CONNECTION, DB_USER,DB_PASSWORD);
			
			con.setAutoCommit(false);
			
			return;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@AfterClass
	public static void afterClass(){
		try {
			con.setAutoCommit(true);
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Before
	public void beforeTests(){
		try {
			con.rollback();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@After
	public void afterTests(){
		try {
			con.rollback();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void addTest() {
		
		DeliveryStatus ds = new DeliveryStatus("5", "Trashed");
		DeliveryStatusService dss = new DeliveryStatusService(con);
		
		dss.add(ds);
		
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT * FROM DELIVERY_STATUSES WHERE DELIVER_STATUS_ID = '5'");
			rs.next();
			
			assertEquals("5",rs.getString("DELIVERY_STATUS_ID"));
			assertEquals("Trashed",rs.getString("DELIVERY_STATUS"));
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void updateTest() {
		
		DeliveryStatus ds = new DeliveryStatus("5", "Trashed");
		DeliveryStatusService dss = new DeliveryStatusService(con);
		
		dss.add(ds);
		
		ds.setDelivery_status_id("7");
		ds.setDelivery_status("Money");
		dss.update(ds);
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT * FROM DELIVERY_STATUSES WHERE DELIVER_STATUS_ID = '7'");
			rs.next();
			
			assertEquals("7",rs.getString("DELIVERY_STATUS_ID"));
			assertEquals("Money",rs.getString("DELIVERY_STATUS"));
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void deleteTest() {
		
		DeliveryStatus ds = new DeliveryStatus("5", "Trashed");
		DeliveryStatusService dss = new DeliveryStatusService(con);
		
		dss.add(ds);
		

		dss.deleteByID("5");
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT * FROM DELIVERY_STATUSES WHERE DELIVER_STATUS_ID = '5'");
			
			assertEquals(rs.next(), false);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void getByIDTest(){
		DeliveryStatusService dss = new DeliveryStatusService(con);
		DeliveryStatus ds = dss.getByID("2");
		
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT * FROM DELIVERY_STATUSES WHERE DELIVER_STATUS_ID = '2'");
			
			DeliveryStatus dstest = new DeliveryStatus(rs.getString(1), rs.getString(2));
			
			assertEquals(ds, dstest);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	@Test
	public void getAllTest() {
		
		DeliveryStatusService dss = new DeliveryStatusService(con);
		ArrayList<DeliveryStatus> deliveryStatuses = dss.getAll();
		
		ArrayList<DeliveryStatus> deliveryStatusesTest = new ArrayList<DeliveryStatus>();
		
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT * FROM DELIVERY_STATUSES");
			
			while(rs.next()){
				deliveryStatusesTest.add(new DeliveryStatus(
						rs.getString("DELIVERY_STATUS_ID"), 
						rs.getString("DELIVERY_STATUS")));
			}
			System.out.println(deliveryStatuses);
			System.out.println(deliveryStatusesTest);
			
			assertEquals(deliveryStatuses, deliveryStatusesTest);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
}
