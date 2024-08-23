package Test;

import java.util.Scanner;
import java.util.Stack;

public class test {

	public static void main(String[] args) {
//		() ((( () () ) (()) ())) (())  

		// 레이저 인지 쇠막대기인지 판단
		// ()
		// ( -> 막대기 시작
		// ) -> 막대기 끝

		// (((()))) => 막대기 3개를 반으로 자름 => 6

		// ( => 막대기 시작 => 스택 사이즈 1
		// (( => 막대기 하나 추가 => 스택 사이즈 2
		// ((( => 추가 => 3 => 스택 사이즈 3
		// (((( => 추가 해보자 => 4
		// (((() => 사이즈 -1? => 3
		// (((( )) => chatAt(i-1) => ( 가 아니면 +1 = 4
		// ) 를 만나면 막대기 제거 => + 스택 사이즈만큼

		// (((() => 이전 문자가 ( 인지 판단을 해서 -1 을 해야함 => 3
		// (((()) => 이전문자가 ( 가 아니면 +1 => 4
		// (((())) => +1 5
		// (((()))) => +1 6

		// () (()) => 2등분 => 2
		// ( +1 = 1
		// ) -1 = 0
		// ( +1 = 1
		// ( +1 = 2
		// ) -1 = 1
		// ) +1 = 2

		Scanner input = new Scanner(System.in);
//
		String str = input.next();
		int count = 0;
		int openBars = 0;

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			// 막대기 시작 아니면 레이저
			if (ch == '(') {
				openBars++;
				// 막대기 끝 아니면 레이저
			} else {
				openBars--;
				if (str.charAt(i - 1) == '(') {
					count += openBars;
				} else {
					count++;
				}

			}

		}

		System.out.println(count);

	}

}
