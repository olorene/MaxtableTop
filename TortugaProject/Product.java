package TortugaProject;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
/*                System.out.println("0 " + cols.get(0).text());
                System.out.println("1 " + cols.get(1).select("img").attr("abs:src")); //Picture

                System.out.println("2 " + cols.get(2).text()); //Name
                System.out.println("3 " + cols.get(3).text()); //Position code
                System.out.println("4 " + cols.get(4).text()); //Prise
                System.out.println("5 " + cols.get(5).text()); //Catalog
                System.out.println("6 " + cols.get(6).text()); //Quantity in stock
                System.out.println("7 " + cols.get(7).text()); //State position*/

    private String picture;
    private String name;
    private String positionCode;
    private String catalog;
    private String quantityInStock;
    private String statePosition;
    private String price;

    public void setPicture(String picture) {
        this.picture = picture.trim();
    }

    public void setName(String name) {
        this.name = name;
    }

        public void setPositionCode(String positionCode) {
            this.positionCode = positionCode;
        }

        public void setPrice(String aPrice) {
            this.price = aPrice.trim();
        }

        public void setCatalog(String catalog) {
            this.catalog = catalog.trim();
        }

        public void setQuantityInStock(String quantityInStock) {
            this.quantityInStock = quantityInStock.trim();
        }

        public void setStatePosition(String statePosition) {
            this.statePosition = statePosition.trim();
        }

    @Override
    public String toString() {
        return "Product{" +
                "picture='" + picture + '\'' +
                ", name='" + name + '\'' +
                ", positionCode='" + positionCode + '\'' +
                ", catalog='" + catalog + '\'' +
                ", quantityInStock='" + quantityInStock + '\'' +
                ", statePosition='" + statePosition + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
