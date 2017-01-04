/*
	Copyright 2017 Marceau Dewilde <m@ceau.be>

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		https://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
package be.ceau.solrtalk.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import be.ceau.solrtalk.response.ResponseElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "lst")
public class ListElement extends ResponseElement {

	@XmlTransient
	private static final long serialVersionUID = 20130808L;

	@XmlElement(name = "bool", type = BooleanElement.class)
	private List<BooleanElement> booleans;
	@XmlElement(name = "date", type = DateElement.class)
	private List<DateElement> dates;
	@XmlElement(name = "int", type = IntegerElement.class)
	private List<IntegerElement> ints;
	@XmlElement(name = "long", type = LongElement.class)
	private List<LongElement> longs;
	@XmlElement(name = "str", type = StringElement.class)
	private List<StringElement> strings;
	@XmlElement(name = "lst", type = ListElement.class)
	private List<ListElement> lists;

	public ListElement() {
	}

	public List<BooleanElement> getBooleans() {
		return booleans;
	}

	public void setBooleans(List<BooleanElement> booleans) {
		this.booleans = booleans;
	}

	public List<DateElement> getDates() {
		return dates;
	}

	public void setDates(List<DateElement> dates) {
		this.dates = dates;
	}

	public List<IntegerElement> getInts() {
		return ints;
	}

	public void setInts(List<IntegerElement> ints) {
		this.ints = ints;
	}

	public List<LongElement> getLongs() {
		return longs;
	}

	public void setLongs(List<LongElement> longs) {
		this.longs = longs;
	}

	public List<StringElement> getStrings() {
		return strings;
	}

	public void setStrings(List<StringElement> strings) {
		this.strings = strings;
	}

	public List<ListElement> getLists() {
		return lists;
	}

	public void setLists(List<ListElement> lists) {
		this.lists = lists;
	}

	public BooleanElement getBooleanElement(String name) {
		if (booleans != null) {
			for (BooleanElement element : booleans) {
				if (element.getName().equals(name)) {
					return element;
				}
			}
		}
		return null;
	}

	public DateElement getDateElement(String name) {
		if (dates != null) {
			for (DateElement element : dates) {
				if (element.getName().equals(name)) {
					return element;
				}
			}
		}
		return null;
	}

	public IntegerElement getIntegerElement(String name) {
		if (ints != null) {

			for (IntegerElement element : ints) {
				if (element.getName().equals(name)) {
					return element;
				}
			}
		}
		return null;
	}

	public LongElement getLongElement(String name) {
		if (longs != null) {

			for (LongElement element : longs) {
				if (element.getName().equals(name)) {
					return element;
				}
			}
		}
		return null;
	}

	public StringElement getStringElement(String name) {
		if (strings != null) {

			for (StringElement element : strings) {
				if (element.getName().equals(name)) {
					return element;
				}
			}
		}
		return null;
	}

	public ListElement getListElement(String name) {
		if (lists != null) {
			for (ListElement element : lists) {
				if (element.getName().equals(name)) {
					return element;
				}
			}
		}
		return null;
	}

}
