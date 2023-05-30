package emt.lab.productcatalog.xport.rest.events;

import emt.lab.productcatalog.domain.models.Perfume;
import emt.lab.productcatalog.domain.models.ProductId;
import emt.lab.productcatalog.services.PerfumeService;
import emtlab.sharedkernel.domain.base.config.TopicHolder;
import emtlab.sharedkernel.domain.base.events.DomainEvent;
import emtlab.sharedkernel.domain.base.events.orders.OrderItemCreated;
import emtlab.sharedkernel.domain.base.events.orders.OrderItemRemoved;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductEventListener {

    private final PerfumeService productService;

    @KafkaListener(topics= TopicHolder.TOPIC_ORDER_ITEM_CREATED, groupId = "productCatalog")
    public void consumeOrderItemCreatedEvent(String jsonMessage) {
        try {
            OrderItemCreated event = DomainEvent.fromJson(jsonMessage,OrderItemCreated.class);
            productService.orderItemCreated(ProductId.of(event.getProductId()), event.getQuantity());
        } catch (Exception e){

        }

    }

    @KafkaListener(topics= TopicHolder.TOPIC_ORDER_ITEM_REMOVED, groupId = "productCatalog")
    public void consumeOrderItemRemovedEvent(String jsonMessage) {
        try {
            OrderItemRemoved event = DomainEvent.fromJson(jsonMessage,OrderItemRemoved.class);
            productService.orderItemRemoved(ProductId.of(event.getProductId()), event.getQuantity());
        } catch (Exception e){

        }

    }
}


