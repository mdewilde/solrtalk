package be.ceau.solrtalk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;

import be.ceau.solrtalk.response.ResponseElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="long")
public class LongElement extends ResponseElement {

	@XmlTransient
	private static final long serialVersionUID = 20130808L;
		
	@XmlValue
	private long value;

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public LongElement(String name, long value) {
		this.name = name;
		this.value = value;
	}
	
	public LongElement() {}
	
	@Override
	public String toString() {
		return "<long name=\"" + name + "\">" + value + "</long>";
	}

}
