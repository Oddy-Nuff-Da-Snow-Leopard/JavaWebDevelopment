//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.09.13 at 05:39:39 AM MSK 
//


package by.trjava.task03.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for appearance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="appearance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transparency" type="{http://www.trjava.by/task3}transparency"/>
 *         &lt;element name="cutMethod" type="{http://www.trjava.by/task3}cutMethod"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appearance", propOrder = {
    "color",
    "transparency",
    "cutMethod"
})
public class Appearance {

    @XmlElement(required = true)
    protected String color;
    @XmlElement(defaultValue = "80")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected int transparency;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CutMethod cutMethod;

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

    /**
     * Gets the value of the transparency property.
     * 
     */
    public int getTransparency() {
        return transparency;
    }

    /**
     * Sets the value of the transparency property.
     * 
     */
    public void setTransparency(int value) {
        this.transparency = value;
    }

    /**
     * Gets the value of the cutMethod property.
     * 
     * @return
     *     possible object is
     *     {@link CutMethod }
     *     
     */
    public CutMethod getCutMethod() {
        return cutMethod;
    }

    /**
     * Sets the value of the cutMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link CutMethod }
     *     
     */
    public void setCutMethod(CutMethod value) {
        this.cutMethod = value;
    }

}
