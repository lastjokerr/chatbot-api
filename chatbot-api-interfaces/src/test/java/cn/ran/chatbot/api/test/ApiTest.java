package cn.ran.chatbot.api.test;




import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

public class ApiTest {
        @Test
        public void query_unanswered_questions() throws IOException {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();

            HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885428118451/topics?scope=unanswered_questions&count=20");

            get.addHeader("Cookie",
                    "zsxq_access_token=79DB7409-0E29-CEF5-0B11-69CC806133B8_29FC2D51966C22FB; abtest_env=product; zsxqsessionid=ed4fdb2130704256e59a30a63d9e5c3c; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812544152241882%22%2C%22first_id%22%3A%22187c0e40414273-088f7c860143a28-7e57547d-2073600-187c0e404161404%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg3YzBlNDA0MTQyNzMtMDg4ZjdjODYwMTQzYTI4LTdlNTc1NDdkLTIwNzM2MDAtMTg3YzBlNDA0MTYxNDA0IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiODEyNTQ0MTUyMjQxODgyIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812544152241882%22%7D%2C%22%24device_id%22%3A%22187c0e40414273-088f7c860143a28-7e57547d-2073600-187c0e404161404%22%7D");
            get.addHeader("Content-Type","application/json; charset=UTF-8");

            CloseableHttpResponse response = httpClient.execute(get);
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
            }else {
                System.out.println(response.getStatusLine().getStatusCode());
            }
        }


        @Test
        public void answer() throws IOException {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();

            HttpPost httpPost = new HttpPost("url");
            httpPost.addHeader("Cookie",
                    "zsxq_access_token=79DB7409-0E29-CEF5-0B11-69CC806133B8_29FC2D51966C22FB; abtest_env=product; zsxqsessionid=ed4fdb2130704256e59a30a63d9e5c3c; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812544152241882%22%2C%22first_id%22%3A%22187c0e40414273-088f7c860143a28-7e57547d-2073600-187c0e404161404%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg3YzBlNDA0MTQyNzMtMDg4ZjdjODYwMTQzYTI4LTdlNTc1NDdkLTIwNzM2MDAtMTg3YzBlNDA0MTYxNDA0IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiODEyNTQ0MTUyMjQxODgyIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812544152241882%22%7D%2C%22%24device_id%22%3A%22187c0e40414273-088f7c860143a28-7e57547d-2073600-187c0e404161404%22%7D");
            httpPost.addHeader("Content-Type","application/json; charset=UTF-8");

            String paramJson = "auswer";
            StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "utf-8"));
            httpPost.setEntity(stringEntity);

            CloseableHttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String res = EntityUtils.toString(response.getEntity());
                System.out.println(res);
            }else {
                System.out.println(response.getStatusLine().getStatusCode());
            }
        }

}
