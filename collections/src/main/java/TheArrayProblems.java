import java.util.Arrays;

public class TheArrayProblems {
    public static void main(String[] args) {
        Product window = new Product("Window", 5);
        Product door = new Product("Door", 10);


        // Create
        Product[] products = {window, door};

        // Print
        System.out.println("products[]: " + products);
        System.out.println("Arrays.toString(products): " + Arrays.toString(products));

        // Add
        Product floorPanel= new Product("Floor panel", 1);
        products = add(floorPanel, products);

        // Duplicate
        products = add(floorPanel, products);
        System.out.println("Arrays.toString(products): " + Arrays.toString(products));



    }

    private static Product[] add(Product product, Product[] array) {
        int length = array.length;
        Product[] newArray = Arrays.copyOf(array, length + 1);
        newArray[length] = product;

        return newArray;
    }
}


