package Collection.kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.security.auth.kerberos.KerberosTicket;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/*
문제) 이름, 주소, 전화번호 속성을 갖는 Phone클래스를 만들고, 이 Phone클래스를 이용하여 
	  전화번호 정보를 관리하는 프로그램을 완성하시오.
	  이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체출력하는 기능이 있다.
	  
	  전체의 전화번호 정보는 Map을 이용하여 관리한다.
	  (key는 '이름'으로 하고 value는 'Phone클래스의 인스턴스'로 한다.)


실행예시)
===============================================
   전화번호 관리 프로그램(파일로 저장되지 않음)
===============================================

  메뉴를 선택하세요.
  1. 전화번호 등록
  2. 전화번호 수정
  3. 전화번호 삭제
  4. 전화번호 검색
  5. 전화번호 전체 출력
  0. 프로그램 종료
  번호입력 >> 1  <-- 직접 입력
  
  새롭게 등록할 전화번호 정보를 입력하세요.
  이름 >> 홍길동  <-- 직접 입력
  전화번호 >> 010-1234-5678  <-- 직접 입력
  주소 >> 대전시 중구 대흥동 111  <-- 직접 입력
  
  메뉴를 선택하세요.
  1. 전화번호 등록
  2. 전화번호 수정
  3. 전화번호 삭제
  4. 전화번호 검색
  5. 전화번호 전체 출력
  0. 프로그램 종료
  번호입력 >> 5  <-- 직접 입력
  
  =======================================
  번호   이름       전화번호         주소
  =======================================
   1    홍길동   010-1234-5678    대전시
   ~~~~~
   
  =======================================
  출력완료...
  
  메뉴를 선택하세요.
  1. 전화번호 등록
  2. 전화번호 수정
  3. 전화번호 삭제
  4. 전화번호 검색
  5. 전화번호 전체 출력
  0. 프로그램 종료
  번호입력 >> 0  <-- 직접 입력
  
  프로그램을 종료합니다...
  
*/
public class T09_PhoneBook {

	private Scanner scan;
	private Map<String, Phone> phoneBookMap;

	public T09_PhoneBook() {
		scan = new Scanner(System.in);
		phoneBookMap = new HashMap<String, Phone>();
	}

	public static void main(String[] args) {
		new T09_PhoneBook().phoneBookStart();
	}

	// 메뉴를 출력하는 메서드
	public void displayMenu() {
		System.out.println();
		System.out.println("메뉴를 선택하세요.");
		System.out.println(" 1. 전화번호 등록");
		System.out.println(" 2. 전화번호 수정");
		System.out.println(" 3. 전화번호 삭제");
		System.out.println(" 4. 전화번호 검색");
		System.out.println(" 5. 전화번호 전체 출력");
		System.out.println(" 0. 프로그램 종료");
		System.out.print(" 번호입력 >> ");
	}

	// 프로그램을 시작하는 메서드
	public void phoneBookStart() {
		System.out.println("===============================================");
		System.out.println("   전화번호 관리 프로그램(파일로 저장되지 않음)");
		System.out.println("===============================================");

		while (true) {

			displayMenu(); // 메뉴 출력

			int menuNum = scan.nextInt(); // 메뉴 번호 입력

			switch (menuNum) {
			case 1:
				insert(); // 등록
				break;
			case 2:
				update(); // 수정
				break;
			case 3:
				delete(); // 삭제
				break;
			case 4:
				search(); // 검색
				break;
			case 5:
				displayAll(); // 전체 출력
				break;
			case 0:
				System.out.println("프로그램을 종료합니다...");
				return;
			default:
				System.out.println("잘못 입력했습니다. 다시입력하세요.");
			} // switch문
		} // while문
	}



	// 새로운 전화번호 정보를 등록하는 메서드
	private void insert() {
		System.out.println();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");

		String name = scan.next();

		// 이미 등록한 사람인지 검사
		// get()메서드로 값을 가져올 때 가져올 자료가 없으면 null 반환

		if (phoneBookMap.get(name) != null) {
			System.out.println(name + "씨는 이미 등록된 사람입니다.");
			return;
		}

		System.out.print("전화번호 >> ");
		String tel = scan.next();

		System.out.print("주소 >> ");
		scan.nextLine(); 
		String add = scan.nextLine();
		/*
		  입력버퍼에 남아있는 엔터키 값까지 읽어와 버리는 역활을 수행한다.
		  next() 호출 후 nextLine() 호출 시 혹시 남아 있을지 모를
		  쓰레기 값을 위해 한번 호출 한다.
		*/
		
		phoneBookMap.put(name, new Phone(name, tel, add));
		
		System.out.println(name + "씨 등록 완료...");
		
	}

	
	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");

		String name = scan.next();

		// 이미 등록한 사람인지 검사
		// get()메서드로 값을 가져올 때 가져올 자료가 없으면 null 반환

		if (phoneBookMap.get(name) == null) {
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			return;
		}

		System.out.print("전화번호 >> ");
		String tel = scan.next();

		System.out.print("주소 >> ");
		scan.nextLine(); 
		String add = scan.nextLine();
		/*
		  입력버퍼에 남아있는 엔터키 값까지 읽어와 버리는 역활을 수행한다.
		  next() 호출 후 nextLine() 호출 시 혹시 남아 있을지 모를
		  쓰레기 값을 위해 한번 호출 한다.
		*/
		
		phoneBookMap.put(name, new Phone(name, tel, add));
		
		System.out.println(name + "씨 수정 완료...");
		
	}	
	
	
	// 전화번호 정보를 삭제하는 메서드
	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.next();
		
		// remove(key) => 삭제 성공하면 삭제된 value 값을 반환하고
		// 				  실패하면 null을 반환.
		
		if(phoneBookMap.remove(name) == null) {
			System.out.println(name + "씨는 등록된 사람이 아닙니다.");
		} else {
			System.out.println(name + "씨의 정보를 삭제 했습니다.");
		}
		System.out.println("삭제 작업 완료...");
	}
	
	
	private void search() {
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.next();
		
		Phone p = phoneBookMap.get(name);
		
		if(p == null) {
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
		} else {
			System.out.println(name + "씨의 전화번호 정보");
			System.out.println("이    름 : " + p.getName());
			System.out.println("전화번호 : " + p.getTel());
			System.out.println("주    소 : " + p.getAdd());
		}
		System.out.println("검색 작업 완료...");
		
	}
	
	
	// 전체 자료를 출력하는 메서드
	private void displayAll() {
		System.out.println("===================================="); 
		System.out.println(" 번호\t이름\t전화번호\t주소");
		System.out.println("====================================");  
		
		Set<String> keySet = phoneBookMap.keySet();
		
		if (keySet.size() == 0) {
			System.out.println("등록된 전화번호 정보가 없습니다.");
		} else {
			Iterator<String> it = keySet.iterator();
			
			int cnt = 0;
			while (it.hasNext()) {
				cnt++;
				String name = it.next();
				Phone p = phoneBookMap.get(name);
				System.out.println(" " + cnt + "\t" 
							+ p.getName() + "\t"
							+ p.getTel() + "\t"
							+ p.getAdd() + "\t");
			}
		}
		
		System.out.println("===================================="); 
		System.out.println("출력 완료...");
		
	}
	
}




/*
 * 전화번호 정보를 저장할 수 있는 VO (Value Object) 클래스
 */
class Phone {
	private String name; // 이름
	private String tel; // 전화번호
	private String add; // 주소

	public Phone(String name, String tel, String add) {
		super();
		this.name = name;
		this.tel = tel;
		this.add = add;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", tel=" + tel + ", add=" + add + "]";
	}

}
