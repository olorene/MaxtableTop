package Lambda;

import java.util.LinkedList;
import java.util.List;

public class HelloLambda {

    public static void main(String[] args) {
        List<String> strings = new LinkedList<>();
        strings.add("мама");
        strings.add("мыла");
        strings.add("раму");


        strings.forEach(x -> System.out.println(x));
    }
}
