package Receipt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner; // java.util ��Ű�� �ؿ� Scanner Ŭ������ ����ϰڴ�. 

public class Receipt { // Ŭ���� �� 
	public static void main(String[] args) { 
		
			ArrayList<OrderListArray> orderList = new ArrayList<OrderListArray>(); // ���� ���� ArrayList ���� 
			InputOrder inputOrd = new InputOrder(); 
			PrintOrder printOrd = new PrintOrder(); 
			ListOrder listOrd = new ListOrder(); 
			
			while(true) {
				OrderListArray item = new OrderListArray(0,null,0,0,0);	// OrderListArray Ŭ���� ����
				listOrd.ListOrder(inputOrd,item);
			    
				orderList.add(item); // arrayList�� item ��ü ��� �߰�
			    
				inputOrd.inputADD(); // �߰� ���� ����
			    
			    if (inputOrd.addParchase == 1) { continue; } // 1 �Է� ��, while �� ������� �̵� 
			    else if(inputOrd.addParchase == 2) { break;	} // ���α׷� ����
			    
			} printOrd.printOrder(orderList); // ������ ���
			
	
	}
}