package downcasting;

class Mother06 {
	public Mother06() {
		
	}
	
	void m06() {
		
	}
}

class Son06 extends Mother06 {

}

public class UpcastOverride {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mother06 m = new Son06();
		m.m06();
	}

}
