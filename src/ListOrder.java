package Receipt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ListOrder {
	
	
	public void ListOrder(InputOrder inputOrd, OrderListArray item) {
				  
		try { // JDBC - Mysql 연동 수행 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/goodslist","root" , "123456");
		    
		    // 새롭게 만든 accountBook 테이블을 mysql에서 생성하고,  PreparedStatement 문을 통해 mysql 문에 전달 수행 
		    String sql = "insert into accountbook(name, price, count) values(?,?,?)";
		     
		    item.no = inputOrd.InputNo(); // 상품 번호 입력
		    PreparedStatement pstmt = conn.prepareStatement(sql); // 인자 부분만 받아들여 수행하기위해 활용 
		    Statement stmt = conn.createStatement(); // executeQuery() 나 executeUpdate()를 실행하는 시점에 파라미터로 SQL문을 전달
		    ResultSet rset = stmt.executeQuery("SELECT * FROM goods WHERE no=" + item.no);
		  
		    if (rset.next()) { // 레코드 유무 확인     
		    	item.name = rset.getString(2); // 2번째 필드 레코드 값을 item 객체 변수의 name 변수에 저장  
		    	item.price = rset.getInt(3);  // 3번째 필드 레코드 값을 item 객체 변수의 price 변수에 저장 
		    } else { System.out.println("해당하는 상품이 없습니다."); }
		    
		    pstmt.setString(1, item.name); // 매개변수로 받은 name필드 검색 결과를 setString을 통해 값 ? 첫번째 값에 삽입 
		    pstmt.setInt(2, item.price); // 매개변수로 받은 name필드 검색 결과를 setString을 통해 값 ? 두번째 값에 삽입 
		    pstmt.setInt(3, item.count); // 매개변수로 받은 name필드 검색 결과를 setString을 통해 값 ? 세번째 값에 삽입 
		    
		    // insert문 수행을 하게되고, phpmyAdmin에서 생성한 accountbook 테이블 확인 시 테이블에 레코드 삽입 확인 가능 
		    pstmt.executeUpdate(); 
		   
		    // 불필요한 메모리 낭비 방지를 위해 close()로 닫아준다. 
		    rset.close(); 
		    stmt.close(); 
		    pstmt.close();
		    conn.close();
		    
		} catch(Exception e) { e.printStackTrace(); }
	    item.count = inputOrd.inputCount(); // 구매 개수 	   
	    item.total = item.price * item.count; // 구매 개수 * 가격 처리 
	  
	}
}
