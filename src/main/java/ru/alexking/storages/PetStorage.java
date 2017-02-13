package ru.alexking.storages;

import com.google.common.base.Joiner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.alexking.models.Pet;
import ru.alexking.models.PetType;
import ru.alexking.models.Role;
import ru.alexking.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * TODO: comment
 *
 * @author alexking
 * @since 30.01.2017
 */
public class PetStorage {
    private static final Logger log = LoggerFactory.getLogger(PetStorage.class);
    private static final PetStorage instance = new PetStorage();
    private final SessionFactory factory = HibernateFactory.getFactory();

    private PetStorage() {
    }

    public static PetStorage getInstance() {
        return instance;
    }

    public Pet add(Pet pet) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(pet);
            session.getTransaction().commit();
        }
        return pet;
    }

    public Optional<Pet> findById(final int id) {
        Optional<Pet> result = Optional.empty();
        try(Session session = factory.openSession()) {
            Pet pet = session.get(Pet.class, id);
            if (pet != null) {
                result = Optional.of(pet);
            }
        }
        return result;
    }

    public List<Pet> findByOwnerId(final int id) {
        List<Pet> result = new ArrayList<>();
        try(Session session = factory.openSession()) {
            Query query = session.createQuery(
                    "select u from Pet as p join fetch p.type where u.owner.id=:id"
            );
            query.setParameter("id", id);
            result = query.list();
        }
        return result;
    }

    public List<Pet> getAll() {
        List<Pet> result = new ArrayList<>();
        try(Session session = factory.openSession()) {
            result.addAll(session.createQuery("from Pet as p join fetch p.type").list());
        }
        return result;
    }
}
