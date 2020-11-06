package br.com.gubee.backend.config;

import br.com.gubee.backend.entities.Product;
import br.com.gubee.backend.repositories.ProductRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("test")
public class DevConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        String teste = "[\n" +
                "  {\n" +
                "    \"productName\": \"Gubee Integrador\",\n" +
                "    \"description\": \"Ferramenta de integração para marketplaces\",\n" +
                "    \"targetMarket\": [\n" +
                "      \"Ecommerce\",\n" +
                "      \"ERP\",\n" +
                "      \"Lojista que não desejam possuir ecommerce\"\n" +
                "    ],\n" +
                "    \"stack\": [\n" +
                "      \"Java 10\",\n" +
                "      \"Kotlin\",\n" +
                "      \"Kafka\",\n" +
                "      \"Event Stream\",\n" +
                "      \"Redis\",\n" +
                "      \"MongoDB\"\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"productName\": \"Gubee Fretes\",\n" +
                "    \"description\": \"Ferramenta para gestão e calculo de fretes\",\n" +
                "    \"targetMarket\": [\n" +
                "      \"Ecommerce\",\n" +
                "      \"ERP\",\n" +
                "      \"Loja fisica\"\n" +
                "    ],\n" +
                "    \"stack\": [\n" +
                "      \"NodeJS\",\n" +
                "      \"MongoDB\"\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"productName\": \"Gubee Fretes\",\n" +
                "    \"description\": \"Ferramenta para gestão e calculo de fretes\",\n" +
                "    \"targetMarket\": [\n" +
                "      \"Ecommerce\",\n" +
                "      \"ERP\",\n" +
                "      \"Loja fisica\"\n" +
                "    ],\n" +
                "    \"stack\": [\n" +
                "      \"NodeJS\",\n" +
                "      \"MongoDB\"\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"productName\": \"Gubee AntiFraude\",\n" +
                "    \"description\": \"Ferramenta especialistas em detecção e prevenção à fraude\",\n" +
                "    \"targetMarket\": [\n" +
                "      \"Ecommerce\",\n" +
                "      \"Telecom\",\n" +
                "      \"Venda direta\",\n" +
                "      \"Mobile First\",\n" +
                "      \"Digital Onboarding\"\n" +
                "    ],\n" +
                "    \"stack\": [\n" +
                "      \"Big Data Analytics\",\n" +
                "      \"Hadoop\",\n" +
                "      \"Kafka\",\n" +
                "      \"Pig\",\n" +
                "      \"Cassandra\"\n" +
                "    ]\n" +
                "  }\n" +
                "]";

        ObjectMapper obj = new ObjectMapper();
        List<Product> products = obj.readValue(teste, new TypeReference<List<Product>>() {
        });

        productRepository.saveAll(products);
    }
}
