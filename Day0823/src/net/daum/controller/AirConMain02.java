package net.daum.controller;

import net.daum.model01.AirCon;
import net.daum.model02.AirModel01;
import net.daum.model02.AirModel02;
import net.daum.model02.AirModel03;

/**
 * 하나는 매개변수 다형성 문법이 적용 안된것과 적용된 예제소스 매개변수 다형성 문법을 적용할려면 상속,업캐스팅, 메서드 오버라이딩 등이 적용
 * 되어야 한다.
 */
public class AirConMain02 {
	static void inCome(AirModel01 air) {
		air.goods_in();
	}

	static void inCome(AirModel02 air) {
		air.goods_in();
	}

	static void inCome(AirModel03 air) {
		air.goods_in();
	} // 매개변수 다형성 문법을 적용하지 않으면 자손클래스 개수만큼 메서드를 오버로딩을 해야한다.
		// 그만큼 불필요한 코드라인이 추가된다.
	
	static void inCome2(AirCon air) {
		air.goods_in();
	}
	public static void main(String[] args) {
		inCome(new AirModel01());
		inCome(new AirModel02());
		inCome(new AirModel03());
		inCome2(new AirModel03());
		System.out.println("\n===============>");
	}

}
