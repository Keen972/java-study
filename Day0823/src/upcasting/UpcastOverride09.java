package upcasting;

/**
 * 업 캐스팅 이후 오버라이딩 한 메소드 호출에 관한 소스이다
 * 자손 타입이 부모타입으로 올라가는것 : 업케스팅
 */

class Parent09 {
	int x = 100;

	void method() {
		System.out.println("부모클래스에서 정의한 인스턴스 변수 x=" + x);
	}
}

class Son09 extends Parent09 {

	@Override
	void method() {
		System.out.println("오버라이딩한 메서드");
	}
}

public class UpcastOverride09 {
	public static void main(String[] args) {
		// 업케스팅
		Parent09 p = new Son09();

		/**
		 * 메서드가 오버라이딩 된 경우에 업캐스팅한 p가 
		 * 실제 호출되는 메소드는 p가 가리키고 있는 
		 * 객체타입에 의해서 호출되는 메서드가 결정된다
		 */
		p.method(); // 사용빈도가 높다. 증요하다.
	}
}
