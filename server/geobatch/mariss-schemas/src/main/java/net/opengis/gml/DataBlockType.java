//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.13 at 10:49:44 AM CEST 
//

package net.opengis.gml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DataBlockType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataBlockType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}rangeParameters"/>
 *         &lt;choice>
 *           &lt;element ref="{http://www.opengis.net/gml}tupleList"/>
 *           &lt;element ref="{http://www.opengis.net/gml}doubleOrNullTupleList"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataBlockType", propOrder = { "rangeParameters", "tupleList",
        "doubleOrNullTupleList" })
public class DataBlockType {

    @XmlElement(required = true)
    protected RangeParametersType rangeParameters;

    protected CoordinatesType tupleList;

    @XmlList
    protected List<String> doubleOrNullTupleList;

    /**
     * Gets the value of the doubleOrNullTupleList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be
     * present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the doubleOrNullTupleList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getDoubleOrNullTupleList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     * 
     * 
     */
    public List<String> getDoubleOrNullTupleList() {
        if (doubleOrNullTupleList == null) {
            doubleOrNullTupleList = new ArrayList<String>();
        }
        return this.doubleOrNullTupleList;
    }

    /**
     * Gets the value of the rangeParameters property.
     * 
     * @return possible object is {@link RangeParametersType }
     * 
     */
    public RangeParametersType getRangeParameters() {
        return rangeParameters;
    }

    /**
     * Gets the value of the tupleList property.
     * 
     * @return possible object is {@link CoordinatesType }
     * 
     */
    public CoordinatesType getTupleList() {
        return tupleList;
    }

    /**
     * Sets the value of the rangeParameters property.
     * 
     * @param value allowed object is {@link RangeParametersType }
     * 
     */
    public void setRangeParameters(RangeParametersType value) {
        this.rangeParameters = value;
    }

    /**
     * Sets the value of the tupleList property.
     * 
     * @param value allowed object is {@link CoordinatesType }
     * 
     */
    public void setTupleList(CoordinatesType value) {
        this.tupleList = value;
    }

}
