package br.com.gubee.backend.resources;

import br.com.gubee.backend.domain.Product;
import br.com.gubee.backend.domain.ProductFilter;
import br.com.gubee.backend.product.api.FilterProducts;
import br.com.gubee.backend.product.api.ListProducts;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@RequiredArgsConstructor
public class ProductResource  {

    private final ListProducts listProducts;
    private final FilterProducts filterProducts;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = listProducts.find();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/byFilter/{type}/{name}")
    public ResponseEntity<List<Product>> findById(@PathVariable String type, @PathVariable String name) {
        var productList = filterProducts.find(name, ProductFilter.valueOf(type));
        return ResponseEntity.ok().body(productList);
    }
}
