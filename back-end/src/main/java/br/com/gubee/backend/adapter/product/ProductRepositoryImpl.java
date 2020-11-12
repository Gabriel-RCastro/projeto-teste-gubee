package br.com.gubee.backend.adapter.product;

import br.com.gubee.backend.domain.Product;
import br.com.gubee.backend.product.spi.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@RequiredArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final JPAProductRepository jpaProductRepository;

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll().stream().map(ProductEntity::toDomain).collect(toList());
    }
}
