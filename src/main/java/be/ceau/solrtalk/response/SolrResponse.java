package be.ceau.solrtalk.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import be.ceau.solrtalk.model.Attribute;
import be.ceau.solrtalk.model.DateElement;
import be.ceau.solrtalk.model.IntegerElement;
import be.ceau.solrtalk.model.ListElement;
import be.ceau.solrtalk.model.LongElement;
import be.ceau.solrtalk.model.StringElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "response")
public class SolrResponse {

	@XmlElement(name = "lst", type = ListElement.class)
	private List<ListElement> response;

	public SolrResponse() {}

	public List<ListElement> getResponse() {
		return response;
	}

	public void setResponse(List<ListElement> response) {
		this.response = response;
	}

	public long getSizeInBytes(String coreName) {
		ListElement list = getIndexStatus(coreName);
		if (list != null) {
			LongElement element = list.getLongElement(Attribute.SIZE_IN_BYTES.toString());
			if (element != null) {
				return element.getValue();
			}
		}
		return -1;
	}

	public int getNumDocs(String coreName) {
		ListElement list = getIndexStatus(coreName);
		if (list != null) {
			IntegerElement element = list.getIntegerElement(Attribute.NUM_DOCS.toString());
			if (element != null) {
				return element.getValue();
			}
		}
		return -1;
	}

	public Date getLastModifiedDate(String coreName) {
		ListElement list = getIndexStatus(coreName);
		if (list != null) {
			DateElement element = list.getDateElement(Attribute.LAST_MODIFIED.toString());
			if (element != null) {
				return element.getValue();
			}
		}
		return null;
	}
	
	private ListElement getIndexStatus(String coreName) {
		ListElement coreStatus = getCoreStatus(coreName);
		if (coreStatus != null) {
			return coreStatus.getListElement(Attribute.INDEX.toString());
		} else {
			return null;
		}
	}

	private ListElement getCoreStatus(String coreName) {
		ListElement coreStatusList = getCoreStatusList();
		if (coreStatusList != null) {
			return coreStatusList.getListElement(coreName);
		} else {
			return null;
		}
	}

	public ListElement getCoreStatusList() {
		if (response != null) {
			for (ListElement list : response) {
				if (list.getName().equals(Attribute.STATUS.toString())) {
					return list;
				}
			}
		}
		return null;
	}

	/**
	 * @return an ArrayList containing the name of every core. The list may be empty. It will not be null.
	 */
	public List<String> getCoreNameList() {
		List<String> result = new ArrayList<String>();
		ListElement statusListElement = getCoreStatusList();
		if (statusListElement != null) {
			for (ListElement coreListElement : statusListElement.getLists()) {
				if (coreListElement != null) {
					result.add(coreListElement.getName());
				}
			}
		}
		return result;
	}
	
	/**
	 * @return the base directory containing the configurations and data directory for the various solr cores
	 */
	public String getContentBaseDir() {
		ListElement csl = getCoreStatusList();
		if (csl != null) {
			if (csl.getLists() != null && !csl.getLists().isEmpty()) {
				StringElement se = csl.getLists().get(0).getStringElement(Attribute.INSTANCE_DIR.toString());
				if (se != null) {
					String dir = se.getValue();
					if (dir != null) {
						return dir.substring(0, dir.substring(0,dir.length()-2).lastIndexOf('/')+1);
					}
				}
			}
		}
		return null;
	}
	
	public ListElement getResponseHeader() {
		List<ListElement> content = getResponse();
		if (response != null) {
			for (ListElement e : content) {
				if (e.getName().equals(Attribute.RESPONSE_HEADER.toString())) {
					return e;
				}
			}
		}
		return null;
	}
	
	/**
	 * @return the status in the response, as returned in the responseHeader, or -1 in case of missing data
	 */
	public int getResponseStatus() {
		ListElement header = getResponseHeader();
		if (header != null) {
			List<IntegerElement> list = header.getInts();
			if (list != null) {
				for (IntegerElement e : list) {
					if (e.getName().equals(Attribute.STATUS.toString())) {
						return e.getValue();
					}
				}
			}
		}
		return -1;
	}
}
