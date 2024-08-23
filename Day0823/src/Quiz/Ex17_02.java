package Quiz;

/**
 * 17장. 레퍼런스 형 변환.PDF 파일에서 No.20쪽 3번문제 업캐스팅 이후 오버라이딩 한 메소드 호출에 관한 문제이다
 */

class Super {
	public int getNumber(int k) {
		return k + 1;
	}
} // 부모

class CastingEx03 extends Super {

	@Override
	public int getNumber(int k) {
		return k + 2;
	}

} // 자손

public class Ex17_02 {

	public static void main(String[] args) {
		Super sp = new CastingEx03();
		System.out.println(sp.getNumber(1)); // 3 => 업캐스팅 이후 오버라이딩 한 메서드를 호출한다.

	}

}