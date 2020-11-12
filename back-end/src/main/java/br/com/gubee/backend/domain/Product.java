package br.com.gubee.backend.domain;

import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @EqualsAndHashCode.Include
    private Long id;
    private String productName;
    private String description;

    private Set<TargetMarket> targetMarket = new HashSet<>();

    private Set<Stack> stack = new HashSet<>();

    public Set<TargetMarket> getTargetMarket() {
        return Set.copyOf(targetMarket);
    }

    public Set<Stack> getStack() {
        return Set.copyOf(stack);
    }

    public boolean containTargetMarket(String name) {
        var nameToLowerCase = name.toLowerCase();
        return this.targetMarket.stream().anyMatch(s -> s.getName().toLowerCase().contains(nameToLowerCase));
    }

    public boolean containStack(String name) {
        var nameToLowerCase = name.toLowerCase();
        return this.stack.stream().anyMatch(s -> s.getName().toLowerCase().contains(nameToLowerCase));
    }

}
