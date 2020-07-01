package by.trjava.task02.service.setter;

import static by.trjava.task02.util.config.FieldConfig.*;

import by.trjava.task02.entity.Plane;
import by.trjava.task02.entity.PassengerPlane;
import by.trjava.task02.entity.CargoPlane;
import by.trjava.task02.entity.MailPlane;

import by.trjava.task02.service.exception.WrongParameterException;
import by.trjava.task02.service.repository.impl.PlaneRepositoryImpl;
import by.trjava.task02.service.setter.exception.PlaneSettingException;
import by.trjava.task02.service.type.Type.PlaneType;
import org.apache.log4j.Logger;

public final class PlaneSetter {

    private static final Logger LOGGER = Logger.getLogger(PlaneSetter.class);

    private PlaneSetter() {

    }

    public static void setFromLine(PlaneType planeType, Plane plane, String[] fieldsValues)
            throws PlaneSettingException, WrongParameterException {

        if (planeType == null || plane == null
                || fieldsValues == null || fieldsValues.length == 0) {
            LOGGER.warn("Method received wrong parameters!");
            throw new WrongParameterException("Method received wrong parameters!");
        }

        try {
            plane.setId(Long.parseLong(fieldsValues[ID]));
            plane.setManufacturer(fieldsValues[MANUFACTURER]);
            plane.setModelName(fieldsValues[MODEL_NAME]);
            plane.setMaxSpeed(Integer.parseInt(fieldsValues[MAX_SPEED]));

            plane.setPracticalCeiling(Integer.parseInt(fieldsValues[PRACTICAL_CEILING]));
            plane.setPracticalRange(Integer.parseInt(fieldsValues[PRACTICAL_RANGE]));

            plane.setLength(Double.parseDouble(fieldsValues[LENGTH]));
            plane.setHeight(Double.parseDouble(fieldsValues[HEIGHT]));
            plane.setFuselageWidth(Double.parseDouble(fieldsValues[FUSELAGE_WIDTH]));
            plane.setCrew(Integer.parseInt(fieldsValues[CREW]));
            plane.setPassengerCapacity(Integer.parseInt(fieldsValues[PASSENGER_CAPACITY]));
            plane.setCargoCapacity(Double.parseDouble(fieldsValues[CARGO_CAPACITY]));
            plane.setCruisingSpeed(Integer.parseInt(fieldsValues[CRUISING_SPEED]));
            plane.setEmptyWeight(Integer.parseInt(fieldsValues[EMPTY_WEIGHT]));
            plane.setTankCapacity(Integer.parseInt(fieldsValues[TANK_CAPACITY]));
            plane.setFuelConsumption(Integer.parseInt(fieldsValues[FUEL_CONSUMPTION]));

            switch (planeType) {
                case PassengerPlane:
                    PassengerPlane passengerPlane = ((PassengerPlane) plane);
                    passengerPlane.setCabinWidth(Double.parseDouble(fieldsValues[CABIN_WIDTH]));
                    passengerPlane.setAmountOfSeatsInRow(Integer.parseInt(fieldsValues[AMOUNT_OF_SEATS_IN_ROW]));
                    passengerPlane.setLuggageShelfVolume(Double.parseDouble(fieldsValues[LUGGAGE_SHELF_VOLUME]));
                    break;
                case CargoPlane:
                    CargoPlane cargoPlane = ((CargoPlane) plane);
                    cargoPlane.setCargoCompartmentLength(Double.parseDouble(fieldsValues[CARGO_COMPARTMENT_LENGTH]));
                    cargoPlane.setMaxPayload(Integer.parseInt(fieldsValues[MAX_PAYLOAD]));
                    break;
                case MailPlane:
                    MailPlane mailPlane = ((MailPlane) plane);
                    mailPlane.setMaxMailContainersAmount(Integer.parseInt(fieldsValues[MAX_MAIL_CONTAINERS_AMOUNT]));
                    break;
                default:
                    LOGGER.warn("Plane setting failed!"
                            + " Wrong type of plane " + "{" + planeType + "}");
                    throw new PlaneSettingException("Plane setting failed!"
                            + " Wrong type of plane " + "{" + planeType + "}");
            }
        } catch (Exception e) {
            LOGGER.warn("\"Plane setting failed!");
            throw new PlaneSettingException("Plane setting failed!", e);
        }
    }
}
