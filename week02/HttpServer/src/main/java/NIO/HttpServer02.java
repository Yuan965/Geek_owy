package NIO;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author owy
 *
 *每个请求一个线程
 *不断重复创建线程，销毁线程
 */
public class HttpServer02 {
	
	public static void main(String[] args) throws IOException {
		ServerSocket socketServe = new ServerSocket(8802);
		while(true) {
			try {
				final Socket socket = socketServe.accept();
				new Thread(() -> {
                    service(socket);
                }).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void service(Socket socket) {
		try {
			PrintWriter printwrite = new PrintWriter(socket.getOutputStream(),true);
			printwrite.println("HTTP/1.1 200 OK");
			printwrite.println("Content-Type:text/html;charset=utf-8");
			String body = "hello,nio2";
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
