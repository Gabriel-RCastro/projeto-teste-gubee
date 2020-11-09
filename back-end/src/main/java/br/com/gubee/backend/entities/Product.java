package br.com.gubee.backend.entities;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String description;

    @ManyToMany
    private Set<TargetMarket> targetMarket = new HashSet<>();

    @ManyToMany
    private Set<Stack> stack = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String productName, String description) {
        this.id = id;
        this.productName = productName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<TargetMarket> getTargetMarket() {
        return targetMarket;
    }

    public Set<Stack> getStack() {
        return stack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
