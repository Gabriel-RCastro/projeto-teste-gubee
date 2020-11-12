package br.com.gubee.backend.product.api;

import br.com.gubee.backend.domain.Product;
import br.com.gubee.backend.domain.ProductFilter;
import br.com.gubee.backend.domain.Stack;
import br.com.gubee.backend.domain.TargetMarket;
import br.com.gubee.backend.product.api.usecase.FilterProductsImpl;
import br.com.gubee.backend.product.api.usecase.ListProductsImpl;
import br.com.gubee.backend.product.spi.stub.InMemoryProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterProductsTest {

    private FilterProducts filterProducts;

    private InMemoryProductRepository inMemoryProductRepository = new InMemoryProductRepository();

    @BeforeEach
    void setUp() {
        filterProducts = new FilterProductsImpl(inMemoryProductRepository);
    }

    @Test
    void deveriaListarOsProdutosQueONomeDaStackContenhaOracle() {
        // Dado
        Product p1 = Product.builder()
                .id(1L)
                .productName("teste1")
                .description("kkkk")
                .stack(Set.of(Stack.builder().name("stack1").id(1L).build()))
                .targetMarket(Set.of(TargetMarket.builder().name("target1").id(1L).build()))
                .build();

        Product p2 = Product.builder()
                .id(1L)
                .productName("teste2")
                .description("kkkkkkk")
                .stack(Set.of(Stack.builder().name("oracle").id(1L).build()))
                .targetMarket(Set.of(TargetMarket.builder().name("target2").id(1L).build()))
                .build();

        inMemoryProductRepository.add(p1);
        inMemoryProductRepository.add(p2);
        //Quando
        var listAllProducts = filterProducts.find("oracle", ProductFilter.STACK);

        // Entao
        assertEquals(listAllProducts, List.of(p2));
    }


}