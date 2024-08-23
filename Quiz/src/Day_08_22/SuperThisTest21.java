package Day_08_22;

/**
 * this()는 같은 클래스내의 오버로딩된 다른 생성자를 호출한다. 상속과 관련 없다. super()는 부모클래스 생성자를 호출한다. 상속과
 * 관련 있다.
 */
class Point {
	int x = 10;
	int y = 20;

	// 생성자 overloading
	Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
} // Point Class

class Point3D extends Point {
	int z = 30;

	Point3D() { 
		this(100, 200, 300); // 같은 클래스내의 오버로딩 된 생성자 호출
	}

	Point3D(int x, int y, int z) {
		super(x, y); // 부모클래스 오버로딩 된 생성자를 호출
		this.z = z;
	} // 생성자 오버로딩
	
	void pr() {
		System.out.println("x: " + x + " y: " + y + " z: " + z);
	}

}

public class SuperThisTest21 {

	public static void main(String[] args) {
		new Point3D().pr();
		new Point3D(1000,2000,3000).pr();
	}

}
