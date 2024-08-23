package Quiz;

/**
 * 17장. 레퍼런스 형 변환.PDF 파일에서 No.19쪽 2번문제
 */

class SubClass {
	int i = 3;

	void print() {
		System.out.println(i);
	}
}

public class Ex17_01 {

	public static void main(String[] args) {
		Object obj = new SubClass(); // 업케스팅
		/**
		 * 문제) 형변환유무 판단 연산자와 if조건문을 사용해서 다운캐스팅이 가능할때만 형변환되게 만들어보자 SubClass에 사용자 정의 메서드
		 * void print()를 정의해서 i멤버변수값을 출력해보자
		 */

		if (obj instanceof SubClass) { // 다운캐스팅이 가능한가?
			SubClass sc = (SubClass) obj; // 명시적 다운캐스팅 
			sc.print(); 
		} else {
			System.out.println("다운캐스팅이 불가능 합니다");
		}

	}

}
