package br.com.gubee.backend.adapter.product;

import br.com.gubee.backend.domain.TargetMarket;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "target_market")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TargetMarketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;

    public TargetMarket toDomain() {
        return TargetMarket.builder()
                .id(this.getId())
                .name(this.getName())
                .build();
    }
}
