package com.zorin.petclinic.repositories;

import com.zorin.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Chintu on 7/1/2020
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
