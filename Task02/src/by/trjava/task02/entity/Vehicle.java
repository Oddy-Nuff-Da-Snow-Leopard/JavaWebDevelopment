package by.trjava.task02.entity;

public abstract class Vehicle {

    private long id;

    private String manufacturer;

    private String modelName;

    private int maxSpeed;

    public Vehicle() {

    }

    public Vehicle(long id, String manufacturer, String modelName) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.modelName = modelName;
    }

    public Vehicle(long id, String manufacturer, String modelName, int maxSpeed) {
        this(id, manufacturer, modelName);
        this.maxSpeed = maxSpeed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
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

        Vehicle vehicle = (Vehicle) obj;
        return id == vehicle.id
                && manufacturer.equals(vehicle.manufacturer)
                && modelName.equals(vehicle.modelName)
                && maxSpeed == vehicle.maxSpeed;
    }

    @Override
    public int hashCode() {
        Object[] fields = new Object[]{id, manufacturer, modelName, maxSpeed};
        int result = 1;
        for (Object field : fields) {
            result = 31 * result + (field == null ? 0 : field.hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString()).append("\n");
        str.append("id=").append(id).append(", ");
        str.append("manufacturer=").append(manufacturer).append(", ");
        str.append("modelName=").append(modelName).append(", ");
        str.append("maxSpeed=").append(maxSpeed);
        return str.toString();
    }
}
