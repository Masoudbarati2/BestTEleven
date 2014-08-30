package com.example.android.navigationdrawerexample;

import java.io.BufferedReader;
import java.io.IOException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

import android.content.Context;
import android.os.AsyncTask;

public class Httpres extends AsyncTask<Void, Void, String>
{

	private Context con;
	private static String server_add ;//= "http://192.168.56.1:5000/todo/api/v1.0/....../?teamName="+tnam+"&userName="+unam+"&phone="+pnum;
	private static String param;

	public Httpres(Context cn, String serverAddress,String params) {
		// TODO Auto-generated constructor stub
		con = cn;
		server_add = serverAddress;
		param = params;
	}


	public void setContext(Context context)
	{
		con = context;
	}

	
	@Override
	public String doInBackground(Void... params) 
	{
      /*  HttpResponse response = null;
        InputStream in = null;
        String line = null;
		try 
		{
			response = new DefaultHttpClient().execute(new HttpPost());//new HttpGet(server_add));
			in = response.getEntity().getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	        StringBuilder str = new StringBuilder();
	        while((line = reader.readLine()) != null)
			    str.append(line);
	        in.close();
	      //  destory();
	        return str.toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		//	destory();
			return "";
		}*/
		BufferedReader inBuffer = null;

        String result = "fail";
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost request = new HttpPost(server_add);
            StringEntity se = new StringEntity(param);
            se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            request.setEntity(se);//formEntity);
            httpClient.execute(request);
                    result="got it";

        } catch(Exception e) {
            
            result = e.getMessage();
        } finally {
            if (inBuffer != null) {
                try {
                    inBuffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  result;
	}
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
	}

}
