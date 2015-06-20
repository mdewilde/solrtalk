package be.ceau.solrtalk.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;

import org.apache.commons.lang3.StringEscapeUtils;

@XmlAccessorType(XmlAccessType.FIELD)
public class Field implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 20130808L;
	
	@XmlValue
	private String value;

	@XmlAttribute
	protected String name;

	public Field() {}
	
	public Field(String name, String value) {
		this.name = name;
		setValue(value);
	}
	
	public Field(Attribute attribute, String value) {
		this.name = attribute.toString();
		setValue(value);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = StringEscapeUtils.escapeXml10(value);
	}

	@Override
	public String toString() {
		return "<field name=\""+name+"\">"+value+"</field>";
	}

}
