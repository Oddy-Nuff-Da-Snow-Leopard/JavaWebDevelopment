package by.trjava.task02.entity;

public class Plane extends AirVehicle {

    private double length;

    private double height;

    private double fuselageWidth;

    private int crew;

    private int passengerCapacity;

    private double cargoCapacity;

    private int cruisingSpeed;

    private int emptyWeight;

    private int tankCapacity;

    private int fuelConsumption;

    public Plane() {

    }

    public Plane(long id, String manufacturer, String modelName) {
        super(id, manufacturer, modelName);
    }

    public Plane(long id, String manufacturer, String modelName, int maxSpeed,
            int practicalCeiling, int practicalRange, double length,
            double height, double fuselageWidth, int crew,
            int passengerCapacity, double cargoCapacity, int cruisingSpeed,
            int emptyWeight, int tankCapacity, int fuelConsumption) {

        super(id, manufacturer, modelName, maxSpeed, practicalCeiling, practicalRange);
        this.length = length;
        this.height = height;
        this.fuselageWidth = fuselageWidth;
        this.crew = crew;
        this.passengerCapacity = passengerCapacity;
        this.cargoCapacity = cargoCapacity;
        this.cruisingSpeed = cruisingSpeed;
        this.emptyWeight = emptyWeight;
        this.tankCapacity = tankCapacity;
        this.cruisingSpeed = fuelConsumption;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getFuselageWidth() {
        return fuselageWidth;
    }

    public void setFuselageWidth(double fuselageWidth) {
        this.fuselageWidth = fuselageWidth;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public double getCruisingSpeed() {
        return cruisingSpeed;
    }

    public void setCruisingSpeed(int cruisingSpeed) {
        this.cruisingSpeed = cruisingSpeed;
    }

    public int getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(int emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
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

        Plane plane = (Plane) obj;
        return length == plane.length
                && height == plane.height
                && fuselageWidth == plane.fuselageWidth
                && crew == plane.crew
                && passengerCapacity == plane.passengerCapacity
                && cargoCapacity == plane.cargoCapacity
                && cruisingSpeed == plane.cruisingSpeed
                && emptyWeight == plane.emptyWeight
                && tankCapacity == plane.tankCapacity
                && fuelConsumption == plane.fuelConsumption;
    }

    @Override
    public int hashCode() {
        Object[] fields = new Object[]{length, height, fuselageWidth, crew,
            passengerCapacity, cargoCapacity, cruisingSpeed, emptyWeight,
            tankCapacity, fuelConsumption};
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
        str.append("length=").append(length).append(", ");
        str.append("height=").append(height).append(", ");
        str.append("fuselageWidth=").append(fuselageWidth).append(", ");
        str.append("crew=").append(crew).append(", ");
        str.append("passengerCapacity=").append(passengerCapacity).append(", ");
        str.append("cargoCapacity=").append(cargoCapacity).append(", ");
        str.append("cruisingSpeed=").append(cruisingSpeed).append(", ");
        str.append("emptyWeight=").append(emptyWeight).append(", ");
        str.append("tankCapacity=").append(tankCapacity).append(", ");
        str.append("fuelConsumption=").append(fuelConsumption);

        return str.toString();
    }
}
