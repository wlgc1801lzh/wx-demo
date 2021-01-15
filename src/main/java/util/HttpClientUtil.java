package util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * HTTP API工具类
 *
 * @author hui
 * @date 2021-01-10 16:23:36
 */
public class HttpClientUtil {

    /**
     * 发起一个GET请求, 返回数据是以JSON格式返回
     *
     * @param url API地址
     * @return JSON字符串
     */
    public static String doGet(String url) {
        String data = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response;
        try {
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                data = EntityUtils.toString(entity, "UTF-8");
                System.out.println(data);
            }
            httpGet.releaseConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
