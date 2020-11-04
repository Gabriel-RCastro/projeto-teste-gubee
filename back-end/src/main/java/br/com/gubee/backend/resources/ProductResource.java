package br.com.gubee.backend.resources;

import br.com.gubee.backend.entities.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @GetMapping("/{id}")
    public ResponseEntity<Product> readById(@PathVariable Long id) {
        Product product = new Product();
        return ResponseEntity.ok().body(product);
    }

}
