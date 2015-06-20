package be.ceau.solrtalk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import be.ceau.solrtalk.response.ResponseElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="bool")
@XmlRootElement(name="bool")
public class BooleanElement extends ResponseElement {

	@XmlTransient
	private static final long serialVersionUID = 20130808L;

	@XmlValue
	private boolean value;

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public BooleanElement(String name, boolean value) {
		this.name = name;
		this.value = value;
	}

	public BooleanElement() {}
	
	@Override
	public String toString() {
		return "<bool name=\"" + name + "\">" + value + "</bool>";
	}

}
