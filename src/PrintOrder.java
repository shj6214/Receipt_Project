package Receipt;

import java.util.ArrayList;

public class PrintOrder {
	int totalPrice = 0; 
	
	
	public void printOrder(ArrayList<OrderListArray> orderList) {
		System.out.println("\t     [������] ");
		System.out.println("����ī��(������) / 123-45-67890 / ����");
		System.out.println("����Ư���� ������ ������� 20�� 20, 4��");
		System.out.println("02-6049-2611 / 20190430-01-0012");
		System.out.println("2019-04-30 0:31:21");
		System.out.println("--------------------------------------");
		System.out.printf("%s \t\t %s \t %s \t %s \t\n","�� ǰ ��", "�ܰ�", "����","�ݾ�" );		
		System.out.println("--------------------------------------");
		
		for(int idx=0; idx<orderList.size(); idx++) {
			
			totalPrice += orderList.get(idx).price*orderList.get(idx).count;
			System.out.printf("%s \t\t %d \t %d \t %d\n", orderList.get(idx).name, orderList.get(idx).price, orderList.get(idx).count, orderList.get(idx).price*orderList.get(idx).count);
		
		}
		System.out.println("--------------------------------------");
		System.out.printf("%s \t\t\t %d \n", "�� �� �� ��", totalPrice);
		System.out.println("--------------------------------------");		
		System.out.printf("%26s", "*** �ſ��������(����)[1] ***");
	}
}
