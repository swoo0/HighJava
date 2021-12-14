package Thread.kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;

/*
    컴퓨터와 가위 바위 보를 진행 하는 프로그램을 작성하시오.
   
    컴퓨터의 가위 바위 보는 난수를 이용하여 구하고
    사용자의 가위 바로 보는 showInputdialog()메서드를 이용하여 입력받는다.
    
    입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
    5초 안에 입력이 없으면 게임을 진 것으로 처리한다.
    
    5초 안에 입력이 완료 되면 승패를 출력한다.
   
    결과 예시)
    	==== 결 과 ====
    	 컴퓨터 : 가위
    	 당  신 : 바위
    	 결  과 : 당신이 이겼습니다.
 */
public class T07_ThreadGame {

	public static boolean inputCheck = false;
	public static String result = "";
	
	
	public static void main(String[] args) {
		new T07_ThreadGame().Game();
		
	}	
	
	public void Game() {

		Random random = new Random();
	
		String[] ai = { "가위", "바위", "보" };
		int i = random.nextInt(3);
		
		Thread count = new Count();
		count.start();
		
		String gamer = JOptionPane.showInputDialog("가위 바위 보를 입력하세요.");
		
		T07_ThreadGame.inputCheck = true;
				
		if(gamer.equals(ai[i])) {
			result = "무승부";
		} else if (gamer.equals("가위") && ai[i].equals("보")
			|| gamer.equals("바위") && ai[i].equals("가위")
			|| gamer.equals("보") && ai[i].equals("바위")) {
			result = "게이머 승리";
		} else {
			result = "컴퓨터 승리!";
		}
		
		System.out.println("==== 결 과 ====");
		System.out.println("컴퓨터 : " + ai[i]);
		System.out.println("게이머 : " + gamer);
		System.out.println("결  과 : " + result);		
	}
}
	

class Count extends Thread {
	@Override
	public void run() {

		for (int i = 5; i >= 1; i--) {
			if (T07_ThreadGame.inputCheck == true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("5초가 경과 되어 패배한 것으로 간주 합니다.");
		System.exit(0);
	}
}
