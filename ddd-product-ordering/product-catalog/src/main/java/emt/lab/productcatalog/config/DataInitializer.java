package emt.lab.productcatalog.config;

import emt.lab.productcatalog.domain.models.Perfume;
import emt.lab.productcatalog.domain.models.repository.ProductRepository;
import emt.lab.productcatalog.domain.models.valueobjects.Quantity;
import emtlab.sharedkernel.domain.base.financial.Currency;
import emtlab.sharedkernel.domain.base.financial.Money;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final ProductRepository productRepository;

    @PostConstruct
    public void initData() {
        Perfume p1 = Perfume.build("Perfume1", Money.valueOf(Currency.MKD,500), 10);
        Perfume p2 = Perfume.build("Perfume2", Money.valueOf(Currency.MKD,100), 5);
        if (productRepository.findAll().isEmpty()) {
            productRepository.saveAll(Arrays.asList(p1,p2));
        }
    }
}

//@Component
//@AllArgsConstructor
//public class DataInitializer {
//
//    private final ProductRepository productRepository;
//
//    @PostConstruct
//    public void initData() {
//        Product p1 = Product.build("Pizza", Money.valueOf(Currency.MKD,500), 10);
//        Product p2 = Product.build("Ice Cream", Money.valueOf(Currency.MKD,100), 5);
//        if (productRepository.findAll().isEmpty()) {
//            productRepository.saveAll(Arrays.asList(p1,p2));
//        }
//    }
//}




