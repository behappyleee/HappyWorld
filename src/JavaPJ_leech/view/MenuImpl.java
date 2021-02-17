package JavaPJ_leech.view;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import JavaPJ_leech.domain.*;
import JavaPJ_leech.service.*;


public class MenuImpl implements Menu, Code {
	
	public static int CODE; //상수를 이용하여 switch case문을 구성함  
	HashMap <String , String> log = new HashMap<> (); //ID와 PWD를 답는 HashMap 
	Scanner input = new Scanner(System.in);
	String ID ;
	String PWD ;
	int key;
	HostImpl host;
	GuestImpl guest;
	
	public MenuImpl() {}
	
	@Override //login 메뉴 구현하기 
	public void loginMenu()  {
		System.out.println("================LOG IN=================");
		System.out.println("1.고객    2.관리자    3.회원가입     4.종료");
		System.out.println("=======================================");
		System.out.print("메뉴 번호를 입력하세요: ");
		key=input.nextInt();
		//SHOP_LOGIN =999;   
		if(key==1) {
			System.out.print("고객ID: ");
			ID=input.next();
			System.out.print("고객PWD: ");
			PWD=input.next();
			if( log.containsKey(ID) && log.containsValue(PWD) ) { //회원가입때 가입한 hash맵에 로그인 정보가 담긴걸로 이용
				System.out.println("로그인 되었습니다.");
				guestMenu();
			} else if ( log.containsKey(ID) && !log.containsValue(PWD)){
				System.out.println("비밀번호가 틀렸습니다.");
			} else if (!log.containsKey(ID) && log.containsValue(PWD)) {
				System.out.println("아이디가 틀렸습니다.");
			} else {
				System.out.println("ID와 PWD를 확인해주세요.");
			}
		} else if(key==2) {
			System.out.print("관리자ID: ");
			ID=input.next();
			System.out.print("관리자PWD: ");
			PWD=input.next();
			if(ID.equals(Host.ID) && PWD.equals(Host.PASSWORD)) {
				System.out.println("로그인 되었습니다.");
				hostMenu();
			} else if ( ID.equals(Host.ID) && !PWD.equals(Host.PASSWORD) ) {
				System.out.println("비밀번호가 틀렸습니다.");
			} else if (!ID.equals(Host.ID) && PWD.equals(Host.PASSWORD) ) {
				System.out.println("아이디가 틀렸습니다.");
			} else {
				System.out.println("ID와 PW를 확인해 주세요.");
			}
			
		} else if(key==3) {
			System.out.println("====================================");
			System.out.println("===============회원가입===============");
			try {
			System.out.print("ID: ");
			String ID = input.next();
			System.out.print("PWD: ");
			String PWD = input.next();
			log.put(ID, PWD);  //ID와 비밀번호 LOG에 HashMap에 담기
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("=============회원가입 완료=============");
			} 
			
		loginMenu();  //틀렸을시 다시 login 메뉴로 되돌아가게해줌
			
}
	

	
	@Override //SHOES_LIST = 111; HOST_MENU = 100; 
	public void hostMenu() {
		System.out.println("===============관리자 메뉴=================");
		System.out.println("1.재고관리        2.주문관리       3.로그아웃 ");
		System.out.println("========================================");
		System.out.print("원하시는 번호를 선택하여 주십시오: [이전:0] ");
			int key = input.nextInt();	
			
			try {
				
			switch(key) {
			case 1 : CODE = HOST_STOCK_MENU; //상수 HOST_STOCK_MENU 110
				break;
			case 2 : CODE = HOST_ORDER_MENU; //상수 HOST_ORDER_MENU 120
				break;
			case 3 : loginMenu();	
				break;
			case 0 : loginMenu();
				break;
			}
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}
			
			switch(CODE) {
				
			case HOST_STOCK_MENU : hostStockMenu();
				break;
			case HOST_ORDER_MENU : hostOrderMenu();
				break;
			}
			
			
			
	}			
			
		
	@Override   //관리자의 재고 관리 메뉴를 보여줌 
	public void hostStockMenu() {
		System.out.println("===============재고관리 메뉴================");
		System.out.println("1.목록    2.추가    3.수정    4.삭제    5.이전");
		System.out.println("========================================");
		System.out.print("메뉴 번호를 입력하세요: ");
		int key = input.nextInt(); 
			try {
			switch(key) {
			case 1 : CODE=HOST_SHOES_LIST;
				break;
			case 2 : CODE=HOST_SHOES_ADD;
				break;
			case 3 : CODE=HOST_SHOES_UPDATE;
				break;
			case 4 : CODE=HOST_SHOES_DEL;
				break;
			case 5 : CODE=HOST_MENU;	
			}
			} catch(InputMismatchException e) {
				System.out.println(e.getMessage());
			}
			switch(CODE) {
			
			case HOST_SHOES_LIST : host.getInstance().shoeslist();
				break;
			case HOST_SHOES_ADD : host.getInstance().shoesAdd();
				break;
			case  HOST_SHOES_UPDATE : host.getInstance().shoesUpdate();
				break;
			case HOST_SHOES_DEL : host.getInstance().shoesDel();	
				break;
			case HOST_MENU : hostMenu();
				break;
			}
			
}
		
	
	@Override  //Host가 주문확인 메뉴규현 메소드
	public void hostOrderMenu() {
		System.out.println("===============고객주문메뉴===============");
		System.out.println("1.주문목록 2.결제승인 3.결제취소 4.결산 5.이전");
		System.out.println("=======================================");
		System.out.print("원하시는 번호를 입력하세요 : ");
		int key=input.nextInt();
			try {
			switch(key) {
			case 1 :  CODE=HOST_ORDER_LIST;    
				break;
			case 2 :  CODE=HOST_ORDER_CONFIRM; 	
				break;
			case 3 : CODE=HOST_ORDER_CANCEL;  
				break;
			case 4 : CODE=HOST_SALE_TOTAL;    
				break;
			case 5 : CODE= HOST_MENU;          
			}
			} catch(InputMismatchException e) {
				System.out.println(e.getMessage());
			}
			
			switch(CODE) {
			
			case HOST_ORDER_LIST : host.getInstance().orderList();
			
			case HOST_ORDER_CONFIRM : host.getInstance().orderConfirm();	
			
			case HOST_ORDER_CANCEL : host.getInstance().orderCancel();
			
			case HOST_SALE_TOTAL : host.getInstance().saleTotal();
			
			case HOST_MENU : hostMenu();
			}
			
	}
	
	@Override
	public void guestMenu() {
		System.out.println("==================고객메뉴=================");
		System.out.println("1.장바구니   2.구매     3.환불      4.로그아웃");
		System.out.println("=========================================");
		System.out.print("원하시는 번호를 입력하세요: ");
		int key=input.nextInt();
		
		switch(key) {
		
		case 1 : CODE = GUEST_CART_LIST;
			break;
		case 2 : CODE = GUEST_NOWBUY;
			break; 
		case 3 : CODE = GUEST_REFUND;
			break;
		case 4 : CODE = SHOP_LOGIN;
			break;
		}
		
		switch(CODE) {
		case GUEST_CART_LIST : guest.getInstance().cartList();
			break;
		case GUEST_NOWBUY : guest.getInstance().nowBuy();
			break;
		case GUEST_REFUND : guest.getInstance().refund();
			break;
		case SHOP_LOGIN : loginMenu();
			break;
		}
		
}		
		
	@Override  //guest카트메뉴
	public void guestCartMenu() {
		System.out.println("===============장바구니 목록=================");
		System.out.println("1.추가       2.삭제        3.구매      4.이전 ");
		System.out.println("=========================================");
		System.out.print("번호를 입력하세요: ");
		int key = input.nextInt();
		
			switch(key) {
			case 1 : CODE=GUEST_CART_ADD;          
				break;
			case 2 : CODE=GUEST_CART_DEL;       
				break;
			case 3 : CODE=GUEST_CART_BUY;          
				break;
			case 4 : CODE=GUEST_MENU;           
				break;
			}
		
			switch(CODE){
				case GUEST_CART_ADD : guest.getInstance().cartAdd();
					break;
				case GUEST_CART_DEL : guest.getInstance().cartDel(); 
					break;
				case GUEST_CART_BUY : guest.getInstance().cartBuy();
					break;
				case GUEST_MENU :   guestMenu();
					break;
				
			}
	
	}
	
}
