package by.trjava.task02.entity;

public class PassengerPlane extends Plane {

    private double cabinWidth;

    private int amountOfSeatsInRow;

    private double luggageShelfVolume;

    public PassengerPlane() {

    }

    public PassengerPlane(long id, String manufacturer, String modelName) {
        super(id, manufacturer, modelName);
    }

    public PassengerPlane(long id, String manufacturer, String modelName,
            int maxSpeed, int practicalCeiling, int practicalRange,
            double length, double height, double fuselageWidth, int crew,
            int passengerCapacity, double cargoCapacity, int cruisingSpeed,
            int emptyWeight, int tankCapacity, int fuelConsumption,
            double cabinWidth, int amountOfSeatsInRow, int luggageShelfVolume) {

        super(id, manufacturer, modelName, maxSpeed, practicalCeiling,
                practicalRange, length, height, fuselageWidth, crew,
                passengerCapacity, cargoCapacity, cruisingSpeed,
                emptyWeight, tankCapacity, fuelConsumption);

        this.cabinWidth = cabinWidth;
        this.amountOfSeatsInRow = amountOfSeatsInRow;
        this.luggageShelfVolume = luggageShelfVolume;
    }

    public double getCabinWidth() {
        return cabinWidth;
    }

    public void setCabinWidth(double cabinWidth) {
        this.cabinWidth = cabinWidth;
    }

    public int getAmountOfSeatsInRow() {
        return amountOfSeatsInRow;
    }

    public void setAmountOfSeatsInRow(int amountOfSeatsInRow) {
        this.amountOfSeatsInRow = amountOfSeatsInRow;
    }

    public double getLuggageShelfVolume() {
        return luggageShelfVolume;
    }

    public void setLuggageShelfVolume(double luggageShelfVolume) {
        this.luggageShelfVolume = luggageShelfVolume;
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

        PassengerPlane passengerPlane = (PassengerPlane) obj;
        return cabinWidth == passengerPlane.cabinWidth
                && amountOfSeatsInRow == passengerPlane.amountOfSeatsInRow
                && luggageShelfVolume == passengerPlane.luggageShelfVolume;
    }

    @Override
    public int hashCode() {
        Object[] fields = new Object[]{cabinWidth, amountOfSeatsInRow,
            luggageShelfVolume};
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
        str.append("cabinWidth=").append(cabinWidth).append(", ");
        str.append("amountOfSeatsInRow=").append(amountOfSeatsInRow).append(", ");
        str.append("luggageShelfVolume=").append(luggageShelfVolume);
        return str.toString();
    }
}
