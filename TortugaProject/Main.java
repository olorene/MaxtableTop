package TortugaProject;

import org.jsoup.nodes.Document;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InitialConnect connect = new InitialConnect();

        String linkToPage = connect.start();
        String userAgent = connect.getUserAgent();
        Map<String, String> cookies = connect.getCookies();
        String linkToNextPage = null;

        System.out.println(linkToPage);
        ConnectToPage connectToPageGoods = new ConnectToPage();
        Document docGoods = connectToPageGoods.connectToPage(linkToPage, cookies, userAgent);

        ParsPage parsPage = new ParsPage();
        parsPage.parsPageGoods(docGoods);

        linkToNextPage = parsPage.parsLinkToNextPage(docGoods);
        System.out.println(linkToNextPage);

/*        do {
            System.out.println(linkToPage);
            ConnectToPage connectToPageGoods = new ConnectToPage();
            Document docGoods = connectToPageGoods.connectToPage(linkToPage, cookies, userAgent);

            ParsPage parsPage = new ParsPage();
            parsPage.parsPageGoods(docGoods);

            linkToNextPage = parsPage.parsLinkToNextPage(docGoods);
            linkToPage = linkToNextPage;

        } while (linkToNextPage != null);*/



    }
}
