package Test;

class Parent11 {
	void p11() {
		System.out.println("부모클래스 메서드 p11()");
	}
}

class Child11 extends Parent11 {

	@Override
	void p11() {
		super.p11();
		System.out.println("자손에 맞게 오버라이딩 한 메서드 p11()");
	}
	
}

public class BreakTest12 {

	public static void main(String[] args) {
		Child11 c = new Child11();
		c.p11(); // 오버라이딩 한 메서드 호출
	}

}
