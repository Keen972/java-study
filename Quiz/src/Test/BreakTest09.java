package Test;

/**
 * static 키워드로 정의된 정적메서드 내에서는 this와 인스턴스 변수를 사용 할 수 없음
 * 
 *
 */
public class BreakTest09 {

	public static void main(String[] args) {
		
	}

}

class St08 {
	static int a = 10; // 정적 변수
	int b = 20; // 인스턴스 변수
	
	 // static 키워드로 정의된 정적 메소드 ||  정적 메소드 = 클래스 메소드 || 해당 클래스명으로 직접 접근한다
	public static void printA() {
//		System.out.println(this.b); // 정적 메소드 내에서는 this 를 사용하지 못한다.
//		System.out.println(b); // 정적 메소드 내에서는 인스턴스 변수를 사용 할 수 없다.
		
	}
}