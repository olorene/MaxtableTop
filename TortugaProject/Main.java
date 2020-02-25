package TortugaProject;

import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        InitialConnect connect = new InitialConnect();
        List<Product> allProduct = new ArrayList<>();
        String linkToNextPage = null;
        String pathOutFileProduct = "D:\\Data\\Tortuga\\CatalogMaxTableTop.csv";

//        Initial connection
        String linkToPage = connect.start();
        String userAgent = connect.getUserAgent();
        Map<String, String> cookies = connect.getCookies();
//        System.out.println(linkToPage);

//        Work connection
        ConnectToPage connectToPageGoods = new ConnectToPage();
        Document docGoods = connectToPageGoods.connectToPage(linkToPage, cookies, userAgent);

//        Pars page with products and find next link to page
        ParsPage parsPage = new ParsPage();
        ArrayList<Product> productOnePage =  parsPage.parsPageGoods(docGoods);
        allProduct.addAll(productOnePage);
        linkToNextPage = parsPage.parsLinkToNextPage(docGoods);
        System.out.println(linkToNextPage);
        Thread.sleep(4000);

        for (; linkToNextPage != null; ) {
            docGoods = connectToPageGoods.connectToPage(linkToNextPage, cookies, userAgent);
            productOnePage =  parsPage.parsPageGoods(docGoods);
            allProduct.addAll(productOnePage);
            linkToNextPage = parsPage.parsLinkToNextPage(docGoods);
            System.out.println(linkToNextPage);
            Thread.sleep(4000);

        }

//        Write header of table
        FileProcessing file = new FileProcessing();
        Product product = new Product();
        String lineForWrite = product.headerProduct() + "\n";
        file.writeProductToFile(pathOutFileProduct, lineForWrite);

        String garbage = ";Найменування Товара;Модель;Category;Кількість;Статус;Ціна на сайті;";
        for (int i = 0; i < allProduct.size(); i++) {
            if (!(allProduct.get(i).productForOutput().equals(garbage))) {
//                System.out.println(allProduct.get(i).productForOutput());
                lineForWrite = allProduct.get(i).productForOutput() + "\n";
                file.writeProductToFile(pathOutFileProduct, lineForWrite);
            }
        }





        LogoutFromSite.logout(cookies, userAgent, docGoods);



/*//Print all products
        for (int i = 0; i < allProduct.size(); i++){
            System.out.println(allProduct.get(i));

        }
        System.out.println("======================================= 0938275934768");*/
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






    }
}
