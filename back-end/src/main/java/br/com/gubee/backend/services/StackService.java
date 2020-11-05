package br.com.gubee.backend.services;

import br.com.gubee.backend.entities.Stack;
import br.com.gubee.backend.repositories.StackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StackService {

    @Autowired
    private StackRepository stackRepository;

    public List<Stack> findAll() {
        return stackRepository.findAll();
    }

    public Stack findById(Long id) {
        Optional<Stack> obj = stackRepository.findById(id);
        return obj.get();
    }

}
