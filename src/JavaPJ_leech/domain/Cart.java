package JavaPJ_leech.domain;
import java.util.ArrayList;


//장바구니 ==> 고객이 장바구니에 보관한 정보담은 클래스
public class Cart extends Shoes{
	
	private int cartShoesCode;
	private String cartShoesBrand;
	private int cartShoesSize;
	private int cartShoesPrice;
	private int cartShoesCount;
	
	public Cart() {}

	
	public Cart(int cartShoesCode ,String cartShoesBrand, int cartShoesSize, int cartShoesPrice, int cartShoesCount) {
		this.cartShoesBrand=cartShoesBrand;
		this.cartShoesCode=cartShoesCode;
		this.cartShoesSize=cartShoesSize;
		this.cartShoesPrice=cartShoesPrice;
		this.cartShoesCount=cartShoesCount;
	}	
	
	
	
	public int getCartShoesCode() {
		return cartShoesCode;
	}

	public void setCartShoesCode(int cartShoesCode) {
		this.cartShoesCode = cartShoesCode;
	}


	public String getCartShoesBrand() {
		return cartShoesBrand;
	}


	public void setCartShoesBrand(String cartShoesBrand) {
		this.cartShoesBrand = cartShoesBrand;
	}


	public int getCartShoesSize() {
		return cartShoesSize;
	}


	public void setCartShoesSize(int cartShoesSize) {
		this.cartShoesSize = cartShoesSize;
	}


	public int getCartShoesPrice() {
		return cartShoesPrice;
	}


	public void setCartShoesPrice(int cartShoesPrice) {
		this.cartShoesPrice = cartShoesPrice;
	}


	public int getCartShoesCount() {
		return cartShoesCount;
	}


	public void setCartShoesCount(int cartShoesCount) {
		this.cartShoesCount = cartShoesCount;
	}

	public String toString () {
		return cartShoesCode +  "       " +  cartShoesBrand +  "        " +cartShoesSize +"        "+  cartShoesPrice +"       " + cartShoesCount;
	}
	
	
}
