package br.com.gubee.backend.adapter.product;

import br.com.gubee.backend.domain.Stack;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "stack")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;

    public Stack toDomain() {
        return Stack.builder()
                .id(this.getId())
                .name(this.getName())
                .build();
    }
}
