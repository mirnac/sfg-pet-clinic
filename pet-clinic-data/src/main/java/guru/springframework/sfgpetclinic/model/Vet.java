package guru.springframework.sfgpetclinic.model;

import java.util.Set;

public class Vet extends Person {

    private Set<Specialty> especialties;
    private String address;
    private String city;
    private String telephone;

    public Set<Specialty> getEspecialties() {
        return especialties;
    }

    public void setEspecialties(Set<Specialty> especialties) {
        this.especialties = especialties;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
