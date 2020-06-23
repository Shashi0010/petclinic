package com.zorin.petclinic.bootstrap;

import com.zorin.petclinic.model.Owner;
import com.zorin.petclinic.model.Pet;
import com.zorin.petclinic.model.PetType;
import com.zorin.petclinic.model.Vet;
import com.zorin.petclinic.service.OwnerService;
import com.zorin.petclinic.service.PetTypeService;
import com.zorin.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog =  new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Pet Types Loaded");

        Owner owner1 = new Owner();
        owner1.setFirstName("Shashi");
        owner1.setLastName("Kanth");
        owner1.setAddress("360-661, Amet Street");
        owner1.setCity("Baricella");
        owner1.setTelephone("09297556311");

        Pet shashisPet = new Pet();
        shashisPet.setPetType(savedDogPetType);
        shashisPet.setOwner(owner1);
        shashisPet.setBirthDate(LocalDate.now());
        shashisPet.setName("Rocky");
        owner1.getPets().add(shashisPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Vamshi");
        owner2.setLastName("Dhar");
        owner2.setAddress("622 Nec, St.");
        owner2.setCity("Lagundo/Algund");
        owner2.setTelephone("09617025830");

        Pet vamshisPet = new Pet();
        vamshisPet.setPetType(savedCatPetType);
        vamshisPet.setOwner(owner1);
        vamshisPet.setBirthDate(LocalDate.now());
        vamshisPet.setName("Goose");
        owner2.getPets().add(vamshisPet);

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
