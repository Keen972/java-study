package upcasting;

/**
 * 레퍼런스 타입간의 형변환 중 다운캐스팅은 반드시 사전에 업캐스팅을 하고 다운캐스팅을 해야 하는데 사전에 업캐스팅을 하지 않고 명시적인
 * 다운캐스팅을 하면 정상적인 컴파일은 되지만 실행시 캐스팅 예외 오류가 발생한다. 이 오류가 가장 많이 발생한다.
 */
class Father04 {
	void f04() {
		System.out.println("부모클래스 메서드 f04()");
	}
}

class Son04 extends Father04 {
	void s04() {
		System.out.println("자손클래스 메서드 s04()");
	}
}

public class Downcast04 {

	public static void main(String[] args) {
		Father04 f = new Father04(); // 사전에 업캐스팅을 하지 않고 부모클래스 객체 f 만 생성
		Son04 s = (Son04) f; // 업캐스팅을 하지 않고 다운캐스팅을 하여 캐스트 연산
		// 예외 오류가 발생한다. 정상적인 컴파일이 된 바이트 코드 클래스 파일을 자바 가상 머신 위세서 java 명령어 실행시 예외오류가 발생한다.
		s.f04();
		s.s04();
	}

}
