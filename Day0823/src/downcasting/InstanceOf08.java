package downcasting;

/**
 * UpcastDowncast07 에 정의된 Car 부모클래스와 FireEngine 자손클래스를 활용한
 * instanceof 형변환 유무 판단 연산자에 관한 실습이다
 */
public class InstanceOf08 {

	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		
		if(fe instanceof FireEngine) {
			System.out.println("fe 가 FireEngine 이다. ");
		}
		
		if(fe instanceof Car) { // fe 가 Car 부모타입으로 업캐스팅이 가능한가?
			System.out.println("업캐스팅이 가능하다.");
		}
		
		if(fe instanceof Object) { // fe 가 Object 부모타입으로 업캐스팅이 가능한가?
			System.out.println("업캐스팅이 가능하다.");
		}
		
		String type = fe.getClass().getName();
		System.out.println(type); // fe타입 패키지명.해당클래스명을 출력한다
	}

}