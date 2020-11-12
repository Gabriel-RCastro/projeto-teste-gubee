package br.com.gubee.backend.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class TargetMarket {

    @EqualsAndHashCode.Include
    private Long id;
    private String name;

}
