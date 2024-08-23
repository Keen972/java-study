package Test;

public class BreakTest01 {

	public static void main(String[] args) {
		
		int i,j; //반복문 제어변수
		
		for(i=1;i<=5;i++) {
			for(j=1;j<=5;j++) {
				if(j%3==0) {
					break; //가장 가까운 맨 안쪽 반복문만 중단한다
				}
				System.out.print("j->" + j);
			}//inner for
			System.out.println("\n i->" + i);
		}//outer for
		System.out.println("\n=================================>");
		
		
		//바깥쪽 반복문과 안쪽 반복문 모두 중단
		break_for:
		for(int a = 0; a<=5;a++) {
			for(int b=1;b<=5;b++) {
				if(b%3==0) break break_for;
				System.out.print("b -> " + b);
			}
			System.out.println("/n a -> " + a);
		}
		System.out.println("\n=================================>");
	}

}
