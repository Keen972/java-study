package upcasting;
/*업캐스팅이란?(꼭 클래스에서만 적용되는것은 아님)
 *  1. 상속관계에서 자손타입 참조변수가 부모타입 참조 변수로 변환하는 것을 말함
 *      * 즉, 자손클래스가 부모클래스로 형변환이 이루어 지는것
 *  
 *  2. 업캐스팅은 자바 컴파일러에 의해서 자동형 변환을 해줌.
 */
class Parent01{ //extends object 생략
	void parentPrn() {
		System.out.println("부모클래스 메소드 parentPrn()");
	}
}
class Child01 extends Parent01{
	void childprn() {
		System.out.println("자손 클래스 메소드 chuldPrn()");
	}
}

public class Upcast01 {

	public static void main(String[] args) {
		Parent01 p =new Child01();//업캐스팅, 자동 형변환
		//원래는 child d = new child01(); 인데 업캐스팅하니까 바뀜
		p.parentPrn();

	}

}
