package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {

	
	 private static Connection connection;





	    static {
	        String url="jdbc:postgresql://localhost:5432/PharmacyAdmin";
	        String username="postgres";
	        String password="azer123";

	        try {
	            Class.forName("org.postgresql.Driver");

	            connection =DriverManager.getConnection(url,username,password);
                   

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();


	    }

	       
	

	    }


		public static Connection getConnection() {
			// TODO Auto-generated method stub
			return connection;
		}
}
