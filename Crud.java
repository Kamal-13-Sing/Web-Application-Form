package form;

import java.sql.*;
public class Crud {
	
//---------------------Connection Established-----------------------
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/projectJDBC";
			String username = "root";
			String password = "";
			
			con = DriverManager.getConnection(url,username, password);
			
			//System.out.println("Sucess");
		     //con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
//---------------------------create database---------------------------
	
	public void createDatabase() {
		
		try {
			Crud cr = new Crud();
			Connection con = cr.getConnection();
			//Connection con = Crud.getConnection();
			
			Statement stm = con.createStatement();
			
			String database = "create database projectJDBC";
			int r = stm.executeUpdate(database);
			
			if(r > 0) {
				System.out.println("Database Created");
			}else {
				System.out.println("Failed to create database");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

//----------------------Create Table-----------------------------------
	
	public void createTable() {
		try {
			Connection con = Crud.getConnection();
			Statement stm = con.createStatement();
			
			String table = "create table form2nd(name varchar(100),"
					+ " address varchar(150),date_of_birth varchar(50), phone varchar(10)unique,"
					+ " gender varchar(50), duration varchar(50), quires varchar(200))";
			
			stm.executeUpdate(table);
			
			System.out.println("Table Created");
			con.close();
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
//---------------------insert data into table---------------------------
	
	public static int insertData(GetSet gs) {
		int status = 0;
		try {
			
			Connection con = getConnection();
			String insert = "insert into form(name,address,date_of_birth,phone,gender,duration,quires)values(?,?,?,?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(insert);
		
			pst.setString(1, gs.getName());
			pst.setString(2, gs.getAddress()); 
			pst.setString(3, gs.getDob());
			pst.setString(4, gs.getPhone());
			pst.setString(5, gs.getGender());
			pst.setString(6, gs.getCourse());
			pst.setString(7, gs.getTextarea());
			
			status  = pst.executeUpdate();
			System.out.println("Inserted");
			con.close();
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return status;
	}
	
	
	
//-----------------------read--------------------------
	public static int readData() {
		int status = 0;
		
		try {
			Connection con = getConnection();
			Statement stm = con.createStatement();
			
			String read = "select * from form";
			ResultSet data = stm.executeQuery(read);
			
			while(data.next()) {
				
			}
			
		}catch(Exception ex) {
			
		}
		
		return status;
	}

//-----------------------Update------------------------------
	
	public static int updateData(GetSet gs) {
		int status = 0;
		
		try {
			
			Connection con = getConnection();
			String update = "update form set name=?,address=?,date_of_birth=?,"
					+ "gender=?,duration=?,quires=? where phone=?";
			
			PreparedStatement stm = con.prepareStatement(update);
			stm.setString(1, gs.getName());
			stm.setString(2, gs.getAddress());
			stm.setString(3, gs.getDob());
			stm.setString(4, gs.getGender());
			stm.setString(5, gs.getCourse());
			stm.setString(6, gs.getTextarea());
			stm.setString(7, gs.getPhone());
			
			 
			status = stm.executeUpdate();
			
			con.close();
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return status;
	}
//---------------------------Delete--------------------------
	
	public static int deleteData(GetSet gs) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			String delete = "delete from form where phone=?";
			PreparedStatement stm = con.prepareStatement(delete);
			
			stm.setString(1,gs.getPhone());
			
			status = stm.executeUpdate();
			con.close();
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		
		return status;
	}
	
	public static void main(String[] args) {
		Crud c = new Crud();
		//c.getConnection();
		//c.createDatabase();
		//c.createTable();
		//c.insertdata();
		//c.test();
	}


}
