import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

public class ShipmentTest {

    private Shipment shipment = new Shipment();
    Product window = ProductFixtures.window;
    Product floorPanel = ProductFixtures.floorPanel;
    Product door = ProductFixtures.door;

    @org.junit.Test
    public void shouldAddItems() throws Exception {

        shipment.add(door);
        shipment.add(window);

        assertThat(shipment, contains(door, window));
    }

    @org.junit.Test
    public void shouldReplaceItems() throws Exception {


        shipment.add(door);
        shipment.add(window);

        shipment.replace(door, floorPanel);

        assertThat(shipment, contains(floorPanel, window));
    }

    @org.junit.Test
    public void shouldNotReplaceItems() throws Exception {
        shipment.add(window);
        shipment.replace(door, floorPanel);

        assertThat(shipment, contains(window));
    }

    @org.junit.Test
    public void shouldIdentifyVanRequirements() throws Exception {
        shipment.add(window);
        shipment.add(door);
        shipment.add(floorPanel);

        shipment.prepare();

        assertThat(shipment.getLightVanProducts(), contains(window));
        assertThat(shipment.getHeavyVanProducts(), contains(floorPanel, door));
    }

    @org.junit.Test
    public void repare() {
    }

    @org.junit.Test
    public void getHeavyVanProducts() {
    }

    @org.junit.Test
    public void getLightVanProducts() {
    }
}