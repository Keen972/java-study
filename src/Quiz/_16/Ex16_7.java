package Quiz._16;

class Base {
	Base() {
		System.out.println("Base");
	}
}

class Alpha extends Base {}

public class Ex16_7 {

	public static void main(String[] args) {
		new Alpha();
		new Base();
	}

}
