package br.com.gubee.backend.resources;

import br.com.gubee.backend.entities.TargetMarket;
import br.com.gubee.backend.services.TargetMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/targets")
public class TargetMarketResource {

    @Autowired
    private TargetMarketService service;

    @GetMapping
    public ResponseEntity<List<TargetMarket>> findAll() {
        List<TargetMarket> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TargetMarket> findById(@PathVariable Long id) {
        TargetMarket obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
