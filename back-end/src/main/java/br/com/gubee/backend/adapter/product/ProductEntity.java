package br.com.gubee.backend.adapter.product;

import br.com.gubee.backend.domain.Product;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Entity(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String productName;
    private String description;

    @ManyToMany
    private Set<TargetMarketEntity> targetMarket = new HashSet<>();

    @ManyToMany
    private Set<StackEntity> stack = new HashSet<>();

    public boolean containTargetMarket(String name) {
        var nameToLowerCase = name.toLowerCase();
        return this.targetMarket.stream().anyMatch(s -> s.getName().toLowerCase().contains(nameToLowerCase));
    }

    public boolean containStack(String name) {
        var nameToLowerCase = name.toLowerCase();
        return this.stack.stream().anyMatch(s -> s.getName().toLowerCase().contains(nameToLowerCase));
    }

    public Product toDomain() {
        return Product.builder()
                .id(this.getId())
                .description(this.getDescription())
                .productName(this.getProductName())
                .stack(this.getStack().stream().map(StackEntity::toDomain).collect(toSet()))
                .targetMarket(this.getTargetMarket().stream().map(TargetMarketEntity::toDomain).collect(toSet()))
                .build();
    }
}
