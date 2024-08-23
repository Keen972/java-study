package abstractclass;

/*추상클래스를 상속받은 일반 자손클래스는 반드시  부모클래스의 추상메서드를 오버라이딩 해야한다
 * 그래야만 자손클래스 객체 생성이 가능하다 */

abstract class Father11{
	abstract void m01();//추상메서드 정의
	 void m02() {
		 System.out.println("일반 메서드 m02");
	 }
}

class Son11 extends Father11{

	@Override
	void m01() {
		System.out.println("m01추상메서드 오버라이딩");
	} 
}
public class AbsTest11 {
	public static void main(String[] args) {
		
		Father11 f = new Son11();//업캐스팅
		f.m01();//업캐스팅한 이후 오버라이딩 한 메소드 호출
		
		Son11 s =new Son11();
		s.m01();//자식클래스에서 오버라이딩한 메소드 호출
		s.m02();//상속받아서 호출
	}

}
