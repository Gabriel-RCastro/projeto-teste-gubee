package br.com.gubee.backend.config;

import br.com.gubee.backend.entities.Product;
import br.com.gubee.backend.entities.Stack;
import br.com.gubee.backend.entities.Target;
import br.com.gubee.backend.repositories.ProductRepository;
import br.com.gubee.backend.repositories.StackRepository;
import br.com.gubee.backend.repositories.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StackRepository stackRepository;

    @Autowired
    private TargetRepository targetRepository;

    @Override
    public void run(String... args) throws Exception {
        Product p1 = new Product(null, "Gubee Integrador", "Ferramenta de integração para marketplaces");
        Product p2 = new Product(null, "Gubee Fretes", "Ferramenta para gestão e calculo de fretes");

        productRepository.saveAll(Arrays.asList(p1, p2));

        Stack s1 = new Stack(null, "Java 10");
        Stack s2 = new Stack(null, "Kotlin");
        Stack s3 = new Stack(null, "Kafta");

        stackRepository.saveAll(Arrays.asList(s1, s2, s3));

        Target t1 = new Target(null, "Ecommerce");
        Target t2 = new Target(null, "ERP");
        Target t3 = new Target(null, "Loja fisica");

        targetRepository.saveAll(Arrays.asList(t1, t2, t3));

        p1.getStacks().add(s1);
        p1.getStacks().add(s2);
        p2.getStacks().add(s2);

        p1.getTargets().add(t1);
        p2.getTargets().add(t1);
        p2.getTargets().add(t2);

        productRepository.saveAll(Arrays.asList(p1, p2));
    }
}
