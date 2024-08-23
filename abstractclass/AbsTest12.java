package abstractclass;

/**
 * 중간에 MiddleClass 추상클래스를 끼워 놓은 
 * 다음 이를 상속받은 자손클래스에서 그 부모인 
 * AbsClass12에 있는 추상메서드를 오버라이딩을 한 예다.
 */
abstract class AbsClass12 {
	abstract void method01();

	void method02() {
		System.out.println("method02() 일반메서드");
	}
} // 첫번째 부모 AbsClass12 추상클래스

abstract class MiddleClass extends AbsClass12 {
	void method03() {
		System.out.println("method03() 일반메서드");
	}
} // 두번째 부모 MiddleClass 추상클래스

class ChildClass12 extends MiddleClass {
	// 추상 메서드 오버라이딩
	@Override
	void method01() {
		System.out.println("추상 메서드 오버라이딩 method01");
	}

} // 일반 클래스

public class AbsTest12 {
	public static void main(String[] args) {
		ChildClass12 ch = new ChildClass12();
		ch.method01(); // 오버라이딩 한 메서드 호출
		ch.method03(); // 상속 받아서 호출
		ch.method02(); // 상속 받아서 호출
	}

}
