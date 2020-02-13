package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"),
    inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> especialties = new HashSet<>();

    public Set<Specialty> getEspecialties() {
        return especialties;
    }

    public void setEspecialties(Set<Specialty> especialties) {
        this.especialties = especialties;
    }
}
