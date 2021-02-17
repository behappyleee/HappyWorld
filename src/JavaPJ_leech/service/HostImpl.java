package JavaPJ_leech.service;
import java.util.ArrayList;

import java.util.Scanner;
import JavaPJ_leech.domain.*;
import JavaPJ_leech.view.*;

//host 인터페이스 구현
public class HostImpl extends Shoes implements Host{
		
		GuestImpl guest;
		MenuImpl menu = new MenuImpl();
		Scanner input = new Scanner(System.in);
		int num =(int)(Math.random()*1000)+1000; //신발번호 RANDOM으로 만들어줌
		
		//싱글톤
		private HostImpl() {}
			
		private static Host host = new HostImpl();
		
		public static  Host getInstance() {   // ==>직접 메소드생성 public으로 getter생성
			if(host == null) { 
				host = new HostImpl();
			} else if (host != null) {
			} 
			return host; //주소값 리턴
		}
		
		@Override  //관리자 신발목록
		public void shoeslist() {
			System.out.println("=================신발목록==================");
			System.out.println("번호     브랜드      사이즈       가격      수량");
				for(int i =0; i<shoes.size(); i++) {
					System.out.println(shoes.get(i));
				}
			System.out.println("=============================");
			menu.hostStockMenu();
		}			

		@Override  //host 신발추가
		public void shoesAdd() {
			System.out.println("=================신발등록================");
			super.setShoesCode((int)(Math.random()*1000)+1000); 
			System.out.print("브랜드: " ); 
			super.setShoesBrand(input.next());
			System.out.print("사이즈: "); 
			super.setShoesSize(input.nextInt());
			System.out.print("가격: ");   
			super.setShoesPrice(input.nextInt());
			System.out.print("수량: ");   
			super.setShoesCount(input.nextInt());
			Shoes sh = new Shoes(super.getShoesCode() , super.getShoesBrand(), super.getShoesSize() , super.getShoesPrice(), super.getShoesCount());
			shoes.add(sh);
			System.out.println("================================");
			System.out.println("=========추가 되었습니다===========");
			menu.hostStockMenu();
		}
		
		@Override   //관리자신발삭제  //삭제오류 여러개 등록시 밑에꺼 삭제시 같이 삭제되어버림 
		public void shoesDel() {
			System.out.println("=================신발목록=================");
			System.out.println("번호  브랜드   사이즈    가격    수량");
			for(int i =0; i<shoes.size(); i++) {
				System.out.println(shoes.get(i));
			}
			System.out.print("삭제 원하시는 번호를 입력하여 주세요: ");//여러개 등록 후 삭제시 원하는 번호가 삭제가 안됨 
			int key = input.nextInt();
			for(int i=0; i<shoes.size();i++ ) {
				if(key == shoes.get(i).getShoesCode()) { 
					shoes.remove(i);
					System.out.println("===========삭제 되었습니다.============");
				}
			}
			menu.hostMenu();
		}	
			
		@Override  //신발수정 메소드
		public void shoesUpdate() {
			System.out.println("==============신발수정==================");
			System.out.println("===========신발목록=============");
			System.out.println("번호    브랜드     사이즈      가격      수량");
			for(int i =0; i<shoes.size(); i++) {
				System.out.println(shoes.get(i));
			}
			System.out.print("신발번호를 입력해주세요: ");
			int key = input.nextInt();
			for(int i=0; i<shoes.size(); i++) {
				if(key==shoes.get(i).getShoesCode()) {
					shoes.remove(i);
					super.setShoesCode(num);    //신발번호 RANDOM으로 SETTING
					System.out.print("브랜드: "); 
					super.setShoesBrand(input.next());
					System.out.print("사이즈: "); 
					super.setShoesSize(input.nextInt());
					System.out.print("가격: "); 
					super.setShoesPrice(input.nextInt());
					System.out.print("수량: "); 
					super.setShoesCount(input.nextInt());
					Shoes sb = new Shoes(super.getShoesCode(), super.getShoesBrand(), super.getShoesSize() , super.getShoesPrice() , super.getShoesCount());
					shoes.add(i, sb); //set도 replace임 다시 확인해보기
					System.out.println("===============변경되었습니다.================");
					menu.hostMenu();
				}
			}
			input.close();
			menu.hostMenu();
			
}

		@Override   //구매목록
		public void orderList() {     //ORDER LIST가 보이지않음 
			System.out.println("==============주문목록=============");
			System.out.println("번호  브랜드   사이즈    가격    수량");
			for(int i=0; i<order.size(); i++) {  //FOR문 돌면서 신발목록 보여줌 
				System.out.println(order.get(i));  //주문 목록을 보여줌 
			}
			menu.hostMenu();
		}

		
		@Override
		public void orderConfirm() {  //2번이 비어있음 
			System.out.println("===============결제승인=================");
			for(int i=0; i<order.size(); i++) {  //FOR문 돌면서 GUEST가 주문한 신발목록 보여줌 
				System.out.println(order.get(i));
			}
			System.out.print("결제승인 [Y/N]: ");
			String confirm = input.next();
			if(confirm.equals("Y")) {
				System.out.println("결제 승인이 되었습니다.");
			} else if(confirm.equals("Y")) {
				System.out.println("결제 승인이 거부되었습니다.");
			}
			System.out.println("======================================");
			menu.hostOrderMenu();
}
			
		@Override  //주문 취소 기능구현 (Host의 주문 취소)
		public void orderCancel() {
			System.out.println("==============결제취소================");
			for(int i=0; i<order.size(); i++) {
				order.get(i);
			}
			System.out.print("원하시는 번호를 입력해주세요: ");
			int key =input.nextInt();
				
			for(int i=0; i<order.size(); i++) {
				if(key==order.get(i).getShoesCode()) {
					order.remove(i);
					shoes.add(i, order.get(i));
					System.out.println("주문 취소 되었습니다.");
				}
			
			}
			
}
		
		@Override   //TOTAL PRICE   //Guest 가 주문 한 총 주문 금액 합산하여 totalprice print 출력
		public void saleTotal() {  //결산방법구현 - guest가 시킨 총 주문금액 
			System.out.println("===============총결산================");
			for(int i=0; i < order.size(); i++) {
				sum += (order.get(i).getShoesPrice() * order.get(i).getShoesCount() );
			}
			System.out.println("결산: " + sum +"원") ;  //order arraylist에 담긴 총 금액 반환
			menu.hostMenu();
			}
		
			
}

	

