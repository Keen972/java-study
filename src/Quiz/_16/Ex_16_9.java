package Quiz._16;

/**
 * 상속관계에서 메서드 오버라이딩과 super.메서드()에 관한 소스
 */
class A2 {
	@Override
	public String toString() {
		return "4";
	}
}

class B2 extends A2 {

	@Override
	public String toString() {
		return super.toString() + "3";
	}

}

public class Ex_16_9 {

	public static void main(String[] args) {
		// toString() 메소드는 Java의 모든 클래스가
		// 암묵적으로 상속받는 Object 클래스에 기본적으로 정의된 메소드이기 떄문에
		// 상속 받은 모든 클래스에 오버라이딩이 된다면 암묵적으로 호출이 된다
		System.out.println(new B2());
	}

}
