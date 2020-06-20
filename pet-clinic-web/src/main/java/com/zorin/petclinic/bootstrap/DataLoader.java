package com.zorin.petclinic.bootstrap;

import com.zorin.petclinic.model.Owner;
import com.zorin.petclinic.model.Vet;
import com.zorin.petclinic.service.OwnerService;
import com.zorin.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Shashi");
        owner1.setLastName("Kanth");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Vamshi");
        owner2.setLastName("Dhar");

        ownerService.save(owner2);

        System.out.println("Owners Loaded......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vishal");
        vet1.setLastName("Kulkarni");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vibhav");
        vet2.setLastName("Kulkarni");

        vetService.save(vet2);

        System.out.println("Vets Loaded......");

    }
}
