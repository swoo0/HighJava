package Lambda.kr.or.ddit.basic;

// 함수적 인터페이스 => 추상메서드가 1개 뿐인 인터페이스

@FunctionalInterface
public interface LambdaInf1 {
	// 반환값이 없고 매개변수도 없는 추상메서드 선언
	public void test();
}

@FunctionalInterface
interface LambdaInf2 {
	// 반환값이 없지만 매개변수는 있는 추상메서드 선언
	public void test(int a);
}

@FunctionalInterface
interface LambdaInf3 {
	// 반환값이 있고 매개변수도 있는 추상메서드 선언
	public int test(int a, int b);
}

@FunctionalInterface
interface LambdaInf4 {
	// 반환값이 있고 매개변수도 있는 추상메서드 선언
	public boolean test(int a);
}
