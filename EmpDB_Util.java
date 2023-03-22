package app.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmpDB_Util 
{
	//-->Static block execute only once at the time of class loading
	static
	{
		try {
			// -->Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
				
	}
	
	
	
	/* -->Connection is a Interface which
	 * -->getConnection()
	 * -->use to get Connection
	 */
	
	public static Connection getConnection()
	{
		Connection con=null;
		
		try {
			// -->Establish Connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=tiger");
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}

		return con;
		
	}
	
	
	/* -->closeConnection()
	 * -->use to closeCOnnection
	 */
	
	public static Connection closeConnection(Connection con)
	{
		
		if(con!=null)
		{
			try {
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
		
}
