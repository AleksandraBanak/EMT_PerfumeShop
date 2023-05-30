package emt.lab.ordermanagement.domain.model;

import emt.lab.ordermanagement.domain.model.valueobjects.ProductId;
import emtlab.sharedkernel.domain.base.AbstractEntity;
import emtlab.sharedkernel.domain.base.DomainObjectId;
import emtlab.sharedkernel.domain.base.financial.Money;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;

@Entity
@Table(name = "order_item")
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {

    private Money itemPrice;

    @Column(name = "qty", nullable = false)
    private int quantity;

    @AttributeOverride(name = "id", column = @Column(name = "product_id", nullable = false))
    private ProductId productId;

    private OrderItem() {
        super(DomainObjectId.randomId(OrderItemId.class));
    }

    public OrderItem(@NonNull ProductId productId, @NonNull Money itemPrice, int qty) {
        super(DomainObjectId.randomId(OrderItemId.class));
        this.productId = productId;
        this.itemPrice = itemPrice;
        this.quantity = qty;
    }

    public Money subtotal() {
        return itemPrice.multiply(quantity);
    }
}


