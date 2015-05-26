//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.11.04 at 04:46:33 PM CET 
//

package it.geosolutions.geobatch.metocs.jaxb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for metocElementType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="metocElementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="brief" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="defaultUom" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="meteo"/>
 *             &lt;enumeration value="ocean"/>
 *             &lt;enumeration value="wave"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metocElementType", propOrder = { "name", "brief" })
public class MetocElementType {

    @XmlElement(required = true)
    protected String name;

    @XmlElement(required = true)
    protected String brief;

    @XmlAttribute(required = true)
    protected String defaultUom;

    @XmlAttribute(required = true)
    protected String type;

    /**
     * Gets the value of the brief property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getBrief() {
        return brief;
    }

    /**
     * Gets the value of the defaultUom property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getDefaultUom() {
        return defaultUom;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the brief property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setBrief(String value) {
        this.brief = value;
    }

    /**
     * Sets the value of the defaultUom property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setDefaultUom(String value) {
        this.defaultUom = value;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setType(String value) {
        this.type = value;
    }

}
