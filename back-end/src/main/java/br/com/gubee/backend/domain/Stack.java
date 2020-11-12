package br.com.gubee.backend.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Stack {

    @EqualsAndHashCode.Include
    private Long id;
    private String name;
}
