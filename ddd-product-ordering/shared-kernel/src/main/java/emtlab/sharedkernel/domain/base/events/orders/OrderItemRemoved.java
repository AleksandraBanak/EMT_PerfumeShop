package emtlab.sharedkernel.domain.base.events.orders;

import emtlab.sharedkernel.domain.base.config.TopicHolder;
import emtlab.sharedkernel.domain.base.events.DomainEvent;
import lombok.Getter;

@Getter
public class OrderItemRemoved extends DomainEvent {

    private String productId;
    private int quantity;

    public OrderItemRemoved(String topic) {
        super(TopicHolder.TOPIC_ORDER_ITEM_REMOVED);
    }

    public OrderItemRemoved(String topic, String productId, int quantity) {
        super(TopicHolder.TOPIC_ORDER_ITEM_REMOVED);
        this.productId = productId;
        this.quantity = quantity;
    }
}
