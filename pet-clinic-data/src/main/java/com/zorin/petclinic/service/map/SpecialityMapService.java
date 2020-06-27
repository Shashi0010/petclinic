package com.zorin.petclinic.service.map;

import com.zorin.petclinic.model.Speciality;
import com.zorin.petclinic.service.SpecialityService;

import java.util.Set;

/**
 * Created by Chintu on 6/27/2020
 */
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {


    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return super.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        super.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
