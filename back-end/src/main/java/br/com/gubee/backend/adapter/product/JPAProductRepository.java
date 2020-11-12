package br.com.gubee.backend.adapter.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAProductRepository extends JpaRepository<ProductEntity, Long> {
}
