package br.com.gubee.backend.repositories;

import br.com.gubee.backend.entities.Stack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StackRepository extends JpaRepository<Stack, Long> {
}
