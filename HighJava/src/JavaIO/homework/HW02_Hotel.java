package JavaIO.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import Util.ScanUtil;

public class HW02_Hotel {

	private Map<Integer, Guest> guestMap;

	public HW02_Hotel() {
		guestMap = new HashMap<Integer, Guest>();
	}

	public static void main(String[] args) {
		new HW02_Hotel().start();
	}

	public void start() {
		guestCheck();
		System.out.println("=======================");
		System.out.println(" 호텔 문을 열었습니다.");
		System.out.println("=======================");

		while (true) {
			menu();
			int select = ScanUtil.nextInt();
			switch (select) {
			case 1:
				// 체크인
				checkIn();
				break;
			case 2:
				// 체크아웃
				checkOut();
				break;
			case 3:
				// 객실상태
				roomCheck();
				break;
			case 4:
				// 업무 종료
				System.out.println();
				System.out.println("=======================");
				System.out.println(" 호텔 문을 닫았습니다.");
				System.out.println("=======================");
				System.exit(0);
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	public void menu() {
		System.out.println();
		System.out.println("==============================================");
		System.out.println(" 어떤 업무를 하시겠습니까?");
		System.out.println(" 1.체크인  2.체크아웃  3.객실상태  4.업무종료");
		System.out.println("==============================================");
		System.out.print("메뉴선택 >> ");
	}
	
	
	// Input
	public void readList() {
	
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream("D:/D_Other/List.bin"))); 
			
			Object obj = null;
			
			while ((obj = ois.readObject()) != null) {
				guestMap = (HashMap<Integer, Guest>) obj;
			}
			
		} catch (IOException e) {
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Output
	public void writeList() {
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream( 
					new BufferedOutputStream(
						new FileOutputStream("D:/D_Other/List.bin"))); 
			
			oos.writeObject(guestMap);  // 직렬화
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	// 체크인
	public void checkIn() {
		
		readList();
		System.out.println();
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 >> ");
		int roomNum = ScanUtil.nextInt();
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 >> ");
		String name = ScanUtil.nextLine();

		if (guestMap.get(roomNum) != null) {
			System.out.println(roomNum + "번 방에는 이미 사람이 있습니다");
			return;
		}

		guestMap.put(roomNum, new Guest(roomNum, name));

		System.out.println("체크인 되었습니다.");
		writeList();
	}

	// 체크아웃
	public void checkOut() {
		readList();
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 >> ");
		int roomNum = ScanUtil.nextInt();

		if (guestMap.remove(roomNum) == null) {
			System.out.println(roomNum + "번 방에는 체크인한 사람이 없습니다.");
			return;
		}
		
		System.out.println("체크아웃 되었습니다");
		writeList();
		
	}

	// 객실상태
	public void roomCheck() {
		readList();
		Set<Integer> list = guestMap.keySet();
		
		if (list.size() == 0) {
			System.out.println("현재 투숙객이 없습니다.");
			return;
		} else {
			Iterator<Integer> it = list.iterator();
			
			while (it.hasNext()) {
				int num = it.next();
				Guest g = guestMap.get(num);
				System.out.println("방번호 : " + g.getRoomNum() + ", 투숙객 : " + g.getName());
			}
		}
	}
	
	// 파일 체크
	public void guestCheck() {
		File list = new File("D:/D_Other/List.bin");
		
		if (list.exists()) {
			System.out.println("객실 체크 완료!");
		} else {
			try {
				if (list.createNewFile()) {
					System.out.println("객실 체크 완료!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}


class Guest implements Serializable {
	
	private int roomNum;
	private String name;

	public Guest(int roomNum, String name) {
		this.roomNum = roomNum;
		this.name = name;
	}

	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Guest [roomNum=" + roomNum + ", name=" + name + "]";
	}
}