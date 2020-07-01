package com.zorin.petclinic.repositories;

import com.zorin.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Chintu on 7/1/2020
 */

public interface PetRepository extends CrudRepository<Pet, Long> {
}
