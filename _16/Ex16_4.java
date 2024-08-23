package Quiz._16;

/**
 * 16장.상속.PDF 강의교안의 26쪽 4번문제
 */

class HandPhone {
	protected String model;
	protected String number;

	// 기본 생성자
	public HandPhone() {

	}
	// 생성자 오버로딩 
	public HandPhone(String model, String number) {
		this.model = model;
		this.number = number;
	}

	public String getModel() {
		return model;
	}

	public String getNumber() {
		return number;
	}
}

class DicaPhone extends HandPhone {
	protected String pixel;
	
	// 기본 생성자
	public DicaPhone() {

	}
	
	// 생성자 오버로딩 
	public DicaPhone(String model, String number, String pixel) {
		super(model, number);
		this.pixel = pixel;
	}

	public void prnDicaPhone() {
		System.out.println("모델명 : " + getModel() + " 번호 : " + getNumber() + " 화소수 : " + pixel);
	}
}

public class Ex16_4 {

	public static void main(String[] args) {
		DicaPhone dp = new DicaPhone("갤럭시", "010", "1024");
		dp.prnDicaPhone();
	}

}
