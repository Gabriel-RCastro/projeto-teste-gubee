package br.com.gubee.backend.dto;

import java.util.List;

public class JsonDTO {
    String productName;
    String description;
    List<String> targetMarket;
    List<String> stack;

    public JsonDTO() {

    }

    public JsonDTO(String productName, String description, List<String> targetMarket, List<String> stack) {
        this.productName = productName;
        this.description = description;
        this.targetMarket = targetMarket;
        this.stack = stack;
    }
}
