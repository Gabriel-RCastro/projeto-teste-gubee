package br.com.gubee.backend.repositories;

import br.com.gubee.backend.entities.TargetMarket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TargetMarketRepository extends JpaRepository<TargetMarket, Long> {
    Optional<TargetMarket> findByName(String name);
}
