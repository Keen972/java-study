package Test;

class Point2D extends Object {
	private int x;
	private int y;

	// 매개변수(전달인자)가 없는 기본생성자 묵시적 제공

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

} // Point2D class

class Point3D extends Point2D {
	private int z;

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

} // 자손클래스 Pont3D class

public class BreakTest11 {

	public static void main(String[] args) {
		Point3D pt = new Point3D();

		pt.setX(100);
		pt.setY(200); // 상속받아서 호출

		pt.setZ(300);

		System.out.println("x좌표값:" + pt.getX() + ",y좌표값:" + pt.getY() + ",z좌표값:" + pt.getZ());
		
		
	
	}

}

// 메소드 오버로딩 - 동일한 이름의 메소드를 여러 개 정의 & 매개변수의 유형이나 갯수를 다르게 설정
// 메소드 오버라이딩 - 부모 클래스에 정의된 메소드를 자식 클래스에서 재정의(override)










