package emt.lab.productcatalog.services.forms;

import emt.lab.productcatalog.domain.models.valueobjects.Quantity;
import emtlab.sharedkernel.domain.base.financial.Money;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductForm {
    private String productName;
    private Money price;
    private int sales;

//    @NotNull
//    private String name;
//    @NotNull
//    private Quantity quantity;
//    @NotNull
//    private Money price;
}
