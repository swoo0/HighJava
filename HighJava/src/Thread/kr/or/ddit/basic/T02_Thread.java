package Thread.kr.or.ddit.basic;

public class T02_Thread {
	public static void main(String[] args) {
		// 멀티 스레드 프로그램 방식

		// 방법 1 : Thread 클래스를 상속한 class의 인스턴스를 생성한 후
		// 			이 인스턴스의 start() 메서드를 호출한다.
		MyThread1 th1 = new MyThread1();
		th1.start();

		// 방법 2 : Runnable 인터페이스를 구현한 class의 인스턴스를 생성한 후
		// 이 인스턴스를 Thread 객체의 인스턴스를 생성할 때 생성자의
		// 매개변수로 넘겨준다.
		// 이 때 생성된 Thread 객체의 인스턴스의 start() 메서드를 호출한다.
		MyThread2 r1 = new MyThread2();
		Thread th2 = new Thread(r1);
		th2.start();
		
		// 방법 3 : 익명 클래스를 이용하는 방법
		// Runnable 인터페이스를 구현한 익명클래스를 Thread 인스턴스를
		// 생성할 때 매개변수로 넘겨준다.
		Thread th3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i <= 8; i++) {
					for (int j = 1; j <= 25; j++) {
						System.out.print("@");

						try {
							// Thread.sleep(시간) => 주어진 시간동안 작업을 잠시 멈춤.
							// 시간은 밀리세컨드 단위를 사용한다.
							// 즉, 1000은 1초를 의미한다.
							Thread.sleep(25);
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					}
				}	
			}
		}); th3.start();

	}
}

class MyThread1 extends Thread {
	@Override
	public void run() { // 각각의 스레드에서 run()메서드가 메인스레드 역활을 함.
		for (int i = 0; i <= 8; i++) {
			System.out.println();
			for (int j = 1; j <= 25; j++) {
				System.out.print("*");

				try {
					// Thread.sleep(시간) => 주어진 시간동안 작업을 잠시 멈춤.
					// 시간은 밀리세컨드 단위를 사용한다.
					// 즉, 1000은 1초를 의미한다.
					Thread.sleep(25);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}

class MyThread2 implements Runnable {
	@Override
	public void run() { // 각각의 스레드에서 run()메서드가 메인스레드 역활을 함.
		for (int i = 0; i <= 8; i++) {
			for (int j = 1; j <= 25; j++) {
				System.out.print("$");

				try {
					// Thread.sleep(시간) => 주어진 시간동안 작업을 잠시 멈춤.
					// 시간은 밀리세컨드 단위를 사용한다.
					// 즉, 1000은 1초를 의미한다.
					Thread.sleep(25);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
