package JavaPJ_leech.service;
//기능명세서 작성
public interface Guest {
	public static final String ID = "guest";       //고객 고유 ID생성 
	public static final String PASSWORD = "guest"; //고객 고유 PWD생성
	
	// 손님 - 장바구니 
	public void cartList(); //장바구니 목록
	public void cartAdd(); 
	public void cartDel(); 
	public void cartBuy(); 
	
	
	//손님 - 바로구매
	public void nowBuy() ; //바로 구매
	
	
	//손님 - 환불
	public void refund();
	
	
	
}
