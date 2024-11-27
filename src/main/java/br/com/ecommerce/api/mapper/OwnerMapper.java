package br.com.ecommerce.api.mapper;

import br.com.ecommerce.api.dto.owner.OwnerResponseDTO;
import br.com.ecommerce.api.model.Owner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OwnerMapper {

    public OwnerResponseDTO toDTO(Owner owner) {
        return OwnerResponseDTO.builder()
            .id(owner.getId())
            .name(owner.getName())
            .build();
    }

    public List<OwnerResponseDTO> toDTOList(List<Owner> owners) {
        return owners.stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

}
