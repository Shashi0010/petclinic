package com.zorin.petclinic.service.datajpaservice;

import com.zorin.petclinic.model.Visit;
import com.zorin.petclinic.repositories.VisitRepository;
import com.zorin.petclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chintu on 7/3/2020
 */
@Service
@Profile("datajpaservice")
public class VisitDataJPAService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitDataJPAService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {

        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits :: add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
