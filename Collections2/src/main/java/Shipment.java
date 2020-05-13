import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Shipment implements Iterable<Product> {
    private static final int LIGHT_VAN_MAX_WEIGHT = 20;
    public static final int PRODUCT_NOT_PRESENT = -1;

    private final List<Product> products = new ArrayList<Product>();

    private List<Product> lightVanProducts;
    private List<Product> heavyVanProducts;


    public void add(Product product) {
        products.add(product);
    }

    public void replace(Product oldProduct, Product newProduct) {
        int index = products.indexOf(oldProduct);
        if (index != PRODUCT_NOT_PRESENT) {
            products.set(index, newProduct);
        }
    }

    public void prepare() {
        // sort out list of products by weight
        // Collections.sort(products, Product.BY_WEIGHT);
        products.sort(Product.BY_WEIGHT);

        // find the product index that need the heavy van
        int splitPoint = findSplitPoint();

        // assign views of the product list for heavy and light vans
        lightVanProducts = products.subList(0, splitPoint);
        heavyVanProducts = products.subList(splitPoint, products.size());

    }

    private int findSplitPoint() {
        for (int i = 0; i < products.size(); i++) {
            final Product product = products.get(i);
            if (product.getWeight() > LIGHT_VAN_MAX_WEIGHT) {
                return i;
            }
        }

        return 0;
    }

    public List<Product> getHeavyVanProducts() { return heavyVanProducts; }

    public List<Product> getLightVanProducts() { return lightVanProducts; }

    public Iterator<Product> iterator() { return products.iterator(); }

    @Override
    public String toString() {
        return "Shipment{" +
                "products=" + products +
                '}';
    }
}
