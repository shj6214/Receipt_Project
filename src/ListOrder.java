package Receipt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ListOrder {
	
	
	public void ListOrder(InputOrder inputOrd, OrderListArray item) {
		 // 가변 길이 ArrayList 선언
		
		//OrderListArray item = new OrderListArray(0,null,0,0,0);	// OrderListArray 클래스 변수 
		  
		try { // JDBC 객체 연결 Try - catch
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/goodslist","root" , "123456");
		    
		      
		    item.no = inputOrd.InputNo(); // 상품 번호 입력
		    Statement stmt = conn.createStatement(); 
		    ResultSet rset = stmt.executeQuery("SELECT * FROM goods WHERE no=" + item.no);
		  
		    if (rset.next()) {    
		    	item.name = rset.getString(2);
		    	item.price = rset.getInt(3);		    	
		    } else { System.out.println("해당하는 상품이 없습니다."); }
		    
		    rset.close();
		    stmt.close(); 
		    conn.close(); 
		} catch(Exception e) { e.printStackTrace(); }
	    item.count = inputOrd.inputCount(); // 구매 개수 	   
	    item.total = item.price * item.count; // 구매 개수 * 가격 처리 
	  
	}
}
