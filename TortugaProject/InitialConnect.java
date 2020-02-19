package TortugaProject;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class InitialConnect {
    private Map<String, String> cookies;
    private Connection.Response response;
    private String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/44.0.2403.157 Safari/537.36";
    private String login;
    private String password;
    private String url;
//    private String url = "https://tortuga-gamestable.top/admin/";

    public Map<String, String> getCookies() {
        return cookies;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    private void setAcauntParameters() {
        try (FileInputStream fileProperties = new FileInputStream("C:\\\\java\\maxtabletop\\maxtabletop.properties")) {
            Properties pros = new Properties();
            pros.load(fileProperties);
            this.login = pros.getProperty("user");
            this.password = pros.getProperty("password");
            this.url = pros.getProperty("url");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Select menu "Товары"
    private String selectMenuGoods(Document doc){
        String linkToPageGoods = "";
            System.out.println(doc.body());
        Element menu = doc.getElementById("menu").getElementById("menu-catalog");
//            System.out.println(menu.html());
//            System.out.println("================================");
        Elements liList = menu.getElementsByTag("li");

        for (Element e : liList) {
            if (e.text().equals("Товари") ) {
//                    System.out.println(e.text());
                Elements linkGoods = e.select("a[href]");
                for (Element link : linkGoods) {
//                    System.out.println(link.attr("abs:href")/*+ " " + link.text()*/);
                    linkToPageGoods = link.attr("abs:href");
                    break;
                }
            }
        }

        return linkToPageGoods;
    }

    public String start() {
        Document doc = null;
//        InitialConnect connectToTortuga = new InitialConnect();
        this.setAcauntParameters();
//        System.out.println(connectToTortuga.getLogin() + " " + connectToTortuga.getPassword());
//        System.out.println(login + " " + password);


        try {
//            String token = "";
            //grab first page with login field
            response = Jsoup.connect(url)
                    .referrer("http://www.google.com.ua/")
                    .userAgent(userAgent)
                    .timeout(10 * 1000)
                    .execute();
            this.cookies = response.cookies();

            Connection.Response homePage = Jsoup.connect(url)
                    .referrer("http://www.google.com.ua/")
                    .data("username", login)
                    .data("password", password)
                    .userAgent(userAgent)
                    .timeout(10 * 1000)
                    .cookies(cookies)
                    .method(Connection.Method.POST)
//                    .followRedirects(true)
                    .execute();

            doc = homePage.parse();
            // Print for DEBUG
//            Print title of page
/*            String title = doc.title();
            System.out.println(title);*/
//            System.out.println(doc.body());

        } catch (Exception ex) {
            System.out.println("InitialConnect.start" + ex.getMessage());
        }
        String linkToPage = selectMenuGoods(doc);
//        System.out.println(linkToPage);

        return linkToPage;
    }
}
