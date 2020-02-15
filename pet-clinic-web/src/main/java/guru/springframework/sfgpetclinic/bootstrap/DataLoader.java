package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.PetTypeService;
import guru.springframework.sfgpetclinic.services.map.VisitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        long count = petTypeService.findAll().size();
        if(count == 0)
            loadData();
    }

    private void loadData() {
        PetType dogPetType = new PetType();
        dogPetType.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dogPetType);

        PetType catPetType = new PetType();
        catPetType.setName("Cat");
        PetType savedCatPetType = petTypeService.save(catPetType);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty odontology = new Specialty();
        odontology.setDescription("Odontology");
        Specialty savedOdontology = specialtyService.save(odontology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Owner owner1 = new Owner();
        owner1.setFirstName("Santiago");
        owner1.setLastName("Caceres");
        owner1.setAddress("Arekutakua 486");
        owner1.setCity("Emboscada");
        owner1.setTelephone("0981101970");

        Pet santisPet = new Pet();
        santisPet.setPetType(savedDogPetType);
        santisPet.setBirthDate(LocalDate.now());
        santisPet.setName("Negris");
        santisPet.setOwner(owner1);
        owner1.getPets().add(santisPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Julieta ");
        owner2.setLastName("Caceres");
        owner2.setAddress("Arekutakua 486");
        owner2.setCity("Emboscada");
        owner2.setTelephone("0981101970");

        Pet julisPet = new Pet();
        julisPet.setName("michifu");
        julisPet.setBirthDate(LocalDate.now());
        julisPet.setPetType(savedCatPetType);
        julisPet.setOwner(owner2);
        owner2.getPets().add(julisPet);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Guillermo ");
        owner3.setLastName("Caceres");
        owner3.setAddress("Arekutakua 486");
        owner3.setCity("Emboscada");
        owner3.setTelephone("0981101970");

        Pet guillesPet = new Pet();
        guillesPet.setPetType(savedDogPetType);
        guillesPet.setName("newbabydog");
        guillesPet.setBirthDate(LocalDate.now());
        guillesPet.setOwner(owner3);
        owner3.getPets().add(guillesPet);

        ownerService.save(owner3);

        System.out.println("Loading owners...");

        Visit catVisit = new Visit();
        catVisit.setPet(julisPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Visita a Michifu");
        visitService.save(catVisit);

        Vet vet = new Vet();
        vet.setFirstName("Sam");
        vet.setLastName("Axe");
        vet.getEspecialties().add(savedRadiology);
        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getEspecialties().add(savedSurgery);
        vetService.save(vet);

        System.out.println("Loading vets...");
    }
}
