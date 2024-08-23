package Quiz._16;

/**
 * 16장.상속.PDF 강의교안의 23쪽 3번문제
 */

// Animal class
class Animal {
	protected String kind;
	protected int leg;

	// 기본 생성자
	public Animal() {

	}

	// 생성자 오버로딩
	public Animal(String kind, int leg) {
		this.kind = kind;
		this.leg = leg;
	}

	// 비효율적인거 같음 - 방법이 없을까?
	public void getKind() {

		if (kind.equals("소녀")) {
			System.out.println(kind + "는 사람이고 ");
			kind = "사람";
		} else if (kind.equals("강아지")) {
			System.out.println(kind + "는 동물이고 ");
			kind = "동물";
		}

	}

	public void walk() {
		if (leg == 2) {
			System.out.println(kind + "은 " + leg + "발로 걷는다");
		} else if (leg == 4) {
			System.out.println(kind + "은 " + leg + "발로 걷는다");
		}
	}
}

class Dog extends Animal {
	public Dog() {

	}

	public Dog(String kind, int leg) {
		super(kind, leg);
	}
}

class Human extends Animal {
	public Human() {

	}

	public Human(String kind, int leg) {
		super(kind, leg);
	}
}

public class Ex_16_4 {
	public static void main(String[] args) {
		Dog d = new Dog("강아지", 4);
		Human h = new Human("소녀", 2);
		
		d.getKind();
		d.walk();
		h.getKind();
		h.walk();
	}
}
