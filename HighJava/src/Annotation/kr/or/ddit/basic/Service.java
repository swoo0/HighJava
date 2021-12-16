package Annotation.kr.or.ddit.basic;

public class Service {
	
	@PrintAnnotation
	public void method1() {
		System.out.println("메서드1에서 출력되었습니다.");
	}
	
//	@PrintAnnotation(value="%")  value값 하나만 있는 경우 생략 가능 
	@PrintAnnotation("%")
	public void method2() {
		System.out.println("메서드2에서 출력되었습니다.");
	}
	
	@PrintAnnotation(value="#", count= 25)
	public void method3() {
		System.out.println("메서드3에서 출력되었습니다.");
	}
}
