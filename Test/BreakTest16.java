package Test;

/**
 * 부모클래스 생성자가 오버로딩이 된경우 기본생성자 묵시적 제공을 하지 않는다. 이럴때 자손에서 부모의 기본생성자를 호출할려면 에러가
 * 발생한다.
 */
class Mother16 {
	protected int a = 100;
	protected int b = 200;

//	public Mother16() {
//
//	}

	public Mother16(int a, int b) {
		this.a = a;
		this.b = b;
	} // 전달인자 개수가 다른 생성자 오버로딩
}

class Son16 extends Mother16 {
	protected int c = 30;

//	public Son16() {
////		super(); // 가 생략 되었기 때문에 부모클래스 기본생성자를 호출할려다가 컴파일 에러가 발생한다.	
//		System.out.println("자손의 Son15() 기본생성자 호출");
//	}

	public Son16(int a, int b, int c) {
		super(a, b);
		this.c = c;
	}

	public void print() {
		System.out.println("a=" + a + ", b=" + b + ", c=" + c);
	}

}

public class BreakTest16 {

	public static void main(String[] args) {
		Son16 s16 = new Son16(1000, 2000, 3000);
		s16.print();
	}

}
