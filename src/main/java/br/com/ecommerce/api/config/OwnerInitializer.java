package br.com.ecommerce.api.config;

import br.com.ecommerce.api.model.Owner;
import br.com.ecommerce.api.repository.OwnerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OwnerInitializer {

    @Autowired
    private OwnerRepository ownerRepository;

    @PostConstruct
    public void initOwners() {
        if (ownerRepository.count() == 0) {
            List<Owner> owners = List.of(
                Owner.builder().name("Nike").build(),
                Owner.builder().name("Adidas").build(),
                Owner.builder().name("Apple").build(),
                Owner.builder().name("Samsung").build(),
                Owner.builder().name("Sony").build()
            );
            ownerRepository.saveAll(owners);
        }
    }

}
