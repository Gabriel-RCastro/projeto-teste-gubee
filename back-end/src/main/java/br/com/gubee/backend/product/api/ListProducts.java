package br.com.gubee.backend.product.api;

import br.com.gubee.backend.domain.Product;

import java.util.List;

public interface ListProducts {
    List<Product> find();
}
