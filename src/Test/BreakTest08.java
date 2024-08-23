package Test;

/**
 * 
 * 참조변수에 null 만 대입한 상태에서 사용하면 NullPointerException 가 발생 try-catch문으로 예외 처리해야함
 * 
 */
class MyDate07 {
	int year = 2024;
	int month = 8;
	int day = 21;

} // MyDate07 class

public class BreakTest08 {

	public static void main(String[] args) {
		MyDate07 d = null;
		try { // 정상구문 실행
			System.out.println(d.year + "년 " + d.month + "월 " + d.day + "일"); // 예외 발생하면
			// 아래문장 실행안함
			System.out.println("이 문장은 실행 안함");
		} catch (Exception e) {
			System.out.println("예외 오류 메시지 : " + e.getMessage());
			e.printStackTrace(); // 예외 족적을 남김
		}

	}

}
