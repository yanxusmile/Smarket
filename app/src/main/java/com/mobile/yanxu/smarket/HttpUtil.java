package com.mobile.yanxu.smarket;

/**
 * Created by rugangyao on 13/10/2014.
 */
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.apache.http.protocol.HTTP;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.ArrayList;

public class HttpUtil
{
    public String doPost(String url, List<NameValuePair> params)
    {
  /*      HttpPost httpRequest = new HttpPost(url);
        String jsonString = null;

        try
        {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse httpResponse = httpclient.execute(httpRequest);

            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
                jsonString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return jsonString;
*/
        HttpPost httpRequest = new HttpPost(url);
        String strResult = null;

        try
        {
            httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);

            if(httpResponse.getStatusLine().getStatusCode() == 200)
            {
                strResult = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
            }

        }
        catch (UnsupportedEncodingException e)
        {

        }
        catch (ClientProtocolException e)
        {

        }
        catch (IOException e)
        {

        }

        return strResult;
    }
}