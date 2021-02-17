package JavaPJ_leech.view;

import JavaPJ_leech.domain.*;
import JavaPJ_leech.service.*;
import java.util.Scanner;

//ver1 관리자고, 고객1명,  ver2 관리자,고객 여러명  고객정보/출력정보 ==> 파일로 처리
//menuImpl과 연결하여 사용하기 
public class Console {
	public static void main(String[] args) {
		
		MenuImpl menu = new MenuImpl();
		Scanner input = new Scanner(System.in);
		
		
		do {
			System.out.println("=======================================");
			System.out.println("  1.로그인                  2.종료");
			System.out.println("=======================================");
			System.out.print("메뉴 번호를 입력하세요 : ");
			int key=input.nextInt();
			switch(key) {
			case 1 : menu.loginMenu();
				break;
			case 2 : System.out.println("종료 되었습니다.");
				break;
			}
			
			}	
			while(false);
				
				
	}
}				

	
	


	

	
							
							
			
			
			
	

