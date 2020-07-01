package by.trjava.task01.entity;

import by.trjava.task01.service.Parser;
import java.util.Objects;

/**
 * Class {@code Refrigerator} represents refrigerator.
 *
 * @author Alekseev Maksim
 */
public class Refrigerator implements Appliance {

    private int powerConsumption;
    private int weight;
    private int freezerCapacity;
    private double overallCapacity;
    private double height;
    private double width;

    public Refrigerator() {
    }

    public Refrigerator(int powerConsumption, int weight, int freezerCapacity,
            double overallCapacity, double height, double width) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.freezerCapacity = freezerCapacity;
        this.overallCapacity = overallCapacity;
        this.height = height;
        this.width = width;
    }

    /**
     * @return the {@link Refrigerator#powerConsumption} of the refrigerator.
     */
    public int getPowerConsumption() {
        return powerConsumption;
    }

    /**
     * @return the {@link Refrigerator#weight} of the refrigerator.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @return the {@link Refrigerator#freezerCapacity} of the refrigerator.
     */
    public int getFreezerCapacity() {
        return freezerCapacity;
    }

    /**
     * @return the {@link Refrigerator#overallCapacity} of the refrigerator.
     */
    public double getOverallCapacity() {
        return overallCapacity;
    }

    /**
     * @return the {@link Refrigerator#height} of the refrigerator.
     */
    public double getHeight() {
        return height;
    }

    /**
     * @return the {@link Refrigerator#width} of the refrigerator.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the power consumption of the refrigerator.
     *
     * @param powerConsumption the integer value to be set in
     * {@link Refrigerator#powerConsumption}.
     */
    public void setPowerConsumption(int powerConsumption) {
        if (powerConsumption > 0) {
            this.powerConsumption = powerConsumption;
        }
    }

    /**
     * Sets the weight of the refrigerator.
     *
     * @param weight the integer value to be set in {@link Refrigerator#weight}.
     */
    public void setWeight(int weight) {
        if (weight > 0) {
            this.weight = weight;
        }
    }

    /**
     * Sets the freezer capacity of the refrigerator.
     *
     * @param freezerCapacity the integer value to be set in
     * {@link Refrigerator#freezerCapacity}.
     */
    public void setFreezerCapacity(int freezerCapacity) {
        if (freezerCapacity > 0) {
            this.freezerCapacity = freezerCapacity;
        }
    }

    /**
     * Sets the overall capacity of the refrigerator.
     *
     * @param overallCapacity the double value to be set in
     * {@link Refrigerator#overallCapacity}.
     */
    public void setOverallCapacity(double overallCapacity) {
        if (overallCapacity > 0) {
            this.overallCapacity = overallCapacity;
        }
    }

    /**
     * Sets the height of the refrigerator.
     *
     * @param height the double value to be set in {@link Refrigerator#height}.
     */
    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        }
    }

    /**
     * Sets the width of the refrigerator.
     *
     * @param width the double value to be set in {@link Refrigerator#width}.
     */
    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        }
    }

    /**
     * Sets all fields of the object, using class {@link Parser}.
     *
     * @param str the String value, that represents the string from which
     * information will be taken to set the fields of the object.
     */
    @Override
    public void setFromString(String str) {
        setPowerConsumption(Parser.parseInt(str, "POWER_CONSUMPTION"));
        setFreezerCapacity(Parser.parseInt(str, "FREEZER_CAPACITY"));
        setWeight(Parser.parseInt(str, "WEIGHT"));
        setOverallCapacity(Parser.parseDouble(str, "OVERALL_CAPACITY"));
        setHeight(Parser.parseDouble(str, "HEIGHT"));
        setWidth(Parser.parseDouble(str, "WIDTH"));
    }

    /**
     * Compares this object to the specified object. The result is {@code true}
     * if and only if the argument is not {@code null} and is an
     * {@code Refrigerator} object that contains the same value of all fields as
     * this object.
     *
     * @param obj the object to compared.
     * @return {@code true} if the objects have the same fields. {@code false}
     * otherwise.
     */
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
        Refrigerator refrigerator = (Refrigerator) obj;
        return powerConsumption == refrigerator.powerConsumption && weight == refrigerator.weight
                && freezerCapacity == refrigerator.freezerCapacity && overallCapacity == refrigerator.overallCapacity
                && height == refrigerator.height && weight == refrigerator.width;
    }

    /**
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, weight, freezerCapacity, overallCapacity, height, width);
    }

    /**
     * @return a {@code String} representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Refrigerator : POWER_CONSUMPTION=");
        str.append(powerConsumption);
        str.append(", WEIGHT=");
        str.append(weight);
        str.append(", FREEZER_CAPACITY=");
        str.append(freezerCapacity);
        str.append(", OVERALL_CAPACITY=");
        str.append(overallCapacity);
        str.append(", HEIGHT=");
        str.append(height);
        str.append(", WIDTH=");
        str.append(width);
        return str.toString();
    }
}
