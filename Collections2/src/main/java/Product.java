import java.util.Comparator;
import java.util.Objects;

import static java.util.Comparator.comparing;


class Product {
    public static final Comparator<Product> BY_NAME = comparing(Product::getName);
    public static final Comparator<Product> BY_WEIGHT = comparing(Product::getWeight);


    private final String name;
    private final Integer weight;


    public Product(String name, Integer weight) {

        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public boolean equals(final Object o)
    {
        if (!(o instanceof Product)) return false;

        final Product product = (Product) o;

        return  Objects.equals(weight, product.weight)
                && Objects.equals(name, product.name);
    }

    public int hashCode()
    {
        return Objects.hash(name, weight);
    }
}
