package data;

import java.sql.*;

public class DBConnection {
	private Connection connect;
	private String serverURL = "fordm13.vergil.u.wasington.edu";
	
	
	public DBConnection(String dbURL){
		try{
			Class.forName(serverURL);
			connect = DriverManager.getConnection(dbURL);
			System.out.println("Connected");
		} catch (Exception ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
	} //end initialization
	
	
	//Select query
	public String SelectQuery(String query) {
		Statement state;
		String result = "";
		try{
			state = connect.createStatement();
			String queryString;
			if(query.equals("")){
				queryString = "";//TODO
			}else{
				queryString = query;
			}
			
			ResultSet rSet = state.executeQuery(queryString);
			while(rSet.next()){
				result = rSet.getString(1);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	//update Query
	public int Update(String query){
		Statement state;
		int result = 0;
		try {
			state = connect.createStatement();
			state.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}