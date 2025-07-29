import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleScraper {
    public static void main(String[] args) {
        String url = "https://webscraper.io/test-sites/e-commerce/static/computers/laptops";

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine).append("\n");
            }
            in.close();

            System.out.println("Fetched HTML Content:");
            System.out.println(response.toString());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
