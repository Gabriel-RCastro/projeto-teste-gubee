package br.com.gubee.backend.product.api;

import br.com.gubee.backend.domain.ProductFilter;
import br.com.gubee.backend.domain.Product;

import java.util.List;

public interface FilterProducts {
    List<Product> find(String name, ProductFilter type);
}
