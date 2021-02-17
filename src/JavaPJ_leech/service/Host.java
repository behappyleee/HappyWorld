package JavaPJ_leech.service;

import java.util.ArrayList;

import JavaPJ_leech.domain.Shoes;

public interface Host {

	public static final String ID = "host";       //관리자 고유 ID생성 
	public static final String PASSWORD = "host"; //관리자 고유 pwd생성
	
	//관리자 - 재고관리
	public void shoeslist();  //책목록
	public void shoesAdd();  //책목록
	public void shoesDel();  //책 삭제
	public void shoesUpdate(); //책 수정
	
	//관리자 - 주문관리 
	public void orderList();      //주문목록
	public void orderConfirm();		//결제승인
	public void orderCancel();	//결제취소
	
	//관리자 - 결산 
	public void saleTotal();   //결산
	
	
}
