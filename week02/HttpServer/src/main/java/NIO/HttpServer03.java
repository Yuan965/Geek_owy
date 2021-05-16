package NIO;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author owy
 *
 *创建固定大小的线程池处理请求
 *
 */
public class HttpServer03 {
	
	public static void main(String[] args) throws IOException {
		ExecutorService exc = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 2);
		ServerSocket socketServe = new ServerSocket(8803);
		while(true) {
			try {
				final Socket socket = socketServe.accept();
				exc.execute(() -> service(socket));
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
			String body = "hello,nio3";
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
