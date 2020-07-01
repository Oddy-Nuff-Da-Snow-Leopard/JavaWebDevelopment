package by.trjava.task02.entity;

public class MailPlane extends Plane {

    private int maxMailContainersAmount;

    public MailPlane() {

    }

    public MailPlane(long id, String manufacturer, String modelName) {
        super(id, manufacturer, modelName);
    }

    public MailPlane(long id, String manufacturer, String modelName,
            int maxSpeed, int practicalCeiling, int practicalRange,
            double length, double height, double fuselageWidth, int crew,
            int passengerCapacity, double cargoCapacity, int cruisingSpeed,
            int emptyWeight, int tankCapacity, int fuelConsumption,
            int maxMailContainersAmount) {

        super(id, manufacturer, modelName, maxSpeed, practicalCeiling,
                practicalRange, length, height, fuselageWidth, crew,
                passengerCapacity, cargoCapacity, cruisingSpeed,
                emptyWeight, tankCapacity, fuelConsumption);

        this.maxMailContainersAmount = maxMailContainersAmount;
    }

    public int getMaxMailContainersAmount() {
        return maxMailContainersAmount;
    }

    public void setMaxMailContainersAmount(int maxMailContainersAmount) {
        this.maxMailContainersAmount = maxMailContainersAmount;
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

        MailPlane mailPlane = (MailPlane) obj;
        return maxMailContainersAmount == mailPlane.maxMailContainersAmount;
    }

    @Override
    public int hashCode() {
        Object[] fields = new Object[]{maxMailContainersAmount};
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
        str.append("mailContainersAmount=").append(maxMailContainersAmount);
        return str.toString();
    }
}
