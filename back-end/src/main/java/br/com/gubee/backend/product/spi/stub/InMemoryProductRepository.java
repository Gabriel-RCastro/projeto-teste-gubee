package br.com.gubee.backend.product.spi.stub;

import br.com.gubee.backend.domain.Product;
import br.com.gubee.backend.domain.Stack;
import br.com.gubee.backend.domain.TargetMarket;
import br.com.gubee.backend.product.spi.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InMemoryProductRepository implements ProductRepository {
    private final List<Product> productList;

    public InMemoryProductRepository() {
        productList = new ArrayList<>();
    }

    public void add(Product product) {
        this.productList.add(product);
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }
}
