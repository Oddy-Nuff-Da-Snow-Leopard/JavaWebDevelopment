package by.trjava.task02.util.config;

public final class FieldConfig {

    // Vehicle class fields.
    public static final int ID = 0;
    public static final int MANUFACTURER = 1;
    public static final int MODEL_NAME = 2;
    public static final int MAX_SPEED = 3;

    // AirVehicle class fields.
    public static final int PRACTICAL_CEILING = 4;
    public static final int PRACTICAL_RANGE = 5;

    // Plane class fields.
    public static final int LENGTH = 6;
    public static final int HEIGHT = 7;
    public static final int FUSELAGE_WIDTH = 8;
    public static final int CREW = 9;
    public static final int PASSENGER_CAPACITY = 10;
    public static final int CARGO_CAPACITY = 11;
    public static final int CRUISING_SPEED = 12;
    public static final int EMPTY_WEIGHT = 13;
    public static final int TANK_CAPACITY = 14;
    public static final int FUEL_CONSUMPTION = 15;

    // PassengerPlane class fields.
    public static final int CABIN_WIDTH = 16;
    public static final int AMOUNT_OF_SEATS_IN_ROW = 17;
    public static final int LUGGAGE_SHELF_VOLUME = 18;

    // CargoPlane class fields.
    public static final int CARGO_COMPARTMENT_LENGTH = 16;
    public static final int MAX_PAYLOAD = 17;

    // MailPlane class fields.
    public static final int MAX_MAIL_CONTAINERS_AMOUNT = 16;

    private FieldConfig() {

    }
}
