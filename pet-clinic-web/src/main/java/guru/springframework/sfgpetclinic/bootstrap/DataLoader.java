package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.PetTypeService;
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

        PetType dogPetType = new PetType();
        dogPetType.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dogPetType);

        PetType catPetType = new PetType();
        catPetType.setName("Cat");
        PetType savedCatPetType = petTypeService.save(catPetType);

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
        owner3.getPets().add(guillesPet);

        ownerService.save(owner3);

        System.out.println("Loading owners...");

        Vet vet = new Vet();
        vet.setFirstName("Sam");
        vet.setLastName("Axe");
        vetService.save(vet);
        System.out.println("Loading vets...");
    }
}
