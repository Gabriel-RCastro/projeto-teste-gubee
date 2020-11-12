package br.com.gubee.backend.product.api.usecase;

import br.com.gubee.backend.domain.Product;
import br.com.gubee.backend.product.api.ListProducts;
import br.com.gubee.backend.product.spi.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListProductsImpl implements ListProducts {

    private final ProductRepository productRepository;

    @Override
    public List<Product> find() {
        return productRepository.findAll();
    }
}
