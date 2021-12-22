package kr.or.ddit.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {
// 서버는 클라이언트가 접속하면 서버 컴퓨터의 D드라이브의 D_Other폴더에 있는
// Tulips.jpg 파일을 클라이언트로 전송한다.
	private ServerSocket server;
	private Socket socket;
	private OutputStream out;
	private FileInputStream fis;
	
	
	public void serverStart() {
		
		try {
			server = new ServerSocket(7777);
			System.out.println("서버 준비 완료...");
			
			while (true) {
				System.out.println("파일 전송 대기중...");
				socket = server.accept();
				
				System.out.println("파일 전송 시작...");
				fis = new FileInputStream("D:/D_Other/호랭이.jfif");
				out = socket.getOutputStream();
				
				BufferedInputStream bis = new BufferedInputStream(fis);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				
				int c = 0;
				
				while ((c = bis.read()) != -1) {
					bos.write(c);
				}
				
				bis.close();
				bos.close();
				
				System.out.println("파일 전송 완료...");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {fis.close();} catch (IOException e2) {}
			}
			if (out != null) {
				try {out.close();} catch (IOException e2) {}
			}
			if (socket != null) {
				try {socket.close();} catch (IOException e2) {}
			}
			if (server != null) {
				try {server.close();} catch (IOException e2) {}
			}
		}
	}
	
	public static void main(String[] args) {
		new TcpFileServer().serverStart();
	}
}
