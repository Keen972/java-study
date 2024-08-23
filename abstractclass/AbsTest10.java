package abstractclass;

/**
 * - abstract class 키워드로 추상클래스를 정의한다 
 * - 추상 클래스는 new keyword 로 객체 생성을 할 수 없다 
 * - 일반 클래스에는 추상 메서드가 올수 없다. 추상메서드는 abstract 키워드로 정의하고 {}가 없고 실행문장이 없다. 호출 불가하다.
 */

abstract class AbsClass01 { // 추상클래스 정의
	abstract void pr(); // pr 추상메서드 정의
}

class AbsClass02 { // 일반 클래스 정의
//	abstract void print(); // 일반 클래스에서는 추상메서드가 오지 못함
}

public class AbsTest10 {

	public static void main(String[] args) {
//		AbsClass01 abs = new AbsClass01();
	}

}
