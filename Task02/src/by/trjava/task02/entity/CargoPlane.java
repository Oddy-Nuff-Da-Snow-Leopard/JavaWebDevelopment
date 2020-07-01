package by.trjava.task02.entity;

public class CargoPlane extends Plane {

    private double cargoCompartmentLength;

    private int maxPayload;

    public CargoPlane() {

    }

    public CargoPlane(long id, String manufacturer, String modelName) {
        super(id, manufacturer, modelName);
    }

    public CargoPlane(long id, String manufacturer, String modelName,
            int maxSpeed, int practicalCeiling, int practicalRange,
            double length, double height, double fuselageWidth, int crew,
            int passengerCapacity, double cargoCapacity, int cruisingSpeed,
            int emptyWeight, int tankCapacity, int fuelConsumption,
            int maxPayload, double cargoCompartmentLength) {

        super(id, manufacturer, modelName, maxSpeed, practicalCeiling,
                practicalRange, length, height, fuselageWidth, crew,
                passengerCapacity, cargoCapacity, cruisingSpeed,
                emptyWeight, tankCapacity, fuelConsumption);

        this.maxPayload = maxPayload;
        this.cargoCompartmentLength = cargoCompartmentLength;
    }

    public double getCargoCompartmentLength() {
        return cargoCompartmentLength;
    }

    public void setCargoCompartmentLength(double cargoCompartmentLength) {
        this.cargoCompartmentLength = cargoCompartmentLength;
    }

    public int getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(int maxPayload) {
        this.maxPayload = maxPayload;
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

        CargoPlane cargoPlane = (CargoPlane) obj;
        return cargoCompartmentLength == cargoPlane.cargoCompartmentLength
                && maxPayload == cargoPlane.maxPayload;
    }

    @Override
    public int hashCode() {
        Object[] fields = new Object[]{maxPayload, cargoCompartmentLength};
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
        str.append("maxPayload=").append(maxPayload).append(", ");
        str.append("cargoCompartmentLength=").append(cargoCompartmentLength);
        return str.toString();
    }
}
