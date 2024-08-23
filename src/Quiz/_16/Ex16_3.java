package Quiz._16;

/**
 * 16장.상속.PDF 강의교안의 21쪽 2번문제
 */
class Parent2 {
	protected int a, b, c;

	public Parent2() {
		System.out.println("Parent2 클래스의 디폴트 생성자 호출");
	}

	public Parent2(int a, int b, int c) {
		System.out.println("Parent2 클래스의 전달인자 3개짜리 생성자 호출");
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

class Child2 extends Parent2 {
	public Child2() {
		System.out.println("Child 클래스의 디폴트 생성자 호출");
	}

	public Child2(int a, int b, int c) {
		super(a, b, c);
		System.out.println("Child 클래스의 전달인자 3개짜리 생성자 호출");
	}
	
	public String print() {
		String strA = String.valueOf(this.a);
		String strB = String.valueOf(this.b);
		String strC = String.valueOf(this.c);
		return strA + strB + strC;
	}
}

public class Ex16_3 {

	public static void main(String[] args) {
		/**
		 * 문제) 메서드 리턴타입이 String 으로 된 print()메서드를 정의한 다음
		 * a,b,c 멤버변수 정수값을 문자열 변수 result에
		 * 저장한 다음 반환해서 출력하는 코드를 만들어 보자.
		 */
		Child2 three = new Child2(100,200,300);
		String result = three.print();
		System.out.println(result);

	}

}
