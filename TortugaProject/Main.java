package TortugaProject;

import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        InitialConnect connect = new InitialConnect();

        String linkToPage = connect.start();
        String userAgent = connect.getUserAgent();
        Map<String, String> cookies = connect.getCookies();
        String linkToNextPage = null;
        List<Product> allProduct = new ArrayList<>();

//        System.out.println(linkToPage);
        ConnectToPage connectToPageGoods = new ConnectToPage();
        Document docGoods = connectToPageGoods.connectToPage(linkToPage, cookies, userAgent);

        ParsPage parsPage = new ParsPage();
        ArrayList<Product> productOnePage =  parsPage.parsPageGoods(docGoods);
        allProduct.addAll(productOnePage);

        LogoutFromSite.linkToLogout(docGoods);
        LogoutFromSite.logout(cookies, userAgent);



/*//        Loop all pages with products
        linkToNextPage = parsPage.parsLinkToNextPage(docGoods);
        int counterLoop = 0;
        do {
            System.out.println(linkToNextPage);
            connectToPageGoods = new ConnectToPage();
            docGoods = connectToPageGoods.connectToPage(linkToNextPage, cookies, userAgent);

            parsPage = new ParsPage();
            productOnePage = parsPage.parsPageGoods(docGoods);
            allProduct.addAll(productOnePage);

            linkToNextPage = parsPage.parsLinkToNextPage(docGoods);
            Thread.sleep(4000);
            counterLoop += 1;
            System.out.println(counterLoop);
        } while (linkToNextPage != null && counterLoop <= 5);*/

/*//Print all products
        for (int i = 0; i < allProduct.size(); i++){
            System.out.println(allProduct.get(i));

        }*/





    }
}
