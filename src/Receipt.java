package Receipt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner; // java.util 패키지 밑에 Scanner 클래스를 사용하겠다. 

public class Receipt { // 클래스 명 
	public static void main(String[] args) { 
		
			ArrayList<OrderListArray> orderList = new ArrayList<OrderListArray>(); // 가변 길이 ArrayList 선언 
			InputOrder inputOrd = new InputOrder(); 
			PrintOrder printOrd = new PrintOrder(); 
			ListOrder listOrd = new ListOrder(); 
			
			while(true) {
				OrderListArray item = new OrderListArray(0,null,0,0,0);	// OrderListArray 클래스 변수
				listOrd.ListOrder(inputOrd,item);
			    
				orderList.add(item); // arrayList에 item 객체 요소 추가
			    
				inputOrd.inputADD(); // 추가 구매 유무
			    
			    if (inputOrd.addParchase == 1) { continue; } // 1 입력 시, while 문 상단으로 이동 
			    else if(inputOrd.addParchase == 2) { break;	} // 프로그램 종료
			    
			} printOrd.printOrder(orderList); // 영수증 출력
			
	
	}
}