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
 * <p>Java class for cutMethod.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="cutMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="round"/>
 *     &lt;enumeration value="asscher"/>
 *     &lt;enumeration value="emerald"/>
 *     &lt;enumeration value="oval"/>
 *     &lt;enumeration value="marquise"/>
 *     &lt;enumeration value="pear"/>
 *     &lt;enumeration value="radiant"/>
 *     &lt;enumeration value="princess"/>
 *     &lt;enumeration value="heart"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "cutMethod")
@XmlEnum
public enum CutMethod {

    @XmlEnumValue("round")
    ROUND("round"),
    @XmlEnumValue("asscher")
    ASSCHER("asscher"),
    @XmlEnumValue("emerald")
    EMERALD("emerald"),
    @XmlEnumValue("oval")
    OVAL("oval"),
    @XmlEnumValue("marquise")
    MARQUISE("marquise"),
    @XmlEnumValue("pear")
    PEAR("pear"),
    @XmlEnumValue("radiant")
    RADIANT("radiant"),
    @XmlEnumValue("princess")
    PRINCESS("princess"),
    @XmlEnumValue("heart")
    HEART("heart");
    private final String value;

    CutMethod(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CutMethod fromValue(String v) {
        for (CutMethod c: CutMethod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}