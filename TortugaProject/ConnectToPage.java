package TortugaProject;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

public class ConnectToPage {
    public Document connectToPage(String link, Map<String, String> cookies, String userAgent) {
        Document doc = null;

        try {
            Connection.Response homePage = Jsoup.connect(link)
                    .userAgent(userAgent)
                    .timeout(10 * 1000)
                    .cookies(cookies)
                    .method(Connection.Method.POST)
                    .execute();

            doc = homePage.parse();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return doc;
    }
}
