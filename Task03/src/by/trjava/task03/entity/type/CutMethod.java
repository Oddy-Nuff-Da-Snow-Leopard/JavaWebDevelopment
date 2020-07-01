package by.trjava.task03.entity.type;

public enum CutMethod {
    ROUND("round"),
    ASSCHER("asscher"),
    EMERALD("emerald"),
    OVAL("oval"),
    MARQUISE("marquise"),
    PEAR("pear"),
    RADIANT("radiant"),
    PRINCESS("princess"),
    HEART("heart");

    private final String value;

    CutMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CutMethod fromValue(String value) {
        for (CutMethod e : CutMethod.values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException(value);
    }
}
