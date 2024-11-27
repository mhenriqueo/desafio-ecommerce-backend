package br.com.ecommerce.api.repository;

import br.com.ecommerce.api.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
