package emt.lab.productcatalog.domain.models.repository;

import emt.lab.productcatalog.domain.models.Perfume;
import emt.lab.productcatalog.domain.models.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Perfume, ProductId> {
}
