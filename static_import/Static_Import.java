package static_import;

/**
 * 중요 하지 않음 정적 임포트 static import문을 사용하면 static 멤버를 호출 할 때 생략가능하다 - 코드가 간결해진다 많이
 * 사용하지 않음
 */
import static java.lang.System.out;

import java.text.DecimalFormat;

import static java.lang.Math.*;

public class Static_Import {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0.00");
		String formattedPI = df.format(PI);
		// 난수 발생
		System.out.println((int)(Math.random() * 10) + 1);
		// 정적 임포트로 인해
		out.println((int)(random() * 10) + 1); // System, Math 클래스 명이 생략 가능하다
		
		System.out.println("원주율값="+ Math.PI);
		System.out.println("원주율값="+ formattedPI);
	}

}
