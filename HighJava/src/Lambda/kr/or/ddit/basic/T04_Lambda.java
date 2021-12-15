package Lambda.kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T04_Lambda {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("홍길동1");
		list.add("홍길동2");
		list.add("홍길동3");
		
		// 람다식을 안 쓴 경우...
//		for (String str : list) {
//			System.out.println(str);
//		}
//		
		System.out.println("--------------------------");
		
		// 람다식을 사용한 경우...
//		list.forEach( (str) -> { System.out.println(str); }
//		);
		// 매개변수가 1개 일때 자료형이름 + () 생략 
		// && 식이 1개 일때 {} 생략 
		// && 뒤에 이어지는게 없다면 ';' 생략
		list.forEach( str -> System.out.println(str) );
		
	}
}
