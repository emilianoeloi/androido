package domain.company.vaisabrina;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by emiliano on 7/20/17.
 */

public class WebClient {
    String serverUrl;
    public WebClient(String url) {
        serverUrl = url;
    }
    public String post(String json) {
        try {
            URL url = new URL(serverUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            PrintStream saida = new PrintStream(conn.getOutputStream());
            saida.println(json);
            conn.connect();
            return new Scanner(conn.getInputStream()).next();
        } catch(MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
