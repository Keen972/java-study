package Day_08_22;

/* this()는 같은 클래스 내의 오버로딩 된 다른 생성자를 호출, 상속과 관련이 없다
 * super()은 부모 자식 간 상속 관계에서 불러오면서 사용 하는 것. 헷갈리지 말기
 * 인스턴스 초기화 블록{}과 클래스 초기화 블록인 static{} 을 사용하지 않고 생성자를 통한 초기화
 */
class Document {
	static int count = 0;
	String name;// 문서명

	Document() {
		this("제목없음" + ++count);/* 같은 클래스 오버로딩 된 생성자를 호출하기 (오버로딩 안하면 error) */

	}// 기본생성자

	Document(String name) {
		this.name = name;
		System.out.println("문서 " + this.name /* 같은 클래스 내 객체를 접근하세요 */ + " 이 생성되었습니다");
	}// 생성자 오버로딩
}

public class ThisBlockTest20 {

	public static void main(String[] args) {
		/* 오버로딩 된 Document(String name)을 호출하는것 */
		Document d = new Document();
		// Document()를 호출하는것 , d라는 변수는 사용을 안하므로 호출 할 필요가 없음
		// String 에 Document()에 있는 this 안에 (제목없음 + ++count(1)를 대입
		new Document("자바. txt ");
		// String 에 "자바.txt를 대입"
		new Document();
		// String 에 Document()에 있는 this 안에 (제목없음 + ++count(2)를 대입

	}

}
