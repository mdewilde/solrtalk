package be.ceau.solrtalk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;

import org.apache.commons.lang3.StringEscapeUtils;

import be.ceau.solrtalk.response.ResponseElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="str")
public class StringElement extends ResponseElement {

	@XmlTransient
	private static final long serialVersionUID = 20130808L;
	
	@XmlValue
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = StringEscapeUtils.escapeXml10(value);
	}

	public StringElement(String name, String value) {
		this.name = name;
		setValue(value);
	}
	
	public StringElement() {}
	
	@Override
	public String toString() {
		return "<str name=\"" + name + "\">" + value + "</str>";
	}

}
