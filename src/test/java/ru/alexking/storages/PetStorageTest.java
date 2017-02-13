package ru.alexking.storages;

import org.junit.Test;
import ru.alexking.models.Pet;
import ru.alexking.models.PetType;
import ru.alexking.models.Role;
import ru.alexking.models.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment
 *
 * @author alexking
 * @since 30.01.2017
 */
public class PetStorageTest {
    final RoleStorage roles = RoleStorage.getInstance();
    final UserStorage users = UserStorage.getInstance();
    final PetStorage pets = PetStorage.getInstance();
    final PetTypeStorage types = PetTypeStorage.getInstance();

    @Test
    public void testAdd() throws Exception {
        User user = new User();
        user.setRole(this.roles.add(new Role()));
        user = this.users.add(user);
        Pet pet = new Pet();
        pet.setOwner(user);
        PetType type = new PetType();
        type.setName("test");
        pet.setType(this.types.add(type));
        this.pets.add(pet);
        Pet result = this.pets.findById(pet.getId()).get();
        assertThat(pet, is(result));
    }
}