package JavaPJ_leech.view;

public interface Menu {
	//상위 메뉴들 넣기  ...재량껏 하기
	
	
	public void loginMenu () throws Exception;  //로그인 메뉴
	public void hostMenu();	   //관리자메뉴
	public void hostStockMenu();  //관리자 재고관리 메뉴
	public void hostOrderMenu();  //관리자 주문관리 메뉴
	public void guestMenu();	  //고객 메뉴
	public void guestCartMenu();  //고객의 장바구니 메뉴

	
}
