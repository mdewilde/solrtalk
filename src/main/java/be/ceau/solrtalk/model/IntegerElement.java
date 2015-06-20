package be.ceau.solrtalk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import be.ceau.solrtalk.response.ResponseElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="int")
//@XmlRootElement(name="int")
public class IntegerElement extends ResponseElement {

	@XmlTransient
	private static final long serialVersionUID = 20130808L;
	
	@XmlValue
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public IntegerElement(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public IntegerElement() {}

	@Override
	public String toString() {
		return "<int name=\"" + name + "\">" + value + "</int>";
	}

	
}
