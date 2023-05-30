package emt.lab.productcatalog.services;

import emt.lab.productcatalog.domain.models.Perfume;
import emt.lab.productcatalog.domain.models.ProductId;
import emt.lab.productcatalog.domain.models.valueobjects.Quantity;
import emt.lab.productcatalog.services.forms.ProductForm;

import java.util.List;

public interface PerfumeService{
    Perfume findById(ProductId id);
    Perfume createProduct(ProductForm form);
    Perfume orderItemCreated(ProductId productId, int quantity);
    Perfume orderItemRemoved(ProductId productId, int quantity);
    List<Perfume> getAll();

}
