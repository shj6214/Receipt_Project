package Receipt;

import java.util.ArrayList;

public class PrintOrder {
	int totalPrice = 0; 
	
	
	public void printOrder(ArrayList<OrderListArray> orderList) {
		System.out.println("\t     [영수증] ");
		System.out.println("나무카페(역삼점) / 123-45-67890 / 전상열");
		System.out.println("서울특별시 강남구 테헤란로 20길 20, 4층");
		System.out.println("02-6049-2611 / 20190430-01-0012");
		System.out.println("2019-04-30 0:31:21");
		System.out.println("--------------------------------------");
		System.out.printf("%s \t\t %s \t %s \t %s \t\n","상 품 명", "단가", "수량","금액" );		
		System.out.println("--------------------------------------");
		
		for(int idx=0; idx<orderList.size(); idx++) {
			
			totalPrice += orderList.get(idx).price*orderList.get(idx).count;
			System.out.printf("%s \t\t %d \t %d \t %d\n", orderList.get(idx).name, orderList.get(idx).price, orderList.get(idx).count, orderList.get(idx).price*orderList.get(idx).count);
		
		}
		System.out.println("--------------------------------------");
		System.out.printf("%s \t\t\t %d \n", "합 계 금 액", totalPrice);
		System.out.println("--------------------------------------");		
		System.out.printf("%26s", "*** 신용승인정보(고객용)[1] ***");
	}
}
