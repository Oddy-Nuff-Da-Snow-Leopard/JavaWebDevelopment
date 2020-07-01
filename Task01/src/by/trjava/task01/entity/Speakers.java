package by.trjava.task01.entity;

import by.trjava.task01.service.Parser;
import java.util.Objects;

/**
 * Class {@code Speakers} represents speakers.
 *
 * @author Alekseev Maksim
 */
public class Speakers implements Appliance {

    private int powerConsumption;
    private int numberOfSpeakers;
    private String frequencyRange;
    private int cordLength;

    public Speakers() {
    }

    public Speakers(int powerConsumption, int numberOfSpeakers,
            String frequencyRange, int cordLength) {
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLength = cordLength;
    }

    /**
     * @return the {@link Speakers#powerConsumption} of the speakers.
     */
    public double getPowerConsumption() {
        return powerConsumption;
    }

    /**
     * @return the {@link Speakers#numberOfSpeakers} of the speakers.
     */
    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    /**
     * @return the {@link Laptop#frequencyRange} of the speakers.
     */
    public String getFrequencyRange() {
        return frequencyRange;
    }

    /**
     * @return the {@link Laptop#cordLength} of the speakers.
     */
    public int getCordLength() {
        return cordLength;
    }

    /**
     * Sets the power consumption of the speakers.
     *
     * @param powerConsumption the integer value to be set in
     * {@link Speakers#powerConsumption}.
     */
    public void setPowerConsumption(int powerConsumption) {
        if (powerConsumption > 0) {
            this.powerConsumption = powerConsumption;
        }
    }

    /**
     * Sets the number of speakers of the speakers.
     *
     * @param numberOfSpeakers the integer value to be set in
     * {@link Speakers#numberOfSpeakers}.
     */
    public void setNumberOfSpeakers(int numberOfSpeakers) {
        if (numberOfSpeakers > 0) {
            this.numberOfSpeakers = numberOfSpeakers;
        }
    }

    /**
     * Sets the frequency range of the speakers.
     *
     * @param frequencyRange the string value to be set in
     * {@link Speakers#frequencyRange}.
     */
    public void setFrequencyRange(String frequencyRange) {
        if (frequencyRange != null) {
            this.frequencyRange = frequencyRange;
        }
    }

    /**
     * Sets the cord length of the speakers.
     *
     * @param cordLength the integer value to be set in
     * {@link Speakers#cordLength}.
     */
    public void setCordLength(int cordLength) {
        if (cordLength > 0) {
            this.cordLength = cordLength;
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
        setNumberOfSpeakers(Parser.parseInt(str, "NUMBER_OF_SPEAKERS"));
        setFrequencyRange(Parser.parseString(str, "FREQUENCY_RANGE"));
        setCordLength(Parser.parseInt(str, "CORD_LENGTH"));
    }

    /**
     * Compares this object to the specified object. The result is {@code true}
     * if and only if the argument is not {@code null} and is an {@code Laptop}
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

        Speakers speakers = (Speakers) obj;
        return powerConsumption == speakers.powerConsumption
                && numberOfSpeakers == speakers.numberOfSpeakers
                && frequencyRange.equals(speakers.frequencyRange)
                && cordLength == speakers.cordLength;
    }

    /**
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, numberOfSpeakers,
                frequencyRange, cordLength);
    }

    /**
     * @return a {@code String} representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Speakers : POWER_CONSUMPTION=");
        str.append(powerConsumption);
        str.append(", NUMBER_OF_SPEAKERS=");
        str.append(numberOfSpeakers);
        str.append(", FREQUENCY_RANGE=");
        str.append(frequencyRange);
        str.append(", CORD_LENGTH=");
        str.append(cordLength);
        return str.toString();
    }
}
