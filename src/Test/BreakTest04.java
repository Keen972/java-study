package Test;
/*전달인자 개수가 다른 메소드가 오버로딩이 된 경우는 그 개수만큼 중복해서 메소드를 정의해야한다. 
 * 이런 불편함을 해결하기 위해서 자바 5버전에서 가변인자(Variavle Argument Lists)라는 문법이 추가 되었다.
 */

class Mt04 {
	void prn(int a) {
		System.out.println(a);
	}
	void prn(int a,int b) {
		System.out.println(a+ "\t" +b);
	}
	void prn(int a,int b,int c) {
		System.out.println(a+ "\t" +b + "\t" + c);
	}

}//Mt04 class

class Mt05{

	//가변인자 문법 적용=> int...(점은 무조건 3개) arr
	void prn(int...arr) {
		System.out.println("\n==============>가변인자 적용");
		for (int i = 0; i < arr.length/* 인자의 개수 */; i++) {
			System.out.println(arr[i] + "\t"); //가변 인자는 배열값으로 받는 것임
		}
		System.out.println("\n==============>향상된 확장 for문");
		//향상된 확장 for 문으로 가변인자 값 출력
		for(int k :arr) {
			System.out.println(k + "\t");
		}
	}

}//Mt05 class
public class BreakTest04 {
	public static void main(String[] args) {
		Mt04 mt04 = new Mt04();
		mt04.prn(10);
		mt04.prn(10,20);
		mt04.prn(10,20,30);
		
		Mt05 mt05 = new Mt05();
		mt05.prn(20,10);
		mt05.prn(20);
	}
}


