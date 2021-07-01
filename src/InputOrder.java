package Receipt;

import java.util.Scanner;

public class InputOrder {
	
	Scanner sc = new Scanner(System.in);
	
	int addParchase= 0;
	
	public int InputNo() {
	    System.out.println("상품 번호를 입력하세요 " );
	    int inputNo = sc.nextInt();
	    return inputNo;
	}

	public int inputCount() {
		System.out.println("구매 갯수 " );
	    int count = sc.nextInt();	   
	     return count;
	}
	
	public void inputADD() {
	    System.out.print("1. 추가구매, 2. 구매종료 : " );
	    addParchase = sc.nextInt();	 
	}
	
}
