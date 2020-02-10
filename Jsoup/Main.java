package Jsoup;

import org.jsoup.nodes.Document;

public class Main {
    public static void main(String[] args) {
        InitialConnect inCon = new InitialConnect();

        Document doc = inCon.start();
        String result = inCon.parsDoc(doc);
        System.out.println(result);
    }
}
