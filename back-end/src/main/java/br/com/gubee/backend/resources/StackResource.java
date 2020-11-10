package br.com.gubee.backend.resources;

import br.com.gubee.backend.entities.Stack;
import br.com.gubee.backend.services.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/stacks")
public class StackResource {

    @Autowired
    private StackService service;

    @GetMapping
    public ResponseEntity<List<Stack>> findAll() {
        List<Stack> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Stack> findById(@PathVariable Long id) {
        Stack obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/pername/{name}")
    public ResponseEntity<Stack> findByName(@PathVariable String name) {
        Stack obj = service.findByName(name);
        return ResponseEntity.ok().body(obj);
    }
}
