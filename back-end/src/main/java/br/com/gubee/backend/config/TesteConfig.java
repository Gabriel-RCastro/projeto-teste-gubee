package br.com.gubee.backend.config;

import br.com.gubee.backend.entities.Product;
import br.com.gubee.backend.entities.Stack;
import br.com.gubee.backend.entities.TargetMarket;
import br.com.gubee.backend.repositories.ProductRepository;
import br.com.gubee.backend.repositories.StackRepository;
import br.com.gubee.backend.repositories.TargetMarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TargetMarketRepository targetMarketRepository;

    @Autowired
    private StackRepository stackRepository;

    @Override
    public void run(String... args) throws Exception {
        Product p1 = new Product(null, "Gubee Integrador", "Ferramenta de integração para marketplaces");
        Product p2 = new Product(null, "Gubee Fretes", "Ferramenta para gestão e calculo de fretes");

        productRepository.saveAll(Arrays.asList(p1, p2));

        Stack s1 = new Stack(null, "Java 10");
        Stack s2 = new Stack(null, "Kotlin");
        Stack s3 = new Stack(null, "Kafta");

        stackRepository.saveAll(Arrays.asList(s1, s2, s3));

        TargetMarket t1 = new TargetMarket(null, "Ecommerce");
        TargetMarket t2 = new TargetMarket(null, "ERP");
        TargetMarket t3 = new TargetMarket(null, "Loja fisica");

        targetMarketRepository.saveAll(Arrays.asList(t1, t2, t3));

        p1.getStack().add(s1);
        p1.getStack().add(s2);
        p2.getStack().add(s2);

        p1.getTargetMarket().add(t1);
        p2.getTargetMarket().add(t1);
        p2.getTargetMarket().add(t2);

        productRepository.saveAll(Arrays.asList(p1, p2));
    }
}
