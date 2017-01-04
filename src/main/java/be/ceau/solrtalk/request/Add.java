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
package be.ceau.solrtalk.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import be.ceau.solrtalk.model.Doc;

@XmlRootElement(name = "add")
@XmlAccessorType(XmlAccessType.FIELD)
public class Add implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 20130808L;

	@XmlElement(name="doc")
	private List<Doc> docs;

	public Add() {}
	public Add(Doc doc) {
		this.docs = new ArrayList<Doc>();
		docs.add(doc);
	}
	
	/**
	 * @return the List of Doc objects contained in this object, or an empty list. Does not return <code>null</code>
	 */
	public List<Doc> getDocs() {
		if (docs == null) {
			return Collections.emptyList();
		} else {
			return docs;
		}
	}

	public void setDocs(List<Doc> docs) {
		this.docs = docs;
	}

	public void addDoc(Doc doc) {
		if (docs == null) {
			docs = new ArrayList<Doc>();
		}
		docs.add(doc);
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("<add>");
		s.append("\n");
		for (Doc d : getDocs()) {
			s.append("\t");
			s.append(d);
			s.append("\n");
		}
		s.append("</add>");
		return s.toString();
	}

}
