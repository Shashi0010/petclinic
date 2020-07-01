package com.zorin.petclinic.repositories;

import com.zorin.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Chintu on 7/1/2020
 */

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
