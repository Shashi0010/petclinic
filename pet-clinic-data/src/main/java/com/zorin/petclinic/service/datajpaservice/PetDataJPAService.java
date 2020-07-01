package com.zorin.petclinic.service.datajpaservice;

import com.zorin.petclinic.model.Pet;
import com.zorin.petclinic.repositories.PetRepository;
import com.zorin.petclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chintu on 7/2/2020
 */
@Service
@Profile("datajpaservice")
public class PetDataJPAService implements PetService {

    private final PetRepository petRepository;

    public PetDataJPAService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {

        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets :: add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
