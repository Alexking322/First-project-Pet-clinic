package ru.alexking.storages;

import org.junit.Test;
import ru.alexking.models.Role;
import ru.alexking.models.User;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment
 *
 * @author alexking
 * @since 30.01.2017
 */
public class UserStorageTest {
    final UserStorage users = UserStorage.getInstance();
    final RoleStorage roles = RoleStorage.getInstance();

    @Test
    public void testAdd() throws Exception {
        User user = new User();
        user.setUsername("alexking");
        user.setRole(this.roles.add(new Role()));
        user = this.users.add(user);
        assertThat(user, is(this.users.findById(user.getId()).get()));
    }

    @Test
    public void testUpdate() throws Exception {
        User user = new User();
        user.setUsername("alexking");
        user.setRole(this.roles.add(new Role()));
        user = this.users.add(user);
        user.setUsername("Alex Ermakov");
        this.users.update(user);
        assertThat(this.users.findById(user.getId()).get().getUsername(), is(user.getUsername()));
    }

    @Test
    public void testGetAll() throws Exception {
        Role role = new Role();
        User user = new User();
        user.setUsername("alexking");
        user.setRole(this.roles.add(role));
        user = this.users.add(user);
        assertTrue(this.users.getAll().contains(user));
    }

    @Test
    public void testFindByCridentional() throws Exception {
        User user = new User();
        user.setUsername("alexking");
        user.setPassword("qw759123");
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        user.setRole(this.roles.add(role));
        user = this.users.add(user);
        User result = this.users.findByCridentional(user.getUsername(), user.getPassword()).get();
        assertThat(user, is(result));
        assertThat(result.getRole().getName(), is("ROLE_ADMIN"));
    }

    @Test
    public void testFindById() throws Exception {
        User user = new User();
        user.setUsername("parsentev");
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        user.setRole(this.roles.add(role));
        user = this.users.add(user);
        User result = this.users.findById(user.getId()).get();
        assertThat(user, is(result));
    }

    @Test
    public void testDelete() throws Exception {
        User user = new User();
        user.setUsername("alexking");
        user.setRole(this.roles.add(new Role()));
        user = this.users.add(user);
        this.users.delete(user.getId());
        assertThat(this.users.findById(user.getId()), is(Optional.<User>empty()));
    }
}