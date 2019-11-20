package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnserService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnserService ownserService;
    private final VetService vetService;

    public DataLoader(OwnserService ownserService, VetService vetService) {
        this.ownserService = ownserService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownserService.save(owner1);

        System.out.println("Loading owners...");

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Same");
        vet.setLastName("Axe");
        vetService.save(vet);
        System.out.println("Loading vets...");
    }
}
