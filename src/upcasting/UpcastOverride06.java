package upcasting;

/**
 * 업캐스팅 이후 오버라이딩 한 메서드 호춣
 */
class Mother06 {
	void m06() {
		System.out.println("부모클래스 메소드 m06");
	}
}

class Son06 extends Mother06 {
	@Override
	void m06() {
		super.m06();
	}
}

public class UpcastOverride06 {

	public static void main(String[] args) {
		Mother06 m = new Son06(); // 업캐스팅
		m.m06(); // 업캐스팅 이후 오버라이딩 한 메서드 호출
	}

}
