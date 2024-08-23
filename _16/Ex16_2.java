package Quiz._16;

/**
 * 16장. 상속.PDF 강의교안의 20쪽 1번문제
 */

class Parent {
	private int a;
	int b;
	protected int c;
	public int d;
	
} // parent class

class Child extends Parent {
	// 생성자 오버로딩
	public Child(int a, int b, int c, int d) {
//		this.a = a; // a 멤버 변수가 private 접근 제어자로 정의되어 있어서 외부(자손)클래스에서 접근 불가능
		this.b = b; // 기본 생성자 - 같은 패키지 다른클래스 접근 가능 
		this.c = c;
		this.d = d;
	}
	
	void print() {
//		System.out.println(a); // a 멤버 변수가 private 접근 제어자로 정의되어 있어서 외부(자손)클래스에서 접근 불가능
		System.out.println(b); // a 멤버 변수가 private 접근 제어자로 정의되어 있어서 외부(자손)클래스에서 접근 불가능
		System.out.println(c); // a 멤버 변수가 private 접근 제어자로 정의되어 있어서 외부(자손)클래스에서 접근 불가능
		System.out.println(d); // a 멤버 변수가 private 접근 제어자로 정의되어 있어서 외부(자손)클래스에서 접근 불가능
	}
} // child 자손클래스

public class Ex16_2 {

	public static void main(String[] args) {
		Child child = new Child(1,2,3,4);
		child.print();
	}

}
