package Thread.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HW01_HorseGame {
	static int strRanK = 1;

	public static void main(String[] args) {
		
		List<Horse> list = new ArrayList<Horse>();
		list.add(new Horse("1번 말"));
		list.add(new Horse("2번 말"));
		list.add(new Horse("3번 말"));
		list.add(new Horse("4번 말"));
		list.add(new Horse("5번 말"));
		list.add(new Horse("6번 말"));
		list.add(new Horse("7번 말"));
		list.add(new Horse("8번 말"));
		list.add(new Horse("9번 말"));
		list.add(new Horse("10번말"));
		
		for (Horse hs : list) {
			hs.start();
		}
		
		for (Horse hs : list) {
			try {
				hs.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("끝!");
		System.out.println();
		System.out.println("=============");
		System.out.println("  경기 결과  ");
		System.out.println("=============");
		
		Collections.sort(list);
		for (Horse hs : list) {
			System.out.println(hs.getHorseName() + " : " + hs.getRank() + "등");
		}
		System.out.println("=============");
	}
}


class Horse extends Thread implements Comparable<Horse> {
	
	private String name;
	private int rank;

	public Horse(String name) {
		this.name = name;
	}
	
	public String getHorseName() {
		return name;
	}
	public void setHorseName(String name) {
		this.name = name;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public int compareTo(Horse h) {
		return getRank() - h.getRank();
	}
	
	@Override
	public void run() {
		
		for (int i = 1; i <= 50; i++) {
			System.out.print(name + " ");
			for (int j = 1; j < i; j++) {
				System.out.print("-");
			}
			System.out.print(">");
			for (int x = 49; x >= i; x--) {
					System.out.print("-");
			}
			System.out.println();
			
			try {
				Thread.sleep((int)(Math.random() * 301 + 200));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + " 골인 !");
		setRank(HW01_HorseGame.strRanK++);
	}
}
