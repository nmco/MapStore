//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.13 at 10:49:44 AM CEST 
//

package eu.europa.emsa.csndc;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * NetCDF files describing meteo features (wind, wave) derived from the original satellite image
 * 
 * <p>
 * Java class for SARDerivedDataType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SARDerivedDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.emsa.europa.eu/csndc}sarDerivedDataReference" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SARDerivedDataType", propOrder = { "sarDerivedDataReference" })
public class SARDerivedDataType {

    @XmlElement(required = true)
    protected List<SARDerivedDataReferenceType> sarDerivedDataReference;

    /**
     * List of references to the meteo conditions derived from the SAR image Gets the value of the sarDerivedDataReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be
     * present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the sarDerivedDataReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getSarDerivedDataReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link SARDerivedDataReferenceType }
     * 
     * 
     */
    public List<SARDerivedDataReferenceType> getSarDerivedDataReference() {
        if (sarDerivedDataReference == null) {
            sarDerivedDataReference = new ArrayList<SARDerivedDataReferenceType>();
        }
        return this.sarDerivedDataReference;
    }

}
