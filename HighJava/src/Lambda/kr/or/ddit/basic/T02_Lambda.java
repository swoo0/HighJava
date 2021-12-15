package Lambda.kr.or.ddit.basic;

public class T02_Lambda {
	
	public static void main(String[] args) {
		// 람다식을 사용하지 않았을 경우..
		LambdaInf1 lam1 = new LambdaInf1() {
			
			@Override
			public void test() {
				System.out.println("난 익명구현객체.");
			}
		};
		lam1.test(); // 메서드 호출
		
		LambdaInf1 lam2 = () -> {
			System.out.println("어서와 람다는 처음이지?");
		};
		lam2.test();
		System.out.println("-----------------------------------");
		
/*		
	람다식의 작성 방법
	
	기본형식) (자료형이름 매개변수명, ...) -> {실행문들; ...}
	
	1) 매개변수의 '자료형이름'은 생략할 수 있다.
	 ex) (int a) -> { System.out.println(a); }
		 (a) -> { System.out.println(a); }
		
	2) 매개변수가 1개일 경우에는 괄호'()'를 생략할 수 있다.
	   (단, '자료형이름'을 지정할 경우에는 괄호를 생략할 수 없다.)
	 ex) a -> { System.out.println(a); }
	 
	3) '실행문'이 1개일 경우에는 '{}'를 생략할 수 있다.
	   (이때 문장의 끝을 나타내는 세미콜론(;)도 생략한다.)
	 ex) a -> System.out.println(a)
	 
	4) 매개변수가 하나도 없으면 괄호'()'를 생략할 수 없다.
	 ex) () -> System.out.println("안녕")
	 
	5) 반환값이 있을 경우에는 return문을 사용한다.
	 ex) (a, b) -> { return a + b; }
	     (a, b) -> return a + b
	     
	6) 실행문에 return문만 있을 경우 return문과 '{}'를 생략할 수 있다.
	 ex) (a, b) -> a + b
*/		
		
		
		LambdaInf2 lam3 = (int z) -> {
			int result = z + 100;
			System.out.println("result = " + result);
		};
		lam3.test(30);
		
		// 자료형 이름 생략 가능 + 매개변수가 1개이면 () 생략 가능.
		LambdaInf2 lam4 = z -> {
			int result = z + 300;
			System.out.println("result = " + result);
		};
		lam4.test(60);
		
		// 식이 1개면 중괄호 생략가능
		LambdaInf2 lam5 = z -> 
			System.out.println("result = " + (z+500));
		lam5.test(90);
		
		
		LambdaInf3 lam6 = (int x, int y) -> {
			int r = x + y;
			return r;
		};
		int k = lam6.test(20, 50);
		System.out.println("k = " + k);
		
		// 자료형 이름 생략가능.
		LambdaInf3 lam7 = (x, y) -> {
			return x + y;
		};
		k = lam7.test(80, 50);
		System.out.println("k = " + k);

		// 식이 1개면 return문 + {} 괄호 생략 가능.
		LambdaInf3 lam8 = (x, y) -> x + y;
		k = lam8.test(100, 200);
		System.out.println("k = " + k);
		
		
		LambdaInf3 lam9 = (x, y) -> x > y ? x : y;
		k = lam9.test(100, 200);
		System.out.println("k = " + k);
		
		
		LambdaInf4 lam10 = x -> x > 10 ? true : false;
		boolean b = lam10.test(15);
		System.out.println("k = " + b);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
