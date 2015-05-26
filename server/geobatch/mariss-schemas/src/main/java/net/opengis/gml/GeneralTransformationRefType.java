//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.13 at 10:49:44 AM CEST 
//

package net.opengis.gml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import org.w3._1999.xlink.ActuateType;
import org.w3._1999.xlink.ShowType;
import org.w3._1999.xlink.TypeType;

/**
 * Association to a general transformation, either referencing or containing the definition of that transformation.
 * 
 * <p>
 * Java class for GeneralTransformationRefType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeneralTransformationRefType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element ref="{http://www.opengis.net/gml}_GeneralTransformation"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opengis.net/gml}AssociationAttributeGroup"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneralTransformationRefType", propOrder = { "generalTransformation" })
public class GeneralTransformationRefType {

    @XmlElementRef(name = "_GeneralTransformation", namespace = "http://www.opengis.net/gml", type = JAXBElement.class)
    protected JAXBElement<? extends AbstractGeneralTransformationType> generalTransformation;

    @XmlAttribute(namespace = "http://www.opengis.net/gml")
    @XmlSchemaType(name = "anyURI")
    protected String remoteSchema;

    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    protected TypeType type;

    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    protected String href;

    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    protected String role;

    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    protected String arcrole;

    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    protected String title;

    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    protected ShowType show;

    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    protected ActuateType actuate;

    /**
     * Gets the value of the actuate property.
     * 
     * @return possible object is {@link ActuateType }
     * 
     */
    public ActuateType getActuate() {
        return actuate;
    }

    /**
     * Gets the value of the arcrole property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getArcrole() {
        return arcrole;
    }

    /**
     * Gets the value of the generalTransformation property.
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link AbstractGeneralTransformationType }{@code >} {@link JAXBElement }{@code <}
     *         {@link TransformationType }{@code >}
     * 
     */
    public JAXBElement<? extends AbstractGeneralTransformationType> getGeneralTransformation() {
        return generalTransformation;
    }

    /**
     * Gets the value of the href property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getHref() {
        return href;
    }

    /**
     * Gets the value of the remoteSchema property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getRemoteSchema() {
        return remoteSchema;
    }

    /**
     * Gets the value of the role property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getRole() {
        return role;
    }

    /**
     * Gets the value of the show property.
     * 
     * @return possible object is {@link ShowType }
     * 
     */
    public ShowType getShow() {
        return show;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return possible object is {@link TypeType }
     * 
     */
    public TypeType getType() {
        if (type == null) {
            return TypeType.SIMPLE;
        } else {
            return type;
        }
    }

    /**
     * Sets the value of the actuate property.
     * 
     * @param value allowed object is {@link ActuateType }
     * 
     */
    public void setActuate(ActuateType value) {
        this.actuate = value;
    }

    /**
     * Sets the value of the arcrole property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setArcrole(String value) {
        this.arcrole = value;
    }

    /**
     * Sets the value of the generalTransformation property.
     * 
     * @param value allowed object is {@link JAXBElement }{@code <}{@link AbstractGeneralTransformationType }{@code >} {@link JAXBElement }{@code <}
     *        {@link TransformationType }{@code >}
     * 
     */
    public void setGeneralTransformation(
            JAXBElement<? extends AbstractGeneralTransformationType> value) {
        this.generalTransformation = ((JAXBElement<? extends AbstractGeneralTransformationType>) value);
    }

    /**
     * Sets the value of the href property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setHref(String value) {
        this.href = value;
    }

    /**
     * Sets the value of the remoteSchema property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setRemoteSchema(String value) {
        this.remoteSchema = value;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setRole(String value) {
        this.role = value;
    }

    /**
     * Sets the value of the show property.
     * 
     * @param value allowed object is {@link ShowType }
     * 
     */
    public void setShow(ShowType value) {
        this.show = value;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value allowed object is {@link TypeType }
     * 
     */
    public void setType(TypeType value) {
        this.type = value;
    }

}
