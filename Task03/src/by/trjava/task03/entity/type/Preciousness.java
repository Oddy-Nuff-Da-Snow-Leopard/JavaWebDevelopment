package by.trjava.task03.entity.type;

public enum Preciousness {

    PRECIOUS("precious"),
    SEMIPRECIOUS("semiprecious");

    private final String value;

    Preciousness(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Preciousness fromValue(String value) {
        for (Preciousness e : Preciousness.values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException(value);
    }

}
