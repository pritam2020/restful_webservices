package com.pritam.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlienRepository {
	
	Connection con=null;
	
	public AlienRepository() {
		
		String Url ="jdbc:mysql://localhost:3306/restdb";
	    String dbUser="root";
	    String dbPassword ="pritam";
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(Url,dbUser,dbPassword);
        }catch(SQLException ex){
            System.out.println(ex +"line 24 class Alienrepo");
        }
//			Alien a1=new Alien();
//			a1.setAge(22);
//			a1.setName("victor");
//			a1.setNickname("vic");
//			
//			Alien a2=new Alien();
//			a2.setAge(23);
//			a2.setName("samuel");
//			a2.setNickname("sam");
//			aliens=new ArrayList<>();
//			aliens.add(a1);
//			aliens.add(a2);
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public ArrayList<Alien> getAllAliens() {
		ArrayList<Alien> aliens=new ArrayList<>();
		String sql="select * from Alien;";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Alien al=new Alien();
				al.setAge(rs.getInt(1));
				al.setName(rs.getString(2));
				al.setNickname(rs.getString(3));
				aliens.add(al);
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
		
		return aliens;
	}
	
	public ArrayList<Alien> getAlien(int age) {
		
		ArrayList<Alien> aliens=new ArrayList<>();
		String sql="select * from Alien where age = ?";
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1,age);
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Alien al=new Alien();
				al.setAge(rs.getInt(1));
				al.setName(rs.getString(2));
				al.setNickname(rs.getString(3));
				aliens.add(al);
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return aliens;
}

	public void createAlien(Alien al) {
	System.out.println(al);
	String sql="insert into alien values(?,?,?)";
	try {
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,al.getAge());
		st.setString(2, al.getName());
		st.setString(3, al.getNickname());
		int rs=st.executeUpdate(sql);
		System.out.println("sql-state....."+rs);
	}catch(SQLException ex) {
		System.out.println(ex);
	}
	
	// TODO Auto-generated method stub
	
}

}
