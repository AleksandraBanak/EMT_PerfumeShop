package emt.lab.productcatalog.services.impl;

import emt.lab.productcatalog.domain.models.Perfume;
import emt.lab.productcatalog.domain.models.ProductId;
import emt.lab.productcatalog.domain.models.exceptions.PerfumeNotFoundException;
import emt.lab.productcatalog.domain.models.repository.ProductRepository;
import emt.lab.productcatalog.domain.models.valueobjects.Quantity;
import emt.lab.productcatalog.services.PerfumeService;
import emt.lab.productcatalog.services.forms.ProductForm;
import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PerfumeServiceImpl implements PerfumeService {
    private final ProductRepository productRepository;
    private final Validator validator;

    @Override
    public Perfume findById(ProductId id) {
        return productRepository.findById(id).orElseThrow(PerfumeNotFoundException::new);
    }

    @Override
    public Perfume createProduct(ProductForm form) {
        var violations = validator.validate(form);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Invalid product data");
        }
        var newProduct = Perfume.build(form.getProductName(), form.getPrice(), form.getSales());
        return productRepository.saveAndFlush(newProduct);
    }

    @Override
    public Perfume orderItemCreated(ProductId productId, int quantity) {
        Perfume p = productRepository.findById(productId).orElseThrow(PerfumeNotFoundException::new);
        p.addSales(quantity);
        productRepository.saveAndFlush(p);
        return p;

    }

    @Override
    public Perfume orderItemRemoved(ProductId productId, int quantity) {
        Perfume p = productRepository.findById(productId).orElseThrow(PerfumeNotFoundException::new);
        p.removeSales(quantity);
        productRepository.saveAndFlush(p);
        return p;

    }

    @Override
    public List<Perfume> getAll() {
        return productRepository.findAll();
    }
//    private final ProductRepository productRepository;
//    private final Validator validator;
//
//    @Override
//    public Perfume findById(ProductId id) {
//        return productRepository.findById(id).orElseThrow(PerfumeNotFoundException::new);
//    }
//
//    @Override
//    public Perfume createProduct(ProductForm form) {
//        var violations = validator.validate(form);
//        if (!violations.isEmpty()) {
//            throw new IllegalArgumentException("Invalid product data");
//        }
//        var newProduct = Perfume.build(form.getName(), form.getQuantity(), form.getPrice());
//        return productRepository.saveAndFlush(newProduct);
//    }
//
//    @Override
//    public Perfume orderItemCreated(ProductId productId, Quantity quantity) {
//        Perfume p = productRepository.findById(productId).orElseThrow(PerfumeNotFoundException::new);
//        p.addQuantity(quantity);
//        productRepository.saveAndFlush(p);
//        return p;
//
//    }
//
//    @Override
//    public Perfume orderItemRemoved(ProductId productId, Quantity quantity) {
//        Perfume p = productRepository.findById(productId).orElseThrow(PerfumeNotFoundException::new);
//        p.subtractQuantity(quantity);
//        productRepository.saveAndFlush(p);
//        return p;
//
//    }
//
//    @Override
//    public List<Perfume> getAll() {
//        return productRepository.findAll();
//    }
}
