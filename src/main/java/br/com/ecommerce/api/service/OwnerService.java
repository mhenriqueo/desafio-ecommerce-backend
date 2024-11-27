package br.com.ecommerce.api.service;

import br.com.ecommerce.api.dto.owner.OwnerResponseDTO;

import java.util.List;

public interface OwnerService {
    List<OwnerResponseDTO> getAllOwners();
}
