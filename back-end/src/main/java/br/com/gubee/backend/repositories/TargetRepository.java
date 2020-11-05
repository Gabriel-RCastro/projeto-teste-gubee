package br.com.gubee.backend.repositories;

import br.com.gubee.backend.entities.Target;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TargetRepository extends JpaRepository<Target, Long> {
}
