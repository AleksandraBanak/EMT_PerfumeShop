package emt.lab.ordermanagement.service.forms;

import emt.lab.ordermanagement.domain.model.valueobjects.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderItemForm {

    @NotNull
    private Product product;

    @Min(1)
    private int quantity = 1;
}

