package Thread.kr.or.ddit.basic;

public class T12_ThreadYield {
/*
	yield() 메서드에 대하여...
	
	1. 현재 실행 대기중인 동등한 우선순위 이상의 다른 스레드에게 실행기회를 제공한다.(양보)
	2. 현재 실행중인 스레드의 상태를 Runnable 상태로 바꾼다.
		(WAITING 이나 BLOCKED 상태로 바뀌지 않는다.)
	3. yield() 메서드를 실행한다고 해서 현재 실행중인 스레드가 곧바로 Runnable 상태로
		전이 된다고 확신 할 수 없다.
*/	
	public static void main(String[] args) {
		Thread th1 = new YieldThreadEx1();
		Thread th2 = new YieldThreadEx2();
		
		th1.start();
		th2.start();
	}
}

// Thread 클래스의 생성자를 super를 통해 재정의 하고
// Thread 클래스에 존재하는 getName() 메서드로 재정의 한 name를 호출.
class YieldThreadEx1 extends Thread {
	public YieldThreadEx1() {
		super("YieldThreadEx1");
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
			Thread.yield();  // 양보하기
		}
	}
}


class YieldThreadEx2 extends Thread {
	public YieldThreadEx2() {
		super("YieldThreadEx2");
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}
}