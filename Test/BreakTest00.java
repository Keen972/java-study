package Test;

class Mother17 {

	protected int a = 10;
	protected int b = 20;

	// 생성자가 오버로딩이 되면 묵시적인 기본생성자를 제공하지 않는다.
	public Mother17(int a, int b) {
		this.a = a;
		this.b = b;
	}

}

class Son17 extends Mother16 {
	protected int c = 30;

	public Son17() {
		super(100, 200); // 부모클래스 전달인자 2개짜리 오버로딩 된 생성자를 호출한다 .
		this.c = 300;
	}

	public Son17(int a, int b, int c) {
		super(a, b);
		this.c = c;
	}

	public void print() {
		System.out.println("a=" + a + ", b=" + b + ", c=" + c);
	}
}

public class BreakTest00 {

	public static void main(String[] args) {
		new Son17().print();
		new Son17(1000, 2000, 3000).print();
	}

}
