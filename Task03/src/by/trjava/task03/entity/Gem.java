package by.trjava.task03.entity;

import by.trjava.task03.entity.type.Preciousness;
import java.util.Objects;
import javax.xml.datatype.XMLGregorianCalendar;

public class Gem {

    private String id;
    private Preciousness preciousness;
    private String name;
    private String origin;
    private Appearance appearance;
    private Property properties;
    private double weight;

    private Gem() {
    }

    public static class Builder {

        private final Gem gem;

        public Builder() {
            gem = new Gem();
        }

        public Builder setId(String id) {
            gem.id = id;
            return this;
        }

        public Builder setPreciousness(Preciousness preciousness) {
            gem.preciousness = preciousness;
            return this;
        }

        public Builder setName(String name) {
            gem.name = name;
            return this;
        }

        public Builder setOrigin(String origin) {
            gem.origin = origin;
            return this;
        }

        public Builder setAppearance(Appearance appearance) {
            gem.appearance = appearance;
            return this;
        }

        public Builder setProperties(Property properties) {
            gem.properties = properties;
            return this;
        }

        public Builder setWeight(double weight) {
            gem.weight = weight;
            return this;
        }

        public Gem build() {
            return gem;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Preciousness getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(Preciousness preciousness) {
        this.preciousness = preciousness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public Property getProperties() {
        return properties;
    }

    public void setProperties(Property properties) {
        this.properties = properties;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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

        Gem gem = (Gem) obj;

        return Objects.equals(id, gem.id)
                && preciousness == gem.preciousness
                && Objects.equals(name, gem.name)
                && Objects.equals(origin, gem.origin)
                && Objects.equals(appearance, gem.appearance)
                && Objects.equals(properties, gem.properties)
                && weight == gem.weight;
    }

    @Override
    public int hashCode() {
        Object[] fields = new Object[]{
            id,
            preciousness,
            name,
            origin,
            appearance,
            properties,
            weight
        };
        int result = 1;
        for (Object field : fields) {
            result = 31 * result + (field == null ? 0 : field.hashCode());
        }
        return super.hashCode() + result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[id=").append(id).append(", ");
        str.append("preciousness=").append(preciousness.getValue()).append(", ");
        str.append("name=").append(name).append(", ");
        str.append("origin=").append(origin).append(", ");
        str.append("appearance={").append(appearance).append("}, ");
        str.append("properties={").append(properties).append("}, ");
        str.append("weight=").append(weight).append("]");
        return str.toString();
    }
}
