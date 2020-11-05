package br.com.gubee.backend.services;

import br.com.gubee.backend.entities.Target;
import br.com.gubee.backend.repositories.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TargetService {

    @Autowired
    private TargetRepository targetRepository;

    public List<Target> findAll() {
        return targetRepository.findAll();
    }

    public Target findById(Long id) {
        Optional<Target> obj = targetRepository.findById(id);
        return obj.get();
    }

}
