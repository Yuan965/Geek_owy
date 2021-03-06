package MyProxyFilter;

import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

public class ProxyFilter implements HttpRequestFilter {


    public static ProxyFilter newInstance() {
        return new ProxyFilter();
    }

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        String uri = fullRequest.uri();
        if (uri.startsWith("/hello")) {
        } else {
            throw new RuntimeException("不支持的uri:" + uri);
        }
        HttpHeaders headers = fullRequest.headers();
        if (headers == null) {
            headers = new DefaultHttpHeaders();
        }
        headers.add("proxy-tag", this.getClass().getSimpleName());
    }
}