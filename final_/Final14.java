package final_;

/**
 * 메서드를 final 로 선언하면 더이상 자손에서 오버라이딩을 허락하지 않는다
 */
class FinalMethod14 {
	public final void pr() {
		System.out.println("파이널 메소드임");
	}
}

class Son14 extends FinalMethod14 {

//	@Override
//	public void pr() {
//		System.out.println("pr 메소드는 파이널 메소드여서 오버라이딩 불가능");
//	} 당연하지
//	
}

public class Final14 {
	public static void main(String[] args) {
		FinalMethod14 fm = new FinalMethod14();
		fm.pr();
	}

}
