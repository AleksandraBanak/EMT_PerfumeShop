package emt.lab.ordermanagement.domain.model.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import emtlab.sharedkernel.domain.base.ValueObject;
import emtlab.sharedkernel.domain.base.financial.Currency;
import emtlab.sharedkernel.domain.base.financial.Money;
import lombok.Getter;

@Getter
public class Product implements ValueObject {

    private final ProductId id;
    private final String name;
    private final Money price;
    private final int sales;

    private Product() {
        this.id = ProductId.randomId(ProductId.class);
        this.name = "";
        this.price = Money.valueOf(Currency.MKD, 0);
        this.sales = 0;
    }
    @JsonCreator
    public Product(@JsonProperty("id") ProductId id,
                   @JsonProperty("name") String name,
                   @JsonProperty("price") Money price,
                   @JsonProperty("sales") int sales ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = sales;
    }

}
