package Quiz._16;

/**
 * 부모클래스에서 생성자가 오버로딩이 되면 매개변수가 없는 기본생성자를 묵시적으로 제공하지 않는다. 이런경우 자손클래스에서 부모의 기본
 * 생성자를 호출할려다가 에러가 발생한다.
 */
class Parent01 {

	Parent01(int i) {
	}
}

class Sub extends Parent01 {
	Sub() {
		super(0);
//		super(); // 에러 발생 
	}
}

public class Ex16_6 {

	public static void main(String[] args) {
		// 자손의 기본 생성자 호출 => 부모클래스에서 생성자가 오버로딩이 되었으므로 기본생성자를 묵시적으로 제공하지 않는다
		// 그러므로 컴파일 에러가 발생
		new Sub();
	}

}
