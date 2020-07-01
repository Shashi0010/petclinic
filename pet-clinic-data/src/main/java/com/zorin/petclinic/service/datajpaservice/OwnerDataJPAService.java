package com.zorin.petclinic.service.datajpaservice;

import com.zorin.petclinic.model.Owner;
import com.zorin.petclinic.repositories.OwnerRepository;
import com.zorin.petclinic.repositories.PetRepository;
import com.zorin.petclinic.repositories.PetTypeRepository;
import com.zorin.petclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chintu on 7/1/2020
 */
@Service
@Profile("datajpaservice")
public class OwnerDataJPAService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerDataJPAService(OwnerRepository ownerRepository,
                               PetRepository petRepository,
                               PetTypeRepository petTypeRepository) {

        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners :: add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {

        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
