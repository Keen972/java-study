package upcasting;
/* 다운 캐스팅이란? (꼭 클래스에서만 적용되는것은 아님)
 * 1. 상속관계에서 부모타입의 참조변수가 자손타입의 참조변수로 변환하는 것
 *     * 즉 부모클래스가 자손클래스로 형변환 이루어 지는 것을 의미
 * 2. 참조타입(레퍼런스타입) 간의 전제조건
 *     1) 사전에 상속관계를 만들기
 *     2) 다운캐스팅 하기 전에는 무조건 업캐스팅을 해줘야함
 *          * 그래야만 다운 캐스팅을 허용, 아니면 오류
 *     3) 자바 컴파일러에 의해 자동형변환은 안되므로 캐스팅 연산자로 강제 형변환 해주기
 */
class Parent02{
	void pr02() {
		System.out.println("부모클래스 메소드 pr02()");
	}
	
}
class Child02 extends Parent02{
	void ch02() {
		System.out.println("자손클래스 메소드 ch02()");
	}
}

public class Downcast02 {
	public static void main(String[] args) {
		Parent02 p = new Child02(); //업캐스팅 
		p.pr02();//부모클래스에서 정의 된 메소드 호출
		
		Child02 ch; //자손 클래스 변수 생성
		ch = (Child02) p; //다운 캐스팅, 
//		Child02 ch = (Child02) p; //이렇게 한줄로도 가능함!
		
		ch.pr02();// 다운 캐스팅 후 부모 메소드 호출
		ch.ch02();//자손클래스에서 정이된 메소드 호출

	}

}
