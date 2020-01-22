package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

public interface OwnserService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
