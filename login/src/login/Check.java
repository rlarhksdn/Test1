package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Check {
	
	 int login(String id,String pw) {
		//DB에 접속후 id,pw 가지고 확인해서
		//1~3까지 값을 return주면 된다.
String url = "jdbc:oracle:thin:@192.168.0.4:1521:xe";
		int flag = 0;
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection(url, "scott", "tiger");
			//System.out.println("DB 접속 성공");
			 stmt=con.prepareStatement( "select * from tbl_user where id=?");
			 stmt.setString(1, id);
	 rs=stmt.executeQuery();
	if(rs.next()) {//한행이 있다면 (즉,아이디가 있다면)
		String dbPw = rs.getString("pw");
		if(pw.equals(dbPw))
			flag=3;
		else
			flag=2;
	}else
			flag=1;
	if(flag==3)
		System.out.println("로그인 성공");
	else if(flag==2)
		System.out.println("로그인 실패 패스워드가 틀립니다.");
	else if(flag==1)
		System.out.println("로그인 실패 아이디가 틀립니다.");
		
			       		
		 }catch (Exception e) {
				System.out.println("예외발생");			
				e.printStackTrace();
		}finally {
			
			try{if(rs!=null)rs.close();}catch (SQLException e) {}
			try{if(stmt!=null)stmt.close();}catch (SQLException e) {}
			try{if(con!=null)con.close();}catch (SQLException e) {}			
			} 					
	 return flag;		 
	 }
	 void signUp(String id, String pw) {
		 String url = "jdbc:oracle:thin:@192.168.0.4:1521:xe";;
		 
			PreparedStatement stmt=null;
			Connection con=null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 con=DriverManager.getConnection(url, "scott", "tiger");
				//System.out.println("DB 접속 성공");
				 stmt=con.prepareStatement("INSERT INTO TBL_USER(ID,PW) VALUES(?,?)");
				 stmt.setString(1, id);
				 stmt.setString(2, pw);
				// System.out.println("sql이 잘만들어 졌나:"+sql);
				 stmt.executeUpdate();
		
	
			 }catch (Exception e) {
					System.out.println("예외발생");			
					e.printStackTrace();
			}finally {
				
				
				try{if(stmt!=null)stmt.close();}catch (SQLException e) {}
				try{if(con!=null)con.close();}catch (SQLException e) {}			
				} 					
			 
	 }
	 void del(String id, String pw) {
		 String url = "jdbc:oracle:thin:@192.168.0.4:1521:xe";;
		 
			PreparedStatement stmt=null;
			Connection con=null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 con=DriverManager.getConnection(url, "scott", "tiger");
				System.out.println("DB 접속 성공");
				 stmt=con.prepareStatement("DELETE FROM TBL_USER WHERE ID=? AND  PW=?");
				 stmt.setString(1, id);
				 stmt.setString(2, pw);
				// System.out.println("sql이 잘만들어 졌나:"+sql);
				 stmt.executeUpdate();
		
	
			 }catch (Exception e) {
					System.out.println("예외발생");			
					e.printStackTrace();
			}finally {
				
				
				try{if(stmt!=null)stmt.close();}catch (Exception e) {}
				try{if(con!=null)con.close();}catch (Exception e) {}			
				} 					
						 		 		 		 		 
}	
	 void find1(String pw) {
		 String url = "jdbc:oracle:thin:@192.168.0.4:1521:xe";;
		 
		 ResultSet rs=null;
		 
			PreparedStatement stmt=null;
			Connection con=null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 con=DriverManager.getConnection(url, "scott", "tiger");
				//System.out.println("DB 접속 성공");		
				 
				 stmt=con.prepareStatement("SELECT ID FROM TBL_USER WHERE PW=?");
				 stmt.setString(1, pw);				 					
				 rs=stmt.executeQuery();				  					 				 			 
				 if(rs.next()) {	
					 
				 System.out.println(pw+"의 ID는"+rs.getString("ID")+ "입니다.");
				 }
				 
			
			 }catch (Exception e) {
					System.out.println("예외발생");			
					e.printStackTrace();
			}finally {
								
				try{if(stmt!=null)stmt.close();}catch (Exception e) {}
				try{if(con!=null)con.close();}catch (Exception e) {}}
			}
	 
	void find(String id) {
		 String url = "jdbc:oracle:thin:@192.168.0.4:1521:xe";;
		 
		 ResultSet rs=null;
		 
			PreparedStatement stmt=null;
			Connection con=null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 con=DriverManager.getConnection(url, "scott", "tiger");
						
				 
				 stmt=con.prepareStatement("SELECT PW FROM TBL_USER WHERE ID=?");
				 stmt.setString(1, id);				 					
				 rs=stmt.executeQuery();				  					 				 			 
				 if(rs.next()) {	
					 
				 System.out.println(id+"의 비밀번호는"+rs.getString("pw")+ "입니다.");
				 }
				 
			
			 }catch (Exception e) {
					System.out.println("예외발생");			
					e.printStackTrace();
			}finally {
								
				try{if(stmt!=null)stmt.close();}catch (Exception e) {}
				try{if(con!=null)con.close();}catch (Exception e) {}			
			} 					
	 }	
	
}


