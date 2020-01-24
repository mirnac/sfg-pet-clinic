package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    private Set<Specialty> especialties = new HashSet<>();

    public Set<Specialty> getEspecialties() {
        return especialties;
    }

    public void setEspecialties(Set<Specialty> especialties) {
        this.especialties = especialties;
    }
}
