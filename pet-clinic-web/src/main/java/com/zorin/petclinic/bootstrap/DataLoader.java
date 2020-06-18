package com.zorin.petclinic.bootstrap;

import com.zorin.petclinic.model.Owner;
import com.zorin.petclinic.model.Vet;
import com.zorin.petclinic.service.OwnerService;
import com.zorin.petclinic.service.VetService;
import com.zorin.petclinic.service.map.OwnerServiceMap;
import com.zorin.petclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {

        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Shashi");
        owner1.setLastName("Kanth");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Vamshi");
        owner1.setLastName("Dhar");

        ownerService.save(owner2);

        System.out.println("Owners Loaded......");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Vishal");
        vet1.setLastName("Kulkarni");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Vibhav");
        vet1.setLastName("Kulkarni");

        vetService.save(vet2);

        System.out.println("Vets Loaded......");

    }
}
