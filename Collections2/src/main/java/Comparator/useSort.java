package Comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class useSort {
        private static String[] array1 = {"мама", "мыла", "раму"};
        private static String[] array2 = {"я", "очень", "люблю", "java"};
        private static String[] array3 = {"мир", "труд", "май"};

    public static void main(String[] args) {
        List<String[]> arrays = new ArrayList<>();
        arrays.add(array1);
        arrays.add(array2);
        arrays.add(array3);

        sortByIncrWords(arrays);
        toPrint(arrays);
        System.out.println("=============");
        sortByDecrWords(arrays);
        toPrint(arrays);
        System.out.println("=============");
        sortByIncrWordsLambda(arrays);

//        System.out.println(arrays);
    }

    private static void sortByIncrWordsLambda(List<String[]> arrays) {
        arrays.sort((o1 , o2) -> o1.length - o2.length);
    }

    private static void sortByIncrWords(List<String[]> arrays) {
        arrays.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o2.length - o1.length;
            }
        });
    }

    private static void sortByDecrWords(List<String[]> arrays) {
        arrays.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1.length - o2.length;
            }
        });
    }

    public static void toPrint(List<String[]> array) {
        for (String[] strings : array) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}
