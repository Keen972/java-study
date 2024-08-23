package Test;

// 다중 반복문을 모두 강제 종료하기 위해서 이름붙는 반복문을 응용한 메뉴선택 계산예제

import java.util.Scanner;

public class BreakTest02 {

	public static void main(String[] args) {
		int menu = 0;
		int num = 0;

		Scanner scan = new Scanner(System.in);
		
		exit_for:
		while(true) {//무한루프문
			System.out.println("1-물냉면");
			System.out.println("2-비빔냉면");
			System.out.println("3-삼겹살");
			System.out.print("4-원하는 메뉴 (1~3)를 선택하세요.(종료0)");
			
			String resultMenu = scan.nextLine(); //메뉴를 문자열로 입력받는다
			menu = Integer.parseInt(resultMenu);//입력받은 메뉴번호 문자열을 정수숫자로 변경해서 저장
			
			if(menu==0) {
				System.out.println("메뉴 선택을 종료 합니다");
				break; //무한루프 while문 종료
				
			}else if (!(menu>=1 && menu<=3)) {
				System.out.println("메뉴를 잘못 선택했습니다(종료는 0");
				continue;//아래문장을 실행하지 않고 반복문을 처음으로 돌아가서 다음 반복 계속
			}
			
			System.out.println("\n====================>");
			for(;;) {//for 반복문 무한 루프문
				System.out.print("메뉴 계산할 값을 입력(계산 종료는  : 0, 전체종료 :99)>>");
				num = Integer.parseInt(scan.nextLine());
				
				if(num==0) {
					break; //무한루프 for 반복문 종료
				}
				if(num==99) {
					break exit_for; //전체 종료 =>for,while반복문 모두 종료 하고 빠져 나간다
				}
				switch(menu) {
				case 1 : System.out.println("물냉면 = " + num + "원");
				break;
				case 2 : System.out.println("비빔냉면 = " + num + "원");
				break;
				case 3 : System.out.println("삼겹살 = " + num + "원");
				break;
				}
			}//for
			
		}//while
			
			
			




	}

}
