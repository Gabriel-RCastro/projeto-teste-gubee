package br.com.gubee.backend.services;

import br.com.gubee.backend.entities.TargetMarket;
import br.com.gubee.backend.repositories.TargetRepository;
import br.com.gubee.backend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TargetMarketService {

    @Autowired
    private TargetRepository targetRepository;

    public List<TargetMarket> findAll() {
        return targetRepository.findAll();
    }

    public TargetMarket findById(Long id) {
        Optional<TargetMarket> obj = targetRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
