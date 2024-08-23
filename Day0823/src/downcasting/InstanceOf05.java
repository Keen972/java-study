package downcasting;

/**
 * 업캐스팅 서브클래스 객체를 슈퍼클래스 타입으로 변환하는 것 명시적으로 타입 변환을 할 필요 X SuperClass obj = new
 * SubClass();
 * 
 * 슈퍼클래스 타입의 객체를 서브클래스 타입으로 변환하는 것 SubClass obj = (SubClass) superClass;
 * 
 * instanceOf 는 형변환 유무 판단 연산자이다.
 */
class HandPhone {
	String model;
	String number;

	public HandPhone() {

	}

	public HandPhone(String model, String number) {
		this.model = model;
		this.number = number;
	} // 생성자 오버로딩
}

class DicaPhone extends HandPhone {
	String pixel;

	public DicaPhone() {
	}

	public DicaPhone(String model, String number, String pixel) {
		super(model, number);
		this.pixel = pixel;
	}

	public void prnDicaPhone() {
		System.out.println("폰 모델: " + model + " 폰 번호: " + number + " 화소수: " + pixel);
	}
}

/**
 * 다운캐스팅은 다형성을 활용하여 상위 클래스 타입의 변수로 다양한 하위 클래스 객체를 관리하고, 특정 기능이 필요할 때 해당 하위 클래스로
 * 변환하여 사용하는 경우에 매우 유용합니다. 그러나 다운캐스팅은 항상 객체의 실제 타입을 확인한 후 안전하게 수행해야 하며, 그렇지 않을
 * 경우 런타임 에러가 발생할 수 있습니다.
 */
public class InstanceOf05 {

	public static void main(String[] args) {
		DicaPhone dp = new DicaPhone("갤럭시", "010-7777-7777", "1024");
		dp.prnDicaPhone();

		if (dp instanceof DicaPhone) {
			System.out.println("dp는 디카폰이다");
		}

		if (dp instanceof HandPhone) {
			HandPhone hp = dp; // 업캐스팅
			System.out.println("업캐스팅이 가능하다");
		}

		HandPhone hp2 = new HandPhone(); // 사전에 업캐스팅 안함 => 다운캐스팅 허용 안함
		if (hp2 instanceof DicaPhone) {
			DicaPhone dp2 = (DicaPhone) hp2; // 명시적인 다운캐스팅
			System.out.println("다운 캐스팅이 가능하다");
		} else {
			System.out.println("다운 캐스팅이 불가능 하다");
		}

	}

}
