/*
	Copyright 2015 Marceau Dewilde <m@ceau.be>

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
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
