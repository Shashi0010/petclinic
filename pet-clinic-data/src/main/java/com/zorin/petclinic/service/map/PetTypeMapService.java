package com.zorin.petclinic.service.map;

import com.zorin.petclinic.model.PetType;
import com.zorin.petclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Chintu on 6/23/2020
 */

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long>
        implements PetTypeService {


    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
