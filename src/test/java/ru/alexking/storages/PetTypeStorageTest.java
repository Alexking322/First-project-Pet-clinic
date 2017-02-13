package ru.alexking.storages;

import org.junit.Test;
import ru.alexking.models.PetType;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment
 *
 * @author alexking
 * @since 30.01.2017
 */
public class PetTypeStorageTest {
    final PetTypeStorage types = PetTypeStorage.getInstance();

    @Test
    public void testAdd() throws Exception {
        PetType type = this.types.add(new PetType());
        assertThat(type, is(this.types.findById(type.getId()).get()));
    }

    @Test
    public void testGetAll() throws Exception {
        PetType type = this.types.add(new PetType());
        assertTrue(this.types.getAll().contains(type));
    }
}