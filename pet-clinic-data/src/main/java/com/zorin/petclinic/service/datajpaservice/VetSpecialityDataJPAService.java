package com.zorin.petclinic.service.datajpaservice;

import com.zorin.petclinic.model.Speciality;
import com.zorin.petclinic.repositories.SpecialityRepository;
import com.zorin.petclinic.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chintu on 7/2/2020
 */
@Service
@Profile("datajpaservice")
public class VetSpecialityDataJPAService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public VetSpecialityDataJPAService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities :: add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
