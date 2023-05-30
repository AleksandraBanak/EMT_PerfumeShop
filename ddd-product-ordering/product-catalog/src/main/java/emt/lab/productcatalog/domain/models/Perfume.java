package emt.lab.productcatalog.domain.models;

import emt.lab.productcatalog.domain.models.valueobjects.Quantity;
import emtlab.sharedkernel.domain.base.AbstractEntity;
import emtlab.sharedkernel.domain.base.financial.Money;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.Objects;

@Entity
@Table(name = "perfume")
@Getter
public class Perfume extends AbstractEntity<ProductId> {
////    private String name;
////    private Quantity quantity;
////    private Money price;
//    private String name;
//    private Quantity quantity;
//    private Money price;
//
//    protected Perfume() {
//        super(ProductId.randomId(ProductId.class));
//    }
//
//    public static Perfume build(String productName,Quantity quantity, Money price) {
//        Perfume p = new Perfume();
//        p.price = price;
//        p.name = productName;
//        p.quantity = quantity;
//        return p;
//    }
////    public Product(String name, Quantity quantity, Money price) {
////        super(DomainObjectId.randomId(ProductId.class));
////        this.name = name;
////        this.quantity = quantity;
////        this.price = price;
////    }
//
//    public void updateProduct(String name, Quantity quantity, Money price) {
//        this.name = name;
//        this.quantity = quantity;
//        this.price = price;
//    }
//    public void addQuantity(Quantity quantity) {
//        quantity = quantity.add(quantity.getQuantity());
//    }
//    public void subtractQuantity(Quantity quantity) {
//        quantity = quantity.subtract(quantity.getQuantity());
//    }
//    public void addQuantity() {
//        quantity = quantity.add();
//    }
//    public void subtractQuantity() {
//        quantity = quantity.subtract();
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Perfume product = (Perfume) o;
//        return Objects.equals(name, product.name) && Objects.equals(quantity, product.quantity) && Objects.equals(price, product.price);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), name, quantity, price);
//    }
    private String name;

    private int sales = 0;

    private Money price;

    protected Perfume() {
        super(ProductId.randomId(ProductId.class));
    }

    public static Perfume build(String productName, Money price, int sales) {
        Perfume p = new Perfume();
        p.price = price;
        p.name = productName;
        p.sales = sales;
        return p;
    }

    public void addSales(int qty) {
        this.sales = this.sales - qty;
    }

    public void removeSales(int qty) {
        this.sales -= qty;
    }


}
