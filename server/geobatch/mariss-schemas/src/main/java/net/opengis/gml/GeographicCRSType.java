//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.13 at 10:49:44 AM CEST 
//

package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * A coordinate reference system based on an ellipsoidal approximation of the geoid; this provides an accurate representation of the geometry of
 * geographic features for a large portion of the earth's surface.
 * 
 * <p>
 * Java class for GeographicCRSType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeographicCRSType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractReferenceSystemType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}usesEllipsoidalCS"/>
 *         &lt;element ref="{http://www.opengis.net/gml}usesGeodeticDatum"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeographicCRSType", propOrder = { "usesEllipsoidalCS", "usesGeodeticDatum" })
public class GeographicCRSType extends AbstractReferenceSystemType {

    @XmlElement(required = true)
    protected EllipsoidalCSRefType usesEllipsoidalCS;

    @XmlElement(required = true)
    protected GeodeticDatumRefType usesGeodeticDatum;

    /**
     * Gets the value of the usesEllipsoidalCS property.
     * 
     * @return possible object is {@link EllipsoidalCSRefType }
     * 
     */
    public EllipsoidalCSRefType getUsesEllipsoidalCS() {
        return usesEllipsoidalCS;
    }

    /**
     * Gets the value of the usesGeodeticDatum property.
     * 
     * @return possible object is {@link GeodeticDatumRefType }
     * 
     */
    public GeodeticDatumRefType getUsesGeodeticDatum() {
        return usesGeodeticDatum;
    }

    /**
     * Sets the value of the usesEllipsoidalCS property.
     * 
     * @param value allowed object is {@link EllipsoidalCSRefType }
     * 
     */
    public void setUsesEllipsoidalCS(EllipsoidalCSRefType value) {
        this.usesEllipsoidalCS = value;
    }

    /**
     * Sets the value of the usesGeodeticDatum property.
     * 
     * @param value allowed object is {@link GeodeticDatumRefType }
     * 
     */
    public void setUsesGeodeticDatum(GeodeticDatumRefType value) {
        this.usesGeodeticDatum = value;
    }

}
