package Test;

/**
 * 클래스 상속 문법 특징 
 * 1. class 자손클래스 extends 부모클래스 {} 로 상속받는다. 
 * 2. 클래스 상속은 하나의 부모로 부터 단일
 * 상속만 가능하다. 
 * 3. 명시적인 상속을 받지 않으면 자바의 모든 클래스는 묵시적으로 자바 최상위 부모클래스 Object으로 부터 상속
 * 받는다.
 */

class Parent09 // extends Object가 생략됨
{
	public void p09() {
		System.out.println("부모클래스 메서드 p09()");
	}
} // 부모클래스 Parent09

class Child09 extends Parent09 {

	public void c09() {
		System.out.println("자손클래스 메서드 c09()");
//		p09();
	}
} // 자손클래스 Child09

public class BreakTest10 {

	public static void main(String[] args) {
		Child09 ch = new Child09();
		ch.p09(); // 부모클래스로 부터 상속받아서 호출
		ch.c09(); // 자손클래스에서 정의된 메서드 호출
		System.out.println("\n==============");
		Parent09 p = new Parent09();
		p.p09();
//		p.c09(); // 부모입장에서 자손에서 정의한 메서드 호출이 불가능하다.
	}

}
