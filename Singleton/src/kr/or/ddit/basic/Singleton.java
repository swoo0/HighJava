package kr.or.ddit.basic;

public class Singleton {
	public static void main(String[] args) {
		
//		MySingleton test1 = new MySingleton();
		
		// getInstance() 메서드를 이용하여 객체 생성
		MySingleton test2 = MySingleton.getInstance();
		test2.displaytext();
		
		MySingleton test3 = MySingleton.getInstance();
		
		System.out.println("test2 =>" + test2);
		System.out.println("test3 =>" + test3);
		
		
		
		
		
		
	}
}
