import org.junit.Test;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

public class ProductCatalogueTest {
    Supplier bobs = new ProductFixtures().bobs;
    Supplier kates = new ProductFixtures().kates;

    Product door = ProductFixtures.door;
    Product floorPanel = ProductFixtures.floorPanel;


    @Test
    public void shouldOnlyHoldUniqProducts() throws Exception {
        ProductCatalogue catalogue = new ProductCatalogue();

        catalogue.isSuppliedBy(bobs);
        catalogue.isSuppliedBy(kates);

        assertThat(catalogue, containsInAnyOrder(door, floorPanel));
    }
}
