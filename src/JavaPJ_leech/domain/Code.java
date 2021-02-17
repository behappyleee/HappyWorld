package JavaPJ_leech.domain;
//인터페이스 - 상수와 추상메소드로 구성
public interface Code {
	
	//상수
	static final int SHOP_LOGIN =999; //로그인 코드는 카페에있음
	static final int SHOES_LIST = 111; //

	//관리자 
	static final int HOST_MENU = 100;   //관리자
	
	//관리자 - 재고관리
	static final int HOST_STOCK_MENU = 110;  //재고관리
	static final int HOST_SHOES_LIST  =111;  //신발목록
	static final int HOST_SHOES_ADD   =112;  //신발 추가
	static final int HOST_SHOES_UPDATE =113; //신발 수정
	static final int HOST_SHOES_DEL =114;  	//신발 삭제
	
	//관리자 - 주문관리
	static final int HOST_ORDER_MENU = 120;  //주문관리
	static final int HOST_ORDER_LIST = 121;  //주문목록
	
	static final int HOST_ORDER_CONFIRM =122;  //결제승인
	static final int HOST_ORDER_CANCEL =123;  //결제취소
	
	static final int HOST_SALE_TOTAL =130;  //결산
	
	//-------------------------------------------------------------
	
	// 고객
	static final int GUEST_MENU =200; //고객
	
	static final int GUEST_GOODS=210; //상품리스트
	
	static final int GUEST_CART_LIST = 220; //장바구니 목록
	static final int GUEST_CART_ADD = 221; 	//장바구니 추가
	static final int GUEST_CART_DEL = 222;	//장바구니 삭제
	static final int GUEST_CART_BUY = 223; //장바구니 구매
	
	//손님 - 바로구매
	
	static final int GUEST_NOWBUY =230; //바로구매
	
	//손님 - 환불
	static final int GUEST_REFUND = 240; //환불
	
	
}
