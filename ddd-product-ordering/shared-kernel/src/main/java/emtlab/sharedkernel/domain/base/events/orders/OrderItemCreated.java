package emtlab.sharedkernel.domain.base.events.orders;

import emtlab.sharedkernel.domain.base.config.TopicHolder;
import emtlab.sharedkernel.domain.base.events.DomainEvent;
import lombok.Getter;

@Getter
public class OrderItemCreated extends DomainEvent {

    private String productId;
    private int quantity;

    public OrderItemCreated(String topic) {
        super(TopicHolder.TOPIC_ORDER_ITEM_CREATED);
    }

    public OrderItemCreated(String productId, int quantity) {
        super(TopicHolder.TOPIC_ORDER_ITEM_CREATED);
        this.productId = productId;
        this.quantity = quantity;
    }
}


