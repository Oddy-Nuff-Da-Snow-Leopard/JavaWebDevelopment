//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.09.13 at 05:39:39 AM MSK 
//


package by.trjava.task03.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for preciousness.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="preciousness">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="precious"/>
 *     &lt;enumeration value="semiprecious"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "preciousness")
@XmlEnum
public enum Preciousness {

    @XmlEnumValue("precious")
    PRECIOUS("precious"),
    @XmlEnumValue("semiprecious")
    SEMIPRECIOUS("semiprecious");
    private final String value;

    Preciousness(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Preciousness fromValue(String v) {
        for (Preciousness c: Preciousness.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
