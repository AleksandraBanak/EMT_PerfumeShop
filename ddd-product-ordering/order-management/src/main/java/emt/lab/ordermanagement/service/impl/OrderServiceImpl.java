package emt.lab.ordermanagement.service.impl;

import emt.lab.ordermanagement.domain.model.Order;
import emt.lab.ordermanagement.domain.model.OrderId;
import emt.lab.ordermanagement.domain.model.OrderItemId;
import emt.lab.ordermanagement.domain.model.exceptions.OrderIdDoesNotExistException;
import emt.lab.ordermanagement.domain.model.exceptions.OrderItemIdDoesNotExistException;
import emt.lab.ordermanagement.domain.model.repository.OrderRepository;
import emt.lab.ordermanagement.service.OrderService;
import emt.lab.ordermanagement.service.forms.OrderForm;
import emt.lab.ordermanagement.service.forms.OrderItemForm;
import emtlab.sharedkernel.domain.base.events.orders.OrderItemCreated;
import emtlab.sharedkernel.infra.DomainEventPublisher;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final DomainEventPublisher domainEventPublisher;
    private final Validator validator;

    @Override
    public OrderId placeOrder(OrderForm orderForm) {
        Objects.requireNonNull(orderForm,"order must not be null.");
        var constraintViolations = validator.validate(orderForm);
        if (constraintViolations.size()>0) {
            throw new ConstraintViolationException("The order form is not valid", constraintViolations);
        }
        var newOrder = orderRepository.saveAndFlush(toDomainObject(orderForm));
        newOrder.getOrderItemList().forEach(item->domainEventPublisher.publish(new OrderItemCreated(item.getProductId().getId(),item.getQuantity())));
        return newOrder.getId();
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(OrderId id) {
        return orderRepository.findById(id);
    }

    @Override
    public void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderIdDoesNotExistException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderIdDoesNotExistException::new);
        order.addItem(orderItemForm.getProduct(),orderItemForm.getQuantity());
        orderRepository.saveAndFlush(order);
        domainEventPublisher.publish(new OrderItemCreated(orderItemForm.getProduct().getId().getId(),orderItemForm.getQuantity()));
    }

    @Override
    public void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderIdDoesNotExistException, OrderItemIdDoesNotExistException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderIdDoesNotExistException::new);
        order.removeItem(orderItemId);
        orderRepository.saveAndFlush(order);
    }

    private Order toDomainObject(OrderForm orderForm) {
        var order = new Order(Instant.now(),orderForm.getCurrency());
        orderForm.getItems().forEach(item->order.addItem(item.getProduct(),item.getQuantity()));
        return order;
    }

}
