package br.com.ecommerce.api.service.impl;

import br.com.ecommerce.api.dto.owner.OwnerResponseDTO;
import br.com.ecommerce.api.mapper.OwnerMapper;
import br.com.ecommerce.api.model.Owner;
import br.com.ecommerce.api.repository.OwnerRepository;
import br.com.ecommerce.api.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    public List<OwnerResponseDTO> getAllOwners() {
        List<Owner> owners = ownerRepository.findAll();
        return ownerMapper.toDTOList(owners);
    }

}
