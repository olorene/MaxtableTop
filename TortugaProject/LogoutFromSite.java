package TortugaProject;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Collection;
import java.util.Map;

public class LogoutFromSite {
    private static String link;

    public static void linkToLogout(Document doc) {
        Elements logout = doc.getElementsByClass("nav pull-right");
        Elements logElement = logout.tagName("li");
        for (Element e : logElement) {
            Elements links = e.select("a[href]");
            for (Element n : links) {
                if (n.text().equals("Вихід")) {
                    link = n.attr("abs:href");
//                    System.out.println(n.attr("abs:href"));
//                    System.out.println("===============================================");
                }
            }
        }
    }

    public static void logout( Map<String, String> cookies, String userAgent, Document document) {
//        System.out.println(document.body());
//        System.out.println("==================================================================================");

        ConnectToPage connectToPage = new ConnectToPage();
        LogoutFromSite.linkToLogout(document);
        Document doc = connectToPage.connectToPage(link, cookies, userAgent);

//        System.out.println(doc.body());

    }
}
