package Test;

/**
 * 자손클래스에서 메서드가 오버라이딩 된 경우에서 부모클래스 메서드를 호출하려면 super.메소드를 사용한다.
 */

class Father12 {
	public void f12() {
		System.out.println("부모클래스 메서드 f12()");
	}
} // 부모클래스 Father12

class Child12 extends Father12 {
	@Override
	public void f12() {
		super.f12(); // 부모클래스 메서드 호출
		System.out.println("오버라이딩 한 메서드 f12()");
	}

	public void ch12() {
		System.out.println("자손에서 정의한 메서드 ch12()");

	}
} // 자손클래스 Child12

public class BreakTest13 {

	public static void main(String[] args) {
		Child12 ch12 = new Child12();
		ch12.f12(); // 오버라이딩 한 메서드 호출
		ch12.ch12(); // 자손클래스에서 정의한 메서드 호출
	}

}
