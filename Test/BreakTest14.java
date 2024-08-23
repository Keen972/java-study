package Test;

/**
 * 부모클래스에서 정의한 멤버변수명과 자손클래스에서 정의한 멤버변수명이 동일한 경우 부모로 부터 상속받은 멤버 변수명에 접근할 때는
 * super.멤버변수명으로 접근한다.
 */
class Father13 { // extends Object가 생략
	protected int a = 10;
	protected int b = 20;
	protected int c = 40;

} // 부모클래스 Father13

class Child13 extends Father13 {
	protected int a = 40;
	protected int b = 50;
	protected int c = 30;

	public void pr01() {
		System.out.println("a=" + this.a + ", b=" + b + ", c=" + c); // 자신의 변수 값들 출력
	}

	public void pr02() {
		System.out.println("a=" + super.a + ", b=" + super.b + ", c=" + super.c); // 부모 변수 값들 출력
	}

} // 자손클래스 Child13

public class BreakTest14 {

	public static void main(String[] args) {
		Child13 ch = new Child13();
		ch.pr01();
		ch.pr02();
	}

}
