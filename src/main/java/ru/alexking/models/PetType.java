package ru.alexking.models;

/**
 * TODO: comment
 *
 * @author alexking
 * @since 30.01.2017
 */
public class PetType {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PetType petType = (PetType) o;

        if (id != petType.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
