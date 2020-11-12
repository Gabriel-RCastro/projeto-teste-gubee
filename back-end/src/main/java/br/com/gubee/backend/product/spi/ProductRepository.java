package br.com.gubee.backend.product.spi;

import br.com.gubee.backend.domain.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
