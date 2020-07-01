package by.trjava.task03.entity.tag;

public enum GemXmlTag {
    GEMS("gems"),
    GEM("gem"),
    ID("id"),
    PRECIOUSNESS("preciousness"),
    NAME("name"),
    ORIGIN("origin"),
    APPEARANCE("appearance"),
    PROPERTIES("properties"),
    WEIGHT("weight"),
    COLOR("color"),
    TRANSPARENCY("transparency"),
    CUT_METHOD("cutMethod"),
    DENSITY("density"),
    REFRACTIVE_INDEX("refractiveIndex"),
    MOHS_HARDNESS("MohsHardness");

    private final String value;

    GemXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static GemXmlTag fromValue(String value) {
        for (GemXmlTag e : GemXmlTag.values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException(value);
    }
}
