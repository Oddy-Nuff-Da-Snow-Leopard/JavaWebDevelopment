package by.epam.appetizer.entity;

import java.io.Serializable;

public abstract class Entity implements Serializable {

    private static final long serialVersionUID = 4L;

    private int id;

    public Entity() {
    }

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        Entity entity = (Entity) obj;
        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        str.append("[id=").append(id).append(", ");
        return str.toString();
    }

}
