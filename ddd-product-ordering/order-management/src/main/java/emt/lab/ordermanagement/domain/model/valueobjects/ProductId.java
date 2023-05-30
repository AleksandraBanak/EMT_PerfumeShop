package emt.lab.ordermanagement.domain.model.valueobjects;

import emtlab.sharedkernel.domain.base.DomainObjectId;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProductId extends DomainObjectId {

    private ProductId() {
        super(ProductId.randomId(ProductId.class).getId());
    }

    public ProductId(String uuid) {
        super(uuid);
    }
}


