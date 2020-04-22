import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionsConcepts {
    public static void main(String[] args) {
        Product door = new Product("Wooden Door", 35);
        Product floorPanel= new Product("Floor Panel", 25);
        Product window = new Product("Glass Window", 10);

        Collection<Product> products = new ArrayList<Product>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);

        System.out.println(products);

        // Iteration concept
        System.out.println("\nIteration concept");

        final Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()) {

            Product product = productIterator.next();
            if (product.getWeight() > 20) {
                System.out.println(product);
            } else {
//                productIterator.remove();
            }

        }

        // Use snippet iter
        System.out.println("===========");
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("===========");
        System.out.println(products.size());
        System.out.println(products.isEmpty());
        System.out.println(products.contains(window));
        System.out.println(products.contains(door));

        System.out.println("===========");
        Collection<Product> otherProduct = new ArrayList<Product>();
        otherProduct.add(window);
        otherProduct.add(door);

/*
        products.removeAll(otherProduct);
        System.out.println(products);
*/
/*
        System.out.println("==================");
        System.out.println(products);
        for (Product product : products) {
            if (product.getWeight() > 20) {
//                System.out.println(product);
                products.add(product);
            } else {
//                products.remove(product);
            }
        }
        System.out.println(products);
        System.out.println("==================");
*/
        final Iterator<Product> otherIterator = products.iterator();
        while (otherIterator.hasNext()) {
            Product product = otherIterator.next();
            System.out.println(product);
//            products.add(window);

        }


    }
}
