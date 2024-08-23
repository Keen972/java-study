package downcasting;

/**
 * 레퍼런스 간의 형변환에서 업캐스팅과 다운캐스팅을 알아보는 예제
 */
class Car {
	String color;
	int door;

	void drive() {
		System.out.println("차가 드라이브 한다");
	}

	void stop() {
		System.out.println("차가 멈춘다");
	}
} // 부모 Car 클래스

class FireEngine extends Car {
	void water() {
		System.out.println("소방차가 물을 뿌린다");
	}
} // 자손 FireEngine

public class UpcastDowncast07 {

	public static void main(String[] args) {
		// 자손 클래스
		FireEngine fe = new FireEngine();
		Car car = fe; // 업캐스팅
		
		// 한줄로도 표현 가능
//		Car car = new FireEngine();

		car.drive();
		car.stop();
		// car.water(); 는 다운캐스팅을 하지 않았기 때문에 호출 불가
		FireEngine fe2 = (FireEngine) car; // 명시적인 다운캐스팅
		fe2.water();
	}

}
