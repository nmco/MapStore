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
import javax.xml.bind.annotation.XmlType;

/**
 * [complexType of] The style descriptor for a graph consisting of a number of features. Describes graph-specific style attributes.
 * 
 * <p>
 * Java class for GraphStyleType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GraphStyleType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}BaseStyleDescriptorType">
 *       &lt;sequence>
 *         &lt;element name="planar" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="directed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="grid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="minDistance" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="minAngle" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="graphType" type="{http://www.opengis.net/gml}GraphTypeType" minOccurs="0"/>
 *         &lt;element name="drawingType" type="{http://www.opengis.net/gml}DrawingTypeType" minOccurs="0"/>
 *         &lt;element name="lineType" type="{http://www.opengis.net/gml}LineTypeType" minOccurs="0"/>
 *         &lt;element name="aestheticCriteria" type="{http://www.opengis.net/gml}AesheticCriteriaType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GraphStyleType", propOrder = { "planar", "directed", "grid", "minDistance",
        "minAngle", "graphType", "drawingType", "lineType", "aestheticCriteria" })
public class GraphStyleType extends BaseStyleDescriptorType {

    protected Boolean planar;

    protected Boolean directed;

    protected Boolean grid;

    protected Double minDistance;

    protected Double minAngle;

    protected GraphTypeType graphType;

    protected DrawingTypeType drawingType;

    protected LineTypeType lineType;

    protected List<AesheticCriteriaType> aestheticCriteria;

    /**
     * Gets the value of the aestheticCriteria property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be
     * present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the aestheticCriteria property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getAestheticCriteria().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link AesheticCriteriaType }
     * 
     * 
     */
    public List<AesheticCriteriaType> getAestheticCriteria() {
        if (aestheticCriteria == null) {
            aestheticCriteria = new ArrayList<AesheticCriteriaType>();
        }
        return this.aestheticCriteria;
    }

    /**
     * Gets the value of the drawingType property.
     * 
     * @return possible object is {@link DrawingTypeType }
     * 
     */
    public DrawingTypeType getDrawingType() {
        return drawingType;
    }

    /**
     * Gets the value of the graphType property.
     * 
     * @return possible object is {@link GraphTypeType }
     * 
     */
    public GraphTypeType getGraphType() {
        return graphType;
    }

    /**
     * Gets the value of the lineType property.
     * 
     * @return possible object is {@link LineTypeType }
     * 
     */
    public LineTypeType getLineType() {
        return lineType;
    }

    /**
     * Gets the value of the minAngle property.
     * 
     * @return possible object is {@link Double }
     * 
     */
    public Double getMinAngle() {
        return minAngle;
    }

    /**
     * Gets the value of the minDistance property.
     * 
     * @return possible object is {@link Double }
     * 
     */
    public Double getMinDistance() {
        return minDistance;
    }

    /**
     * Gets the value of the directed property.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isDirected() {
        return directed;
    }

    /**
     * Gets the value of the grid property.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isGrid() {
        return grid;
    }

    /**
     * Gets the value of the planar property.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isPlanar() {
        return planar;
    }

    /**
     * Sets the value of the directed property.
     * 
     * @param value allowed object is {@link Boolean }
     * 
     */
    public void setDirected(Boolean value) {
        this.directed = value;
    }

    /**
     * Sets the value of the drawingType property.
     * 
     * @param value allowed object is {@link DrawingTypeType }
     * 
     */
    public void setDrawingType(DrawingTypeType value) {
        this.drawingType = value;
    }

    /**
     * Sets the value of the graphType property.
     * 
     * @param value allowed object is {@link GraphTypeType }
     * 
     */
    public void setGraphType(GraphTypeType value) {
        this.graphType = value;
    }

    /**
     * Sets the value of the grid property.
     * 
     * @param value allowed object is {@link Boolean }
     * 
     */
    public void setGrid(Boolean value) {
        this.grid = value;
    }

    /**
     * Sets the value of the lineType property.
     * 
     * @param value allowed object is {@link LineTypeType }
     * 
     */
    public void setLineType(LineTypeType value) {
        this.lineType = value;
    }

    /**
     * Sets the value of the minAngle property.
     * 
     * @param value allowed object is {@link Double }
     * 
     */
    public void setMinAngle(Double value) {
        this.minAngle = value;
    }

    /**
     * Sets the value of the minDistance property.
     * 
     * @param value allowed object is {@link Double }
     * 
     */
    public void setMinDistance(Double value) {
        this.minDistance = value;
    }

    /**
     * Sets the value of the planar property.
     * 
     * @param value allowed object is {@link Boolean }
     * 
     */
    public void setPlanar(Boolean value) {
        this.planar = value;
    }

}
