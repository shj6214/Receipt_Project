package Receipt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ListOrder {
	
	
	public void ListOrder(InputOrder inputOrd, OrderListArray item) {
				  
		try { // JDBC - Mysql ���� ���� 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/goodslist","root" , "123456");
		    
		    // ���Ӱ� ���� accountBook ���̺��� mysql���� �����ϰ�,  PreparedStatement ���� ���� mysql ���� ���� ���� 
		    String sql = "insert into accountbook(name, price, count) values(?,?,?)";
		     
		    item.no = inputOrd.InputNo(); // ��ǰ ��ȣ �Է�
		    PreparedStatement pstmt = conn.prepareStatement(sql); // ���� �κи� �޾Ƶ鿩 �����ϱ����� Ȱ�� 
		    Statement stmt = conn.createStatement(); // executeQuery() �� executeUpdate()�� �����ϴ� ������ �Ķ���ͷ� SQL���� ����
		    ResultSet rset = stmt.executeQuery("SELECT * FROM goods WHERE no=" + item.no);
		  
		    if (rset.next()) { // ���ڵ� ���� Ȯ��     
		    	item.name = rset.getString(2); // 2��° �ʵ� ���ڵ� ���� item ��ü ������ name ������ ����  
		    	item.price = rset.getInt(3);  // 3��° �ʵ� ���ڵ� ���� item ��ü ������ price ������ ���� 
		    } else { System.out.println("�ش��ϴ� ��ǰ�� �����ϴ�."); }
		    
		    pstmt.setString(1, item.name); // �Ű������� ���� name�ʵ� �˻� ����� setString�� ���� �� ? ù��° ���� ���� 
		    pstmt.setInt(2, item.price); // �Ű������� ���� name�ʵ� �˻� ����� setString�� ���� �� ? �ι�° ���� ���� 
		    pstmt.setInt(3, item.count); // �Ű������� ���� name�ʵ� �˻� ����� setString�� ���� �� ? ����° ���� ���� 
		    
		    // insert�� ������ �ϰԵǰ�, phpmyAdmin���� ������ accountbook ���̺� Ȯ�� �� ���̺� ���ڵ� ���� Ȯ�� ���� 
		    pstmt.executeUpdate(); 
		   
		    // ���ʿ��� �޸� ���� ������ ���� close()�� �ݾ��ش�. 
		    rset.close(); 
		    stmt.close(); 
		    pstmt.close();
		    conn.close();
		    
		} catch(Exception e) { e.printStackTrace(); }
	    item.count = inputOrd.inputCount(); // ���� ���� 	   
	    item.total = item.price * item.count; // ���� ���� * ���� ó�� 
	  
	}
}
