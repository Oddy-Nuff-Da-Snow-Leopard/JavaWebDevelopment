package by.trjava.task02.entity;

public abstract class AirVehicle extends Vehicle {

    private int practicalCeiling;

    private int practicalRange;

    public AirVehicle() {

    }

    public AirVehicle(long id, String manufacturer, String modelName) {
        super(id, manufacturer, modelName);
    }

    public AirVehicle(long id, String manufacturer, String modelName,
            int maxSpeed, int practicalCeiling, int practicalRange) {
        super(id, manufacturer, modelName, maxSpeed);
        this.practicalCeiling = practicalCeiling;
        this.practicalRange = practicalRange;
    }

    public int getPracticalCeiling() {
        return practicalCeiling;
    }

    public void setPracticalCeiling(int practicalCeiling) {
        this.practicalCeiling = practicalCeiling;
    }

    public int getPracticalRange() {
        return practicalRange;
    }

    public void setPracticalRange(int practicalRange) {
        this.practicalRange = practicalRange;
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

        if (!super.equals(obj)) {
            return false;
        }

        AirVehicle airVehicle = (AirVehicle) obj;
        return practicalCeiling == airVehicle.practicalCeiling
                && practicalRange == airVehicle.practicalRange;
    }

    @Override
    public int hashCode() {
        Object[] fields = new Object[]{practicalCeiling, practicalRange};
        int result = 1;
        for (Object field : fields) {
            result = 31 * result + (field == null ? 0 : field.hashCode());
        }
        return super.hashCode() + result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString()).append("\n");
        str.append("practicalCeiling=").append(practicalCeiling).append(", ");
        str.append("practicalRange=").append(practicalRange);
        return str.toString();
    }
}
