package Test;

/**
 * 상속에서 생성자 호출에 관한 부분
 */
class Mother14 {
	protected int x = 10;
	protected int y = 20;

	// 생성자 명은 클래스 명과 같게 만든다.
	public Mother14() {
		super(); // 최상위 부모클래스 Object의 기본생성자를 먼저 호출한다. 물론 생략가능하다.
		System.out.println("부모클래스 Mother14() 기본생성자 호출");
	} // 매개변수가 없는 기본생성자

}

class Son14 extends Mother14 {
	protected int z = 30;

	public Son14() {
//		super(); // 가 생략 . => 부모의 기본생성자를 먼저 호출
		System.out.println("자손클래스 Son14() 기본생성자 호출");
	}

	public void pr() {
		System.out.println("x=" + x + ", y=" + y); // x,y는 상속받아서 호출
	}
}

public class BreakTest15 {

	public static void main(String[] args) {
		new Son14().pr(); 
	}

}
