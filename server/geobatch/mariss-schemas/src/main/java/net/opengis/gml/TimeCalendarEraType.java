//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.13 at 10:49:44 AM CEST 
//

package net.opengis.gml;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * In every calendar, years are numbered relative to the date of a reference event that defines a calendar era. In this implementation, we omit the
 * back-pointer "datingSystem".
 * 
 * <p>
 * Java class for TimeCalendarEraType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeCalendarEraType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}DefinitionType">
 *       &lt;sequence>
 *         &lt;element name="referenceEvent" type="{http://www.opengis.net/gml}StringOrRefType"/>
 *         &lt;element name="referenceDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="julianReference" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="epochOfUse" type="{http://www.opengis.net/gml}TimePeriodPropertyType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeCalendarEraType", propOrder = { "referenceEvent", "referenceDate",
        "julianReference", "epochOfUse" })
public class TimeCalendarEraType extends DefinitionType {

    @XmlElement(required = true)
    protected StringOrRefType referenceEvent;

    @XmlElement(defaultValue = "0001-01-01")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar referenceDate;

    @XmlElement(required = true)
    protected BigDecimal julianReference;

    @XmlElement(required = true)
    protected TimePeriodPropertyType epochOfUse;

    /**
     * Gets the value of the epochOfUse property.
     * 
     * @return possible object is {@link TimePeriodPropertyType }
     * 
     */
    public TimePeriodPropertyType getEpochOfUse() {
        return epochOfUse;
    }

    /**
     * Gets the value of the julianReference property.
     * 
     * @return possible object is {@link BigDecimal }
     * 
     */
    public BigDecimal getJulianReference() {
        return julianReference;
    }

    /**
     * Gets the value of the referenceDate property.
     * 
     * @return possible object is {@link XMLGregorianCalendar }
     * 
     */
    public XMLGregorianCalendar getReferenceDate() {
        return referenceDate;
    }

    /**
     * Gets the value of the referenceEvent property.
     * 
     * @return possible object is {@link StringOrRefType }
     * 
     */
    public StringOrRefType getReferenceEvent() {
        return referenceEvent;
    }

    /**
     * Sets the value of the epochOfUse property.
     * 
     * @param value allowed object is {@link TimePeriodPropertyType }
     * 
     */
    public void setEpochOfUse(TimePeriodPropertyType value) {
        this.epochOfUse = value;
    }

    /**
     * Sets the value of the julianReference property.
     * 
     * @param value allowed object is {@link BigDecimal }
     * 
     */
    public void setJulianReference(BigDecimal value) {
        this.julianReference = value;
    }

    /**
     * Sets the value of the referenceDate property.
     * 
     * @param value allowed object is {@link XMLGregorianCalendar }
     * 
     */
    public void setReferenceDate(XMLGregorianCalendar value) {
        this.referenceDate = value;
    }

    /**
     * Sets the value of the referenceEvent property.
     * 
     * @param value allowed object is {@link StringOrRefType }
     * 
     */
    public void setReferenceEvent(StringOrRefType value) {
        this.referenceEvent = value;
    }

}
