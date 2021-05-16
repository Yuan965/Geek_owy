package NIO;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author owy
 *
 *单线程的socket程序
 */
public class HttpServer01 {
	
	public static void main(String[] args) throws IOException {
		ServerSocket socketServe = new ServerSocket(8801);
		while(true) {
			try {
				Socket socket = socketServe.accept();
				service(socket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void service(Socket socket) {
		try {
			PrintWriter printwrite = new PrintWriter(socket.getOutputStream(),true);
			printwrite.println("HTTP/1.0 200 OK");
			printwrite.println("Content-Type:text/html;charset=utf-8");
			String body = "hello,nio1";
			printwrite.println("Content-Length:" + body.getBytes().length);
			printwrite.println();
			printwrite.write(body);
			printwrite.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
