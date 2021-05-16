package HttpServer.OKHttp;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Hello world!
 *
 */
public class OKHttp 
{
	private static String url = "http://localhost:8801";
	private static String url2 = "http://localhost:8802";
	private static String url3 = "http://localhost:8803";
	
	public static void main( String[] args )
	{
		String text = OKHttp.getUrl(url);
		// String text = OKHttp.getUrl(url2);
		// String text = OKHttp.getUrl(url3);
		System.out.println("response: \n" + text);
	}
	
	// geturl
	public static String getUrl(String url){
		 Request request = new Request.Builder()
		            .url(url)
		            .build();
		 Response response;
		try {
			OkHttpClient okclient = new OkHttpClient();
			response = okclient.newCall(request).execute();
			okclient = null;
			return response.body().string();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
