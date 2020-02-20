package TortugaProject;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class ParsPage {


    public ArrayList<Product> parsPageGoods(Document docGoods) {
//            Pars page with goods/
            Element table = docGoods.select("table").get(0); //select the first table.
            Elements rows = table.select("tr");
            ArrayList<Product> listProduct = new ArrayList<Product>();

            for (int i = 0; i < rows.size(); i++) { //first row is the col names so skip it.
                Element row = rows.get(i);
                Elements cols = row.select("td");
//                This parameters is empty
//                System.out.println("0 " + cols.get(0).text());
//                System.out.println("1 " + cols.get(1).select("img").attr("abs:src")); //Picture
//
//                System.out.println("2 " + cols.get(2).text()); //Name
//                System.out.println("3 " + cols.get(3).text()); //Position code
//                System.out.println("4 " + cols.get(4).text()); //Prise
//                System.out.println("5 " + cols.get(5).text()); //Catalog
//                System.out.println("6 " + cols.get(6).text()); //Quantity in stock
//                System.out.println("7 " + cols.get(7).text()); //State position
                Product aProduct = new Product();

                aProduct.setPicture(cols.get(1).select("img").attr("abs:src")); //Picture
                aProduct.setName(cols.get(2).text()); //Name
                aProduct.setPositionCode(cols.get(3).text()); //Position code
                aProduct.setPrice(cols.get(4).text()); //Prise
                aProduct.setCatalog(cols.get(5).text()); //Catalog
                aProduct.setQuantityInStock(cols.get(6).text()); //Quantity in stock
                aProduct.setStatePosition(cols.get(7).text()); //State position

                listProduct.add(aProduct);
            }

            return  listProduct;
    }

    public String parsLinkToNextPage(Document docGoods) {
        String linkToNextPage = null;

        Elements listPages = docGoods.getElementsByClass("pagination");
        for (Element e : listPages) {
            Elements linkPage = e.select("a[href]");
            for (Element link : linkPage) {
                linkToNextPage = link.attr("abs:href");
                String textPage = link.text();
                if (textPage.equals(">")){
//                    System.out.println(linkToNextPage + " " + textPage);
//                    linkToNextPage = textPage;
                    break;
                }
                linkToNextPage = null;
            }
        }

        return linkToNextPage;
    }
}
