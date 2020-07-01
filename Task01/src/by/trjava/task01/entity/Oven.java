package by.trjava.task01.entity;

import by.trjava.task01.service.Parser;
import java.util.Objects;

/**
 * Class {@code Oven} represents oven.
 *
 * @author Alekseev Makism
 */
public class Oven implements Appliance {

    private int powerConsumption;
    private int weight;
    private int capacity;
    private double depth;
    private double height;
    private double width;

    public Oven() {
    }

    public Oven(int powerConsumption, int weight, int capacity, double depth,
            double height, double width) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.capacity = capacity;
        this.depth = depth;
        this.height = height;
        this.width = width;
    }

    /**
     * @return the {@link Oven#powerConsumption} of the oven.
     */
    public int getPowerConsumption() {
        return powerConsumption;
    }

    /**
     * @return the {@link Oven#weight} of the oven.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @return the {@link Oven#capacity} of the oven.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @return the {@link Oven#depth} of the oven.
     */
    public double getDepth() {
        return depth;
    }

    /**
     * @return the {@link Oven#height} of the oven.
     */
    public double getHeight() {
        return height;
    }

    /**
     * @return the {@link Oven#width} of the oven.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the power consumption of the oven.
     *
     * @param powerConsumption the integer value to be set in
     * {@link Oven#powerConsumption}.
     */
    public void setPowerConsumption(int powerConsumption) {
        if (powerConsumption > 0) {
            this.powerConsumption = powerConsumption;
        }
    }

    /**
     * Sets the weight of the oven.
     *
     * @param weight the integer value to be set in {@link Oven#weight}.
     */
    public void setWeight(int weight) {
        if (weight > 0) {
            this.weight = weight;
        }
    }

    /**
     * Sets the capacity of the oven.
     *
     * @param capacity the integer value to be set in {@link Oven#capacity}.
     */
    public void setCapacity(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        }
    }

    /**
     * Sets the depth of the oven.
     *
     * @param depth the integer value to be set in {@link Oven#depth}.
     */
    public void setDepth(double depth) {
        if (depth > 0) {
            this.depth = depth;
        }
    }

    /**
     * Sets the height of the oven.
     *
     * @param height the double value to be set in {@link Oven#height}.
     */
    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        }
    }

    /**
     * Sets the width of the oven.
     *
     * @param width the double value to be set in {@link Oven#width}.
     */
    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        }
    }

    @Override
    public void setFromString(String str) {
        setPowerConsumption(Parser.parseInt(str, "POWER_CONSUMPTION"));
        setWeight(Parser.parseInt(str, "WEIGHT"));
        setCapacity(Parser.parseInt(str, "CAPACITY"));
        setDepth(Parser.parseDouble(str, "DEPTH"));
        setHeight(Parser.parseDouble(str, "HEIGHT"));
        setWidth(Parser.parseDouble(str, "WIDTH"));
    }

    /**
     * Compares this object to the specified object. The result is {@code true}
     * if and only if the argument is not {@code null} and is an {@code Oven}
     * object that contains the same value of all fields as this object.
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
        Oven oven = (Oven) obj;
        return powerConsumption == oven.powerConsumption
                && weight == oven.weight
                && capacity == oven.capacity
                && depth == oven.depth
                && height == oven.height
                && width == oven.width;
    }

    /**
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(capacity, powerConsumption, weight, depth, height, width);
    }

    /**
     * @return a {@code String} representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Oven : POWER_CONSUMPTION=");
        str.append(powerConsumption);
        str.append(", WEIGHT=");
        str.append(weight);
        str.append(", CAPACITY=");
        str.append(capacity);
        str.append(", DEPTH=");
        str.append(depth);
        str.append(", HEIGHT=");
        str.append(height);
        str.append(", WIDTH=");
        str.append(width);
        return str.toString();
    }
}
