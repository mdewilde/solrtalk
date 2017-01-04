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

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang3.StringEscapeUtils;

@XmlAccessorType(XmlAccessType.FIELD)
public class Doc implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 20130808L;

	@XmlElement(name = "field")
	private List<Field> fields = new ArrayList<Field>();

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
	public void addField(Field field) {
		if (fields == null) {
			fields = new ArrayList<Field>();
		}
		fields.add(field);
	}
	
	public void addFields(List<Field> fields) {
		if (this.fields == null) {
			this.fields = new ArrayList<Field>();
		}
		for (Field field : fields) {
			this.fields.add(field);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("<doc>");
		s.append("\n");
		for (Field f : fields) {
			s.append("\t");
			s.append(f);
			s.append("\n");
		}
		s.append("</doc>");
		return s.toString();
	}

	// utility method used in creation of solr upload
	@XmlTransient
	public void setId(int hash) {		
		addField(new Field(Attribute.ID, StringEscapeUtils.escapeXml10(String.valueOf(hash))));
	}
	// utility method used in creation of solr upload
	@XmlTransient
	public void setMimeType(String contenttype) {
		addField(new Field(Attribute.MIMETYPE, StringEscapeUtils.escapeXml10(contenttype)));
	}
	// utility method used in creation of solr upload
	@XmlTransient
	public void setTitle(String title) {		
		addField(new Field(Attribute.TITLE, StringEscapeUtils.escapeXml10(title)));
	}
	// utility method used in creation of solr upload
	@XmlTransient
	public void setURI(URI uri) {		
		addField(new Field(Attribute.URL, StringEscapeUtils.escapeXml10(uri.toASCIIString())));
	}
	// utility method used in creation of solr upload
	@XmlTransient
	public void setSummary(String summary) {		
		addField(new Field(Attribute.SUMMARY, StringEscapeUtils.escapeXml10(summary))); // all headingtags
	}
	// utility method used in creation of solr upload
	@XmlTransient
	public void setFilename(String filename) {		
		addField(new Field(Attribute.FILENAME, StringEscapeUtils.escapeXml10(filename)));
	}
	// utility method used in creation of solr upload
	@XmlTransient
	public void setContent(String content) {
		addField(new Field(Attribute.CONTENT, StringEscapeUtils.escapeXml10(content)));
	}

}
