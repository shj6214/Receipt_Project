package Receipt;

import java.util.Scanner;

public class InputOrder {
	
	Scanner sc = new Scanner(System.in);
	
	int addParchase= 0;
	
	public int InputNo() {
	    System.out.println("��ǰ ��ȣ�� �Է��ϼ��� " );
	    int inputNo = sc.nextInt();
	    return inputNo;
	}

	public int inputCount() {
		System.out.println("���� ���� " );
	    int count = sc.nextInt();	   
	     return count;
	}
	
	public void inputADD() {
	    System.out.print("1. �߰�����, 2. �������� : " );
	    addParchase = sc.nextInt();	 
	}
	
}
