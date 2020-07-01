package by.trjava.task01.entity;

import by.trjava.task01.service.Parser;
import java.util.Objects;

/**
 * Class {@code Laptop} represents a laptop.
 *
 * @author Alekseev Maksim
 */
public class Laptop implements Appliance {

    private double batteryCapacity;
    private String operationSystem;
    private int memoryROM;
    private int systemMemory;
    private double cpu;
    private int displayInchs;

    public Laptop() {
    }

    public Laptop(double batteryCapacity, String operationSystem, int memoryROM,
            int systemMemory, double cpu, int displayInchs) {
        this.batteryCapacity = batteryCapacity;
        this.operationSystem = operationSystem;
        this.memoryROM = memoryROM;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
        this.displayInchs = displayInchs;
    }

    /**
     * @return the {@link Laptop#batteryCapacity} of the laptop.
     */
    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    /**
     * @return the {@link Laptop#operationSystem} of the laptop.
     */
    public String getOperationSystem() {
        return operationSystem;
    }

    /**
     * @return the {@link Laptop#memoryROM} of the laptop.
     */
    public int getMemoryROM() {
        return memoryROM;
    }

    /**
     * @return the {@link Laptop#systemMemory} of the laptop.
     */
    public int getSystemMemory() {
        return systemMemory;
    }

    /**
     * @return the {@link Laptop#cpu} of the laptop.
     */
    public double getCpu() {
        return cpu;
    }

    /**
     * @return the {@link Laptop#displayInchs} of the laptop.
     */
    public int getDisplayINCHS() {
        return displayInchs;
    }

    /**
     * Sets the battery capacity of the laptop.
     *
     * @param batteryCapacity the double value to be set in
     * {@link Laptop#batteryCapacity}.
     */
    public void setBatteryCapacity(double batteryCapacity) {
        if (batteryCapacity > 0) {
            this.batteryCapacity = batteryCapacity;
        }
    }

    /**
     * Sets the operation system of the laptop.
     *
     * @param operationSystem the String value to be set in
     * {@link Laptop#operationSystem}.
     */
    public void setOperationSystem(String operationSystem) {
        if (operationSystem != null) {
            this.operationSystem = operationSystem;
        }
    }

    /**
     * Sets the memory ROM of the laptop.
     *
     * @param memoryROM the integer value to be set in {@link Laptop#memoryROM}.
     */
    public void setMemoryROM(int memoryROM) {
        if (memoryROM > 0) {
            this.memoryROM = memoryROM;
        }
    }

    /**
     * Sets the system memory of the laptop.
     *
     * @param systemMemory the integer value to be set in
     * {@link Laptop#systemMemory}.
     */
    public void setSystemMemory(int systemMemory) {
        if (systemMemory > 0) {
            this.systemMemory = systemMemory;
        }
    }

    /**
     * Sets the CPU of the laptop.
     *
     * @param cpu the double value to be set in {@link Laptop#cpu}.
     */
    public void setCpu(double cpu) {
        if (cpu > 0) {
            this.cpu = cpu;
        }
    }

    /**
     * Sets the display inches of the laptop.
     *
     * @param displayInchs the integer value to be set in
     * {@link Laptop#displayINCHS}.
     */
    public void setDisplayINCHS(int displayInchs) {
        if (displayInchs > 0) {
            this.displayInchs = displayInchs;
        }
    }

    /**
     * Sets all fields of the laptop object, using class {@link Parser}.
     *
     * @param str the String value, that represents the string from which
     * information will be taken to set the fields of the laptop object.
     */
    @Override
    public void setFromString(String str) {
        setBatteryCapacity(Parser.parseDouble(str, "BATTERY_CAPACITY"));
        setMemoryROM(Parser.parseInt(str, "MEMORY_ROM"));
        setOperationSystem(Parser.parseString(str, "OS"));
        setSystemMemory(Parser.parseInt(str, "SYSTEM_MEMORY"));
        setCpu(Parser.parseDouble(str, "CPU"));
        setDisplayINCHS(Parser.parseInt(str, "DISPLAY_INCHS"));
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

        Laptop laptop = (Laptop) obj;
        return batteryCapacity == laptop.batteryCapacity
                && operationSystem.equals(laptop.operationSystem)
                && memoryROM == laptop.memoryROM
                && systemMemory == laptop.systemMemory
                && cpu == laptop.cpu
                && displayInchs == laptop.displayInchs;
    }

    /**
     * @return a hash code value for the laptop object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, operationSystem,
                memoryROM, systemMemory, cpu, displayInchs);
    }

    /**
     * @return a {@code String} representation of the laptop object.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Laptop : BATTERY_CAPACITY=");
        str.append(batteryCapacity);
        str.append(", OS=");
        str.append(operationSystem);
        str.append(", MEMORY_ROM=");
        str.append(memoryROM);
        str.append(", SYSTEM_MEMORY=");
        str.append(systemMemory);
        str.append(", CPU=");
        str.append(cpu);
        str.append(", DISPLAY_INCHS=");
        str.append(displayInchs);
        return str.toString();
    }
}
