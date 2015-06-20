package be.ceau.solrtalk.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;

import be.ceau.solrtalk.response.ResponseElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="date")
public class DateElement extends ResponseElement {

	@XmlTransient
	private static final long serialVersionUID = 20130808L;
	
	@XmlValue
	private Date value;

	public Date getValue() {
		return new Date(value.getTime());
	}

	public void setValue(Date value) {
		this.value = new Date(value.getTime());
	}

	public DateElement(String name, Date value) {
		this.name = name;
		this.value = new Date(value.getTime());
	}
	
	public DateElement() {}
	
	@Override
	public String toString() {
		return "<date name=\"" + name + "\">" + value + "</date>";
	}

}
