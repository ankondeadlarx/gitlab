package core;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class DatabaseIOHandler {
    private static final String BASE_URL = "http://127.0.0.1:8000";
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public DatabaseIOHandler() {
        //
    }

    //This method adds an account with username "Bob" and password "password"
    public void sendMessage(String message){
        try {
            String url = BASE_URL + "/createaccount";
            String data = "username=" + URLEncoder.encode("Bob", StandardCharsets.UTF_8) +
                    "&password=" + URLEncoder.encode("password", StandardCharsets.UTF_8);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(data))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //This method prints the username and password of Bob's account
    public void getMessage(String message){
        String username = "Bob";
        String url = BASE_URL + "/user/" + username;

        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url + "/" + username))
                    .header("Accept", "text/plain")
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response Code: " + response.statusCode());

            if(response.statusCode() == 404){
                System.out.println("Account not found");
                return;
            }

            //Parse response
            String[] parts = response.body().split("&");
            for (String part : parts){
                String[] keyValue = part.split("=");
                if (keyValue.length == 2) {
                    System.out.println(keyValue[0] + ": " + keyValue[1]);
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
