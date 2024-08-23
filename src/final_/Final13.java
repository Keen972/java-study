package final_;

/**
 * 변수를 final로 선언하면 수정할 수 없는 상수가 된다. 상수명은 관례적으로 영문대문자로 한다
 */

class FinalMember {
	final int ABC = 100;

	public void setABC(int abc) {
//		this.ABC = abc; // 상수는 변경 불가능
	}
	
	public void pr() {
		System.out.println("ABC 상수값: " + ABC);
	}
}

public class Final13 {

	public static void main(String[] args) {
		FinalMember fm = new FinalMember();
		fm.setABC(10000);
		fm.pr();
	}

}
