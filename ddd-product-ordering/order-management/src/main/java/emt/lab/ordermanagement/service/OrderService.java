package emt.lab.ordermanagement.service;

import emt.lab.ordermanagement.domain.model.Order;
import emt.lab.ordermanagement.domain.model.OrderId;
import emt.lab.ordermanagement.domain.model.OrderItemId;
import emt.lab.ordermanagement.domain.model.exceptions.OrderIdDoesNotExistException;
import emt.lab.ordermanagement.domain.model.exceptions.OrderItemIdDoesNotExistException;
import emt.lab.ordermanagement.service.forms.OrderForm;
import emt.lab.ordermanagement.service.forms.OrderItemForm;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    OrderId placeOrder(OrderForm orderForm);

    List<Order> findAll();

    Optional<Order> findById(OrderId id);

    void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderIdDoesNotExistException;

    void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderIdDoesNotExistException, OrderItemIdDoesNotExistException;



}

