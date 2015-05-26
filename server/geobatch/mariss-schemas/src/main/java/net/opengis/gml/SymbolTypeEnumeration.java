//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.13 at 10:49:44 AM CEST 
//

package net.opengis.gml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for SymbolTypeEnumeration.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="SymbolTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="svg"/>
 *     &lt;enumeration value="xpath"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SymbolTypeEnumeration")
@XmlEnum
public enum SymbolTypeEnumeration {

    @XmlEnumValue("svg")
    SVG("svg"), @XmlEnumValue("xpath")
    XPATH("xpath"), @XmlEnumValue("other")
    OTHER("other");
    public static SymbolTypeEnumeration fromValue(String v) {
        for (SymbolTypeEnumeration c : SymbolTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    private final String value;

    SymbolTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

}
