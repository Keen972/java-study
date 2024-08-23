package net.daum.controller;

import net.daum.model01.AirCon;
import net.daum.model02.AirModel01;
import net.daum.model02.AirModel02;
import net.daum.model02.AirModel03;

public class AirConMain {

	public static void main(String[] args) {
		AirModel01 air01 = new AirModel01();
		AirModel02 air02 = new AirModel02();
		AirModel03 air03 = new AirModel03();

		air01.goods_in();
		air02.goods_in();
		air03.goods_in();
		System.out.println("\n===============>");

		// 업캐스팅 적용
		AirCon air; // 부모 추상클래스 참조변수 선언
		
		air = new AirModel01();
		air.goods_in(); // 업캐스팅 이후 오버라이딩 한 메서드를 호출

		air = new AirModel02();
		air.goods_in();

		air = new AirModel03();
		air.goods_in();
		System.out.println("\n===============>");

		AirCon[] arr = new AirCon[3]; // 배열 크기가 3인 arr 객체배열을 생성

		arr[0] = new AirModel01(); // 업캐스팅
		arr[1] = new AirModel02();
		arr[2] = new AirModel03();
		
		// 업캐스팅 이후 오버라이딩한 메소드 호출
		for (int i = 0; i < arr.length; i++) {
			arr[i].goods_in();
		}
		System.out.println("\n===============>");
	}

}
