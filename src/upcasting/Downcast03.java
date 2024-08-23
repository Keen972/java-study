package upcasting;
/*강제 형변환(명시적 형변환)을 안해서 발생하는 오류 예제*/

class Parent03{
	void p03() {
		System.out.println(" 부모클래스 메소드 p03()");
	}
}
class Son03 extends Parent03{
	void s03() {
		System.out.println("자손클래스 메소드 s03()");
	}
}
public class Downcast03 {

	public static void main(String[] args) {
		Parent03 p = new Son03(); //업캐스팅 (자동 형변환)
		
//		Son03 s = p; // 캐스팅 연산자(Son03)를 안쓰고 다운캐스팅 시도하면 컴파일 에러
		Son03 s = (Son03) p; //이렇게 써야 error 안남
		s.p03();
	}

}
