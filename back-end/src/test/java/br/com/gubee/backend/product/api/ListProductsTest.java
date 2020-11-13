package br.com.gubee.backend.product.api;

import br.com.gubee.backend.domain.Product;
import br.com.gubee.backend.domain.Stack;
import br.com.gubee.backend.domain.TargetMarket;
import br.com.gubee.backend.product.api.usecase.ListProductsImpl;
import br.com.gubee.backend.product.spi.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ListProductsTest {

    private ListProducts listProducts;
    private ProductRepository falseProductRepository;

    //private InMemoryProductRepository inMemoryProductRepository = new InMemoryProductRepository();

    @BeforeEach
    void setUp() {
        ProductRepository falseProductRepository = mock(ProductRepository.class);
        listProducts = new ListProductsImpl(falseProductRepository);
        //listProducts = mock(ListProductsImpl.class);
    }

//    @Test
//    void shouldListAllProducts() {
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
//                .stack(Set.of(Stack.builder().name("stack2").id(1L).build()))
//                .targetMarket(Set.of(TargetMarket.builder().name("target2").id(1L).build()))
//                .build();
//
//        inMemoryProductRepository.add(p1);
//        inMemoryProductRepository.add(p2);
//        //Quando
//        var listAllProducts = listProducts.find();
//
//        // Entao
//        assertEquals(listAllProducts, List.of(p1, p2));
//    }

    @Test
    void shouldListAllProductsWithMock() {
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
                .stack(Set.of(Stack.builder().name("stack2").id(1L).build()))
                .targetMarket(Set.of(TargetMarket.builder().name("target2").id(1L).build()))
                .build();

        when(listProducts.find()).thenReturn(List.of(p1, p2));

        assertEquals(listProducts.find(), List.of(p1, p2));
    }
}
