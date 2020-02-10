package Jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class InitialConnect {
    public Document start () {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://maxtable.top/admin/").get();
        } catch (Exception ex) {
            System.out.println("Неудача");
        }
        return doc;
    }

    public String parsDoc(Document doc) {
        Elements allElements = doc.getElementsByTag("body");
        String result = null;

        for (Element element : allElements) {
            result = element.tagName();
        }

        return result;
    }
}
