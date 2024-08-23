package Quiz._16;

class A {
	public A() {
		System.out.println("hello from a");
	}
}

class B extends A {
	public B () {
		System.out.println("hello from b");
//		super(); // super() 는 자식 클래스의 기본 생성자 맨 위에서 호출만 가능
	}
}
public class E16_8 {
	public static void main(String[] args) {
		A a = new B();
	}

}
