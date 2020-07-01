package by.trjava.task03.entity;

public class Property {

    private double density;
    private double refractiveIndex;
    private int mohsHardness;

    private Property() {
    }

    public static class Builder {

        private final Property properties;

        public Builder() {
            properties = new Property();
        }

        public Builder setDensity(double density) {
            properties.density = density;
            return this;
        }

        public Builder setRefractiveIndex(double refractiveIndex) {
            properties.refractiveIndex = refractiveIndex;
            return this;
        }

        public Builder setMohsHardness(int mohsHardness) {
            properties.mohsHardness = mohsHardness;
            return this;
        }

        public Property build() {
            return properties;
        }
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getRefractiveIndex() {
        return refractiveIndex;
    }

    public void setRefractiveIndex(double refractiveIndex) {
        this.refractiveIndex = refractiveIndex;
    }

    public int getMohsHardness() {
        return mohsHardness;
    }

    public void setMohsHardness(int mohsHardness) {
        this.mohsHardness = mohsHardness;
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

        Property properties = (Property) obj;

        return density == properties.density
                && refractiveIndex == properties.refractiveIndex
                && mohsHardness == properties.mohsHardness;
    }

    @Override
    public int hashCode() {
        Object[] fields = new Object[]{
            density,
            refractiveIndex,
            mohsHardness
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
        str.append("density=").append(density).append(", ");
        str.append("refractiveIndex=").append(refractiveIndex).append(", ");
        str.append("mohsHardness=").append(mohsHardness);
        return str.toString();
    }
}
