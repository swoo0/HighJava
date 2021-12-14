package Collection.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import Util.ScanUtil;

public class Lotto {

	public static void main(String[] args) {
		new Lotto().system();
	}

	
	public void system() {
		while (true) {
			System.out.println("==============================");
			System.out.println(" Lotto 프로그램");
			System.out.println("------------------------------");
			System.out.println(" 1. Lotto 구입");
			System.out.println(" 2. 프로그램 종료");
			System.out.println("==============================");
			System.out.print("메뉴 선택 >> ");
			int menu = new ScanUtil().nextInt();
			switch (menu) {
			case 1:
				lottoBuy();
				break;
			case 2:
				System.out.println("감사합니다");
				System.exit(0);
				break;
			default:
				System.out.println("잘못 입력했습니다.");
			}
		}
	}

	
	public void lottoBuy() {
		System.out.println();
		System.out.println(" Lotto 구입 시작");
		System.out.println();
		
		System.out.println("(1000원에 로또번호 하나 입니다.)");
		System.out.print("금액 입력 >> ");
		int money = new ScanUtil().nextInt();
		System.out.println();
		
		int cnt = money / 1000;
		int change = money % 1000;
		if (cnt > 100) {
			System.out.println("한번에 100개 씩만 구입 가능합니다.");
		} else if (cnt < 1) {
			System.out.println("금액이 너무 적습니다. (최소 금액 1000원)");
		} else {
			Random random = new Random();
			System.out.println("행운의 로또번호는 아래와 같습니다.");
			for (int i = 0; i < cnt; i++) {
				Set<Integer> lotto = new HashSet<Integer>();
				
				while (lotto.size() < 6) {
					lotto.add(random.nextInt(45) + 1);
				}
				
				List<Integer> list = new ArrayList<Integer>(lotto);
				Collections.sort(list);
				System.out.println("로또번호 " + (i + 1) + " : " + list);
			}
		}
		System.out.println("받은 금액은 " + money + "원 이고, 거스름돈은 " + change + "원 입니다.");
		System.out.println();
	}
}	
