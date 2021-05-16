package HttpServer.HttpClient;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpClient {
	
	private static String url = "http://localhost:8801";
	private static String url2 = "http://localhost:8802";
	private static String url3 = "http://localhost:8803";
	
	public static void main(String[] args) throws IOException{
		
        String text = HttpClient.getUrl(url);
        // String text = HttpClient.getUrl(url2);
 		// String text = HttpClient.getUrl(url3);
        System.out.println("response: \n" + text);
        
	}
	
	public static CloseableHttpClient httpclient = HttpClients.createDefault();
	
	/**
	 * get调用
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String getUrl(String url) throws IOException {
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpget);
            HttpEntity entity1 = response.getEntity();
            return EntityUtils.toString(entity1, "UTF-8");
        } finally {
            if (null != response) {
            	response.close();
            }
        }
	}
	/**
	 * post调用
	 * @param url
	 * @param json
	 * @param headers
	 * @return
	 * @throws IOException
	 */
    // GET 调用
    public static String postAsJSON(String url, String json, Map<String, String> headers) throws IOException {
        //
        // json = URLEncoder.encode(json, "UTF-8");
        //
        HttpPost httpPost = new HttpPost(url);
        Set<String> keySet = headers.keySet();
        for (String name : keySet) {
            httpPost.setHeader(name, headers.get(name));
        }
        final String JSON_TYPE = "application/json;charset=UTF-8";
        httpPost.setHeader(HTTP.CONTENT_TYPE, JSON_TYPE);
        StringEntity entity = new StringEntity(json, "UTF-8");

        httpPost.setEntity(entity);

        CloseableHttpResponse response1 = null;
        try {
            response1 = httpclient.execute(httpPost);
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            return EntityUtils.toString(entity1, "UTF-8");
        } finally {
            if (null != response1) {
                response1.close();
            }
        }
    }
}
