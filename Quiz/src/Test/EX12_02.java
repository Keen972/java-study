package Test;

class Mp3 {
	private String comp; // 회사명
	private int size; // 메모리 용량

	public String getComp() {
		return comp;
	}

	public int getSize() {
		return size;
	}

	public void setComp(String new_comp) { // 값 저장메서드 => setter()메서드
		this.comp = new_comp;
	}

	public void setSize(int new_size) {
		this.size = new_size;
	}

}

public class EX12_02 {

	public static void main(String[] args) {
		Mp3 m3 = new Mp3();
		m3.setComp("갑을회사");
		m3.setSize(8);

		System.out.println("회사명: " + m3.getComp());
		System.out.println("메모리 용량: " + m3.getSize() + "G");
	}

}
