package org.Rakesh;


import org.json.JSONObject;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
      String urlString = "https://api.chucknorris.io/jokes/random";
      URL url;
        try {
            url= new URL(urlString);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        HttpURLConnection connection;
        int responseCode;
        try {
            connection = (HttpURLConnection) url.openConnection();
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(responseCode== 200){
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String ReadLine = null;
            while((ReadLine= bf.readLine())!=null){
                sb.append(ReadLine);
            }
            bf.close();
            JSONObject object = new JSONObject(sb.toString());
            System.out.println(object.toString());

        }else{
            System.out.println("Invalid url");
        }


    }
}