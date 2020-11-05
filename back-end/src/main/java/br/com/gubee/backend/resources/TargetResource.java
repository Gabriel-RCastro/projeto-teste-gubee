package br.com.gubee.backend.resources;

import br.com.gubee.backend.entities.Target;
import br.com.gubee.backend.services.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/targets")
public class TargetResource {

    @Autowired
    private TargetService service;

    @GetMapping
    public ResponseEntity<List<Target>> findAll() {
        List<Target> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Target> findById(@PathVariable Long id) {
        Target obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
