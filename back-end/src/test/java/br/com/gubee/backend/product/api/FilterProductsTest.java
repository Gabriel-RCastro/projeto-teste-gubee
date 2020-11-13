package br.com.gubee.backend.product.api;

import br.com.gubee.backend.domain.Product;
import br.com.gubee.backend.domain.ProductFilter;
import br.com.gubee.backend.domain.Stack;
import br.com.gubee.backend.domain.TargetMarket;
import br.com.gubee.backend.product.api.usecase.FilterProductsImpl;
import br.com.gubee.backend.product.spi.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FilterProductsTest {

    private FilterProducts filterProducts;

    // private final InMemoryProductRepository inMemoryProductRepository = new InMemoryProductRepository();

    @BeforeEach
    void setUp() {
        ProductRepository falseProductRepository = mock(ProductRepository.class);
        filterProducts = new FilterProductsImpl(falseProductRepository);
    }

//    @Test
//    void shouldListProductsThatStackNameContainsOracle() {
//        // Dado
//        Product p1 = Product.builder()
//                .id(1L)
//                .productName("teste1")
//                .description("teste1 description")
//                .stack(Set.of(Stack.builder().name("stack1").id(1L).build()))
//                .targetMarket(Set.of(TargetMarket.builder().name("target1").id(1L).build()))
//                .build();
//
//        Product p2 = Product.builder()
//                .id(1L)
//                .productName("teste2")
//                .description("teste2 description")
//                .stack(Set.of(Stack.builder().name("oracle").id(1L).build()))
//                .targetMarket(Set.of(TargetMarket.builder().name("target2").id(1L).build()))
//                .build();
//
//        inMemoryProductRepository.add(p1);
//        inMemoryProductRepository.add(p2);
//        //Quando
//        var listAllProducts = filterProducts.find("oracle", ProductFilter.STACK);
//
//        // Então
//        assertEquals(listAllProducts, List.of(p2));
//    }

    @Test
    void shouldListProductsThatStackNameContainsOracleWithMock() {
        // Dado
        Product p1 = Product.builder()
                .id(1L)
                .productName("teste1")
                .description("teste1 description")
                .stack(Set.of(Stack.builder().name("stack1").id(1L).build()))
                .targetMarket(Set.of(TargetMarket.builder().name("target1").id(1L).build()))
                .build();

        Product p2 = Product.builder()
                .id(1L)
                .productName("teste2")
                .description("teste2 description")
                .stack(Set.of(Stack.builder().name("oracle").id(1L).build()))
                .targetMarket(Set.of(TargetMarket.builder().name("target2").id(1L).build()))
                .build();

        // Quando
        when(filterProducts.find("oracle", ProductFilter.STACK)).thenReturn(List.of(p2));

        // Então
        assertEquals(filterProducts.find("oracle", ProductFilter.STACK), List.of(p2));
    }
}
