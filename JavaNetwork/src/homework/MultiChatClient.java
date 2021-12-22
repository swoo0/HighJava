package homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MultiChatClient {
	Scanner scan = new Scanner(System.in);
	private String nickName; // 대화명

	// 시작
	public void clientStart() {
		// 대화명 입력받기
		System.out.print("대화명 >> ");
		nickName = scan.next();

		Socket socket = null;
		try {
			socket = new Socket("192.168.44.85", 7777);
			System.out.println("서버에 연결되었습니다.");

			// 송신용 스레드 생성
			ClientSender sender = new ClientSender(socket, nickName);
			sender.start();
			
			// 수신용 스레드 생성
			ClientReceiver receiver = new ClientReceiver(socket);
			receiver.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 메시지를 전송하는 Thread 클래스
	class ClientSender extends Thread {
		private DataOutputStream dos;
		private String name;
		private Scanner scan = new Scanner(System.in);

		public ClientSender(Socket socket, String name) {
			this.name = name;

			try {
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				// 시작하자 마자 자신의 대화명을 서버로 전송
				if (dos != null) {
					dos.writeUTF(name);
				}

				while (dos != null) {
					// 키보드로 입력받은 메시지를 서버로 전송
					dos.writeUTF(scan.nextLine());
				}

			} catch (IOException e) {
				e.printStackTrace();

			}
		}

	}

	// 수신용 Thread클래스 정의
	class ClientReceiver extends Thread {
		private DataInputStream dis;

		// 생성자
		public ClientReceiver(Socket socket) {
			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (dis != null) {
				try {
					// 서버로 부터 수신한 메시지 출력하기
					System.out.println(dis.readUTF());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new MultiChatClient().clientStart();
	}
}
