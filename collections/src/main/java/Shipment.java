import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Shipment implements Iterable<Product> {
    private static final int LIGHT_VAN_MAX_WEIGHT = 20;

    private final List<Product> products = new ArrayList<Product>();

    public void add(Product product) {
        products.add(product);
    }

    public void replace(Product oldProduct, Product newProduct) {
        // TODO
    }

    public void repare() {
        // TODO
    }

    public List<Product> getHeavyVanProducts() { return null; }

    public List<Product> getLightVanProducts() { return null; }

    public Iterator<Product> iterator() { return products.iterator(); }

}
