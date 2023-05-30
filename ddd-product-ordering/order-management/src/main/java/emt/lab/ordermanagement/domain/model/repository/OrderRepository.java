package emt.lab.ordermanagement.domain.model.repository;

import emt.lab.ordermanagement.domain.model.Order;
import emt.lab.ordermanagement.domain.model.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
}

