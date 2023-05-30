package emt.lab.productcatalog.xport.rest;

import emt.lab.productcatalog.domain.models.Perfume;
import emt.lab.productcatalog.services.PerfumeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductResource {

    private final PerfumeService perfumeService;

    @GetMapping
    public List<Perfume> getAll() {
        return perfumeService.getAll();
    }

}

