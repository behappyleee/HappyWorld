package JavaPJ_leech.domain;

import java.util.ArrayList;

import java.util.HashMap;

// DTO(Data Transfer Object)  ==> 데이터들이 드나드는 통로
//구매.. .환불 .... 등 domain 패키지에서 만들어서 구현 
public class Shoes {   //설계도
	public static ArrayList <Shoes> shoes = new ArrayList <Shoes> (); //신발정보 담음
	public static ArrayList <Cart>  cart  = new ArrayList <Cart> (); //고객이 장바구니에서 주문한것은 장바구니에 담음  
	public static ArrayList <Shoes> order = new ArrayList <Shoes> (); //고객이 주문을 한 정보를 담음
	
	public static int sum = 0;   //결산금액 총 합
	
	//멤버변수 
	private String shoesBrand; //신발브랜드
	private int shoesSize;  //신발사이즈
	private int shoesPrice;    //신발가격
	private int shoesCount;    //신발수량 
	private int shoesCode;
	
	//생성자
	public Shoes() { }
	
	public Shoes (int shoesCode , String shoesBrand, int shoesSize ,int  shoesPrice  , int shoesCount) {
		this.shoesCode=shoesCode;
		this.shoesBrand=shoesBrand;
		this.shoesSize=shoesSize;
		this.shoesPrice=shoesPrice;
		this.shoesCount=shoesCount;
		}
	
	public int getShoesCode() {
		return shoesCode;
	}

	public void setShoesCode(int shoesCode) {
		this.shoesCode = shoesCode;
	}

	public String getShoesBrand() {
		return shoesBrand;
	}

	public void setShoesBrand(String shoesBrand) {
		this.shoesBrand = shoesBrand;
	}

	public int getShoesSize() {
		return shoesSize;
	}

	public void setShoesSize(int shoesSize) {
		this.shoesSize = shoesSize;
	}

	public int getShoesPrice() {
		return shoesPrice;
	}

	public void setShoesPrice(int shoesPrice) {
		this.shoesPrice = shoesPrice;
	}

	public int getShoesCount() {
		return shoesCount;
	}

	public void setShoesCount(int shoesCount) {
		this.shoesCount = shoesCount;
	}
	
	@Override
	public String toString() {
		return shoesCode + "      " + shoesBrand + "      " + shoesSize +  "        "   + shoesPrice +  "       " +  shoesCount ;
	}
		
	
	
	
}
