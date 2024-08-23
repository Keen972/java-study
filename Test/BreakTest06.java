package Test;
/*레퍼런스(참조변수)에 의한 호출 방식 예제 => 값이 전달되는 것이 아닌 객체 주소가 전달 */

class MyDateo6{
	int year = 2023;
	int month = 8;
	int date = 21;
}

class RefMethod{
	void changeDate(MyDateo6 t) { //MtDate06 t = d; => t와 d의 객체주소는 같다
		t.year = 2024; t.month = 9; t.date=10;
	}
}
public class BreakTest06 {
	public static void main(String[] args) {
		RefMethod rm = new RefMethod();
		MyDateo6 d = new MyDateo6();
		
		System.out.println("changeDate() 메소드 호출 전 : " + d.year+ "/" + d.month + "/" + d.date);
		//2023/8/21
		
		rm.changeDate(d); 
		System.out.println("changeDate() 메소드 호출 후 : " + d.year+ "년" + d.month + "월" + d.date + "일");
		//2024년 9월 10일

	}
	
}
