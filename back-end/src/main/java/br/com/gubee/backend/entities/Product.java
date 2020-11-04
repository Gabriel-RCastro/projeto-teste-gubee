package br.com.gubee.backend.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Target> targets;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Stack> stacks;

    public Product() {
    }

    public Product(String name, String description, Set<Target> targets, Set<Stack> stacks) {
    }
}
