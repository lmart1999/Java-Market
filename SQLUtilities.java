package CKPTDv5;


import java.sql.*;
import java.util.*;

public class SQLUtilities {

	private static Connection con;
    private static Statement stmt;
    private static Scanner scan = new Scanner(System.in);
    
    
	public static Connection createConnection() {
		
		scan.nextLine();
		System.out.println("What is the username for the database?");
	    String user = scan.nextLine();
	    System.out.println("What is the password?");
	    String pass = scan.nextLine();
	    System.out.println("What is the name of the database?");
	    String name = scan.nextLine();
		
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/" + name;

        System.out.println(driver);
        System.out.println(url);

        try { // load the driver 
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection successful!");

        } catch (Exception e) { // problem loading driver, class not exist?
            e.printStackTrace();
        }
        return con;
    }

   

	public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void checkConnect() {
        if (con == null) {
            con = createConnection();
        }
        if (stmt == null) {
            try {
                stmt = con.createStatement();
            } catch (SQLException e) {
                System.out.println("Cannot create the statement");
            }

        }
    }
    
    public static void createTable(boolean current) {
        String name = "";
        if (current == false) {
            System.out.println("What do you want to name the table?");
            name = scan.next();
        } else {
            name = "junk";
        }
        String query = "create table " + name + " (custId int not null, arrivalTime varchar(50), departureTime varchar(50), waitTime varchar(50), turnaroundTime varchar(50), serviceTime varchar(50), satisfaction varchar(50), line varchar(50), primary key (custId))";
        String dropString = "drop table " + name;

        checkConnect();

        try {
            // drop the table if it exists.  If it does not, it will throw a SQLException
            stmt.executeUpdate(dropString);
            System.out.println("Customer table existed so I dropped it");

        } catch (SQLException e) {
            // catch that exception and do nothing
            System.out.println("Customer table did not exist so I will create it");
        }

        try {
            // now create the table
            stmt.executeUpdate(query);
            System.out.println("Customer table created");
        } catch (SQLException e) {
            // will catch bad SQL format
            System.out.println("execute update error");
        }

    }
    
    public static void store(ArrayList<TableDataCustomer> cust, boolean current) {
        checkConnect();

        String name = "";
        if (current == false) {
            System.out.println("What was the name of the customer table?");
            name = scan.next();
        } else {
            name = "junk";
        }

        for (int i = 0; i < cust.size(); i++) {

            TableDataCustomer c = cust.get(i);
            String query = "insert into " + name + "  values(" + c.getCustId() + ",\'" + c.getArrivalTime() + "\',\'" + c.getLeaveTime() 
            + "\',\'" + c.getWaitTime() + "\',\'" + c.getTurnaroundTime() + "\',\'" + c.getServiceTime() + "\',\'" + c.getSatisfaction() 
            + "\',\'" + c.getLine() + "\')";
            System.out.println(query);
            try {
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL insert Exception");
            }
        }

    }
    
}
