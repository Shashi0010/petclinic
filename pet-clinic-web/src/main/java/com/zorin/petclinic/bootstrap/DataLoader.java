package com.zorin.petclinic.bootstrap;

import com.zorin.petclinic.model.*;
import com.zorin.petclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
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

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        System.out.println("Speciality Types are Loaded");

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

        Visit dogVisit = new Visit();
        dogVisit.setDescription("Hyper Active Dog");
        dogVisit.setPet(shashisPet);
        dogVisit.setDate(LocalDate.now());

        visitService.save(dogVisit);

        Visit catVisit = new Visit();
        catVisit.setDescription("Sneezy Cat");
        catVisit.setPet(vamshisPet);
        catVisit.setDate(LocalDate.now());

        visitService.save(catVisit);

        System.out.println("Visits are Loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vishal");
        vet1.setLastName("Kulkarni");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vibhav");
        vet2.setLastName("Kulkarni");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Vets Loaded......");

    }
}
