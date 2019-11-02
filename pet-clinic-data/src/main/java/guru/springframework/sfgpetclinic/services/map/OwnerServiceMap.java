package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnserService;

import java.util.Set;

public class OwnerServiceMap  extends AbstractMapService<Owner,Long> implements OwnserService {

    @Override
    public Set<Owner> findAll() {
        return super.findaAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return map.entrySet().stream().filter(entry -> entry.getValue().getLastName().equals(lastName))
                .findAny().get().getValue();
    }
}
