package br.com.gubee.backend.product.api.usecase;

import br.com.gubee.backend.domain.Product;
import br.com.gubee.backend.domain.ProductFilter;
import br.com.gubee.backend.product.api.FilterProducts;
import br.com.gubee.backend.product.spi.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class FilterProductsImpl implements FilterProducts {

    private final ProductRepository productRepository;

    @Override
    public List<Product> find(String name, ProductFilter productFilter) {
        var products = productRepository.findAll();
        return switch (productFilter) {
            case TARGET_MARKET -> products.stream().filter(p -> p.containTargetMarket(name)).collect(toList());
            case STACK -> products.stream().filter(p -> p.containStack(name)).collect(toList());
        };
    }
}
