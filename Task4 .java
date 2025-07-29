import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class WebScraper {
    public static void main(String[] args) {
        String url = "https://webscraper.io/test-sites/e-commerce/static/computers/laptops";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements items = doc.select(".thumbnail");

            FileWriter csv = new FileWriter("products.csv");
            csv.append("Name,Price,Rating\n");

            for (Element item : items) {
                String name = item.select(".title").text();
                String price = item.select(".price").text();
                String rating = item.select(".ratings").select("p[data-rating]").attr("data-rating");

                csv.append(name).append(",").append(price).append(",").append(rating).append("\n");
            }
            csv.flush();
            csv.close();
            System.out.println("Data saved to products.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
