package Day_08_22;

/*초기화 블록) *자주나오는 부분은 아니나 알고 있으면 좋음
 * 1.생성자의 주된 기능은 클래스 소속 멤버변수 중 인스턴스 변수 초기화 이다.
 * 2, 초기화란 변수정의하고 최초값을 저장하는 것
 * 3. 클래스 초기화 블록 특징
 *     가. 정적변수(클래스변수,static)의 복잡한 초기화에 사용
 *     나. 해당 클래스가 메모리에 처음 로딩될 때 한번만 수행
 * 4. 인스턴스 초기화 블록 특징
 *     가. 인스턴스 변수의 복잡한 초기화에 사용
 *     나. 생성자와 같이 객체(인스턴스)를 생성 할때마다 수행
 *     다. 생성자보다 인스턴스 초기화 블록이 먼저 수행
 */
public class BlockTest17 {
	static {
		System.out.println("static{}");
	}// 클래스 초기화 블록 , 객체를 한 번 더 생성하여도 한번만 수행

	{
		System.out.println("{}");
	}// 인스턴스 초기화 블록, 생성자 보다 먼저 수행

	public BlockTest17() {
		System.out.println("기본생성자 BlockTest17");
	}// 기본 생성자

	public static void main(String[] args) {
		new BlockTest17();
		new BlockTest17();

	}

}
