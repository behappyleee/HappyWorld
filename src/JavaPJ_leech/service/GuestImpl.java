package JavaPJ_leech.service;

import JavaPJ_leech.domain.*;
import JavaPJ_leech.view.*;
import java.util.ArrayList;
import java.util.Scanner;


//guest 인터페이스 구현 
public class GuestImpl extends Shoes implements Guest{
	
	MenuImpl menu = new MenuImpl();
	Scanner input = new Scanner(System.in);
	
	//싱글톤 적용
	private GuestImpl() {}
	
	private static Guest guest = new GuestImpl();
		
	public static Guest getInstance() {   
		if(guest==null) {
			guest = new GuestImpl();
		} else if (guest != null) {
		}
		return guest; //GuestImpl의 주소값을 리턴 시켜줌
	}
	
	@Override  //장바구니 목록 보여줌 
	public void cartList() {
		System.out.println("==========장바구니 목록==========");
		System.out.println("번호  브랜드   사이즈    가격    수량");
		for(int i =0; i<cart.size(); i++) {
			System.out.println(cart.get(i));
		}
		menu.guestCartMenu();
	}
					
			
	@Override   //장바군에 담기 //Shoes a =shoes.get(1);
	public void cartAdd() {
		System.out.println("==============신발목록=============");
		System.out.println("번호  브랜드   사이즈    가격    수량");
			for(int i=0; i<shoes.size(); i++) {    //신발 목록을 보여줌 
				System.out.println(shoes.get(i));
				} 
		System.out.print("추가 원하시는 번호를 입력해주세요: ");   //추가 원하는 신발코드입력
		int key = input.nextInt();  //장바구니에 추가 기능  구현
		System.out.print("수량도 입력해 주세요: ");
		int key1 =input.nextInt();
		for(int i =0; i<shoes.size(); i++){   // shoes arraylist 호출
			if(key==shoes.get(i).getShoesCode()) {
			Cart car =new Cart(shoes.get(i).getShoesCode(), shoes.get(i).getShoesBrand(), shoes.get(i).getShoesSize() , shoes.get(i).getShoesPrice() , key1);
			shoes.get(i).setShoesCount(shoes.get(i).getShoesCount()-key1); //해당 ArrayList에서 카트에 추가한 수만큼 뺴줌
			cart.add(car);
				System.out.println("장바구니에 추가 되었습니다.");
				break;
			}
			
		}
		menu.guestMenu();	
	}		
		
		
	@Override  //cart에 담는 기능 구현 guest와 host 신발정보가 일치해야함 
	public void cartDel() {
		for(int i =0; i<cart.size(); i++) {
			System.out.println(cart.get(i));
		}
		System.out.print("번호 입력해주세요: ");
		int key = input.nextInt();		
		for(int i=0; i<cart.size(); i++) {
			if(key==cart.get(i).getCartShoesCode()) {
				cart.remove(i);
				System.out.println("삭제 되었습니다.");
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
		}
		menu.guestCartMenu();
}

	@Override    //구매원하는 번호 넣어서 넘기기
	public void cartBuy() {
		for(int i=0; i<cart.size(); i++) {
			System.out.println(cart.get(i));
		} 
		System.out.print("구매 원하시는 번호를 선택하시오: ");
		int key = input.nextInt();
		System.out.print("수량도 입력해주세요: ");
		int shoesNum = input.nextInt();
		for(int i=0; i<cart.size(); i++) {
			if(key==cart.get(i).getCartShoesCode()) {
				Shoes ab = new Shoes (cart.get(i).getCartShoesCode() , cart.get(i).getCartShoesBrand() , cart.get(i).getCartShoesSize(), cart.get(i).getCartShoesPrice() , shoesNum);
				order.add(ab); 						  //고객이 주문한것을 ORDER 어레이리스트에 담아줌 
				System.out.println("주문 되었습니다.");  //cart에서 구매한것을  order에 담아줌
				cart.get(i).setCartShoesCount(cart.get(i).getCartShoesCount()-shoesNum);		
			}	
		}
		
		menu.guestCartMenu();
	}

	
	
	@Override  //카트 통하지말고 직접 구매 기능구현
	public void nowBuy() {
		for(int i =0; i<shoes.size(); i++) {
			System.out.println(shoes.get(i));
		}
		System.out.print("구매 원하시는 번호를 입력하시오: ");
		int key = input.nextInt();
		System.out.print("수량도 입력해주세요: ");
		int shoesNum = input.nextInt();
		for(int i=0; i<shoes.size(); i++) {  //고치기 shoes arraylist를 shoes에 선언할시 정보를 담지를 못함 
			if(key==shoes.get(i).getShoesCode()) {
				shoes.get(i);  
				System.out.println("구매 되었습니다.");
				Shoes order1 = new Shoes (shoes.get(i).getShoesCode(), shoes.get(i).getShoesBrand(), shoes.get(i).getShoesSize() , shoes.get(i).getShoesPrice() , shoesNum);
				order.add(order1);   //새로 만든 order ArrayList에 주문한 항목 담기
				shoes.get(i).setShoesCount(shoes.get(i).getShoesCount()-shoesNum); //구매한 만큼 수량을 목록에서 뺴주기
		}
		}
		menu.guestCartMenu();
		
	}

	@Override
	public void refund() {
		for(int i =0; i<order.size(); i++) {
			System.out.println(order.get(i));
		}
		System.out.print("환불 원하시는 상품을 선택하세요: ");
		int key = input.nextInt();
		System.out.print("수량도 입력해 주세요: ");
		int shoesNum = input.nextInt();
		for(int i=0; i<order.size(); i++) {
			if(key==order.get(i).getShoesCode()) {
				order.remove(i);    //환불한 신발 목록에서 지우기
				Shoes.sum -= (order.get(i).getShoesPrice() * shoesNum);
					/*for(int j=0; j<shoes.size(); j++) {
						if(order.get(i).getShoesCode() == shoes.get(j).getShoesCode()) {  //환불받은 신발의 수만큼 원래 재고의 신발에 더해주기 
								shoes.get(j).setShoesCount(shoes.get(j).getShoesCount() + shoesNum);
						}*/
					}
				System.out.println("환불 완료 되었습니다.");
			}	
			menu.guestMenu();
			}
	
			
		}

	
		

	
	

