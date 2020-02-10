package TortugaProject;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParsPage {
    public void parsPageGoods(Document docGoods) {
//            Pars page with goods/
            Element table = docGoods.select("table").get(0); //select the first table.
            Elements rows = table.select("tr");
            for (int i = 0; i < rows.size(); i++) { //first row is the col names so skip it.
                Element row = rows.get(i);
                Elements cols = row.select("td");
//                This parameters is empty
                System.out.println("0 " + cols.get(0).text());
                System.out.println("1 " + cols.get(1).select("img").attr("abs:src")); //Picture

                System.out.println("2 " + cols.get(2).text()); //Name
                System.out.println("3 " + cols.get(3).text()); //Position code
                System.out.println("4 " + cols.get(4).text()); //Prise
                System.out.println("5 " + cols.get(5).text()); //Catalog
                System.out.println("6 " + cols.get(6).text()); //Quantity in stock
                System.out.println("7 " + cols.get(7).text()); //State position
            }

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
