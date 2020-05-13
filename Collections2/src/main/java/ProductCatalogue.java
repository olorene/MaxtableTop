import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ProductCatalogue implements Iterable<Product>
{
//    private Set<Product> products = new HashSet<>();
    private Set<Product> products = new TreeSet<>();

    public void isSuppliedBy(Supplier supplier)
    {
        products.addAll(supplier.products());
    }

    public Iterator<Product> iterator()
    {
        return products.iterator();
    }
}