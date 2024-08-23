package Day_08_22;
/*인스턴스 초기화 블록{} 을 사용해서 정적변수와 인스턴스 변수 초기화*/
class Product{
	static int count = 0; //정적변수 초기화
	int serialNumber = 0; //객체변수 초기화
	{
		++count; // 먼저 1증가 즉 선행증가한 누적카운터 = > 총 생산된 제품수
		serialNumber = count;
	}//인스턴스 초기화 블록을 사용해서 정적변수(count)와 인스턴스 변수(SerialNumber)를 함께 초기화
	
	public Product() {} // 기본생성자 => 생략해도 묵시적 제공 ,
}//product class

public class InstanceBlockTest19 {
	public static void main(String[] args) {
		Product p01 = new Product();
		Product p02 = new Product();
		Product p03 = new Product();
		
		System.out.println("p01 제품번호(시리얼 고유번호)는  " + p01.serialNumber);
		System.out.println("p02 제품고유번호는  " + p02.serialNumber);
		System.out.println("p03 제품고유번호는  " + p03.serialNumber);
		System.out.println("총 생산된 제품 수는  " + Product.count/*p01,p02,p03*/); //클래스명, 정적변수로 접근

	}

}
