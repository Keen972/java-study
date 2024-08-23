package Day_08_22;

/* static 키워드로 정의된 정적배열을 클래스 초기화 블록 static{} 을 사용해서
 * 배열원소값을 초기화 하는 예제 
 */
public class BlockTest18 {
	static int[] arr = new int[10]; // 배열 크기가 10인 정적배열 arr 생성
	static double[] arr2 = new double[10];

	static {
		for (int i = 0; i < arr.length; i++) {
//			arr2[i] = (Math.random() * 10) + 1; 
			arr[i] = (int) (Math.random() * 10) + 1; 
			// Math.random()은 0.0이상 1.0미만의 실수 숫자 난수(임의의수)발생
			// Math.random()+10 : 0,0이상 10,0미만 => int로 형변환
			// 즉 캐스팅 시 소수점 이하 버리고 0~10 미만의 정수숫자만 구함
			// => 여기에 +1하면 1이상 11 미만 사이의 정수숫자 난수가 arr 배열 원소값으로 저장
			// (1에서 10까지 랜덤으로 임의의수 나옴)
		}
		// 클래스초기화블록에서 정적배열 원소값 저장
	}

	public static void main(String[] args) {
		// 자바5에서 추가된 향상된 확장for 반복문으로 배열 원소값 출력 , 배열 입 출력은 for문이 담당한다는 걸 잊지말자
		for (int a : arr) {
			System.out.print(" " + a);
		}

	}

}
