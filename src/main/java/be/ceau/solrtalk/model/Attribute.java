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

/**
 * Possible attributes of XML elements in Solr requests and responses.
 */
public enum Attribute {

	CONFIG("config"),
	CONTENT("content"),
	CURRENT("current"),
	DATA_DIR("dataDir"),
	DELETED_DOCS("deletedDocs"),
	DIRECTORY("directory"),
	FILENAME("filename"),
	HAS_DELETIONS("hasDeletions"),
	ID("id"),
	INDEX("index"),
	INIT_FAILURES("initFailures"),
	INSTANCE_DIR("instanceDir"),
	IS_DEFAULT_CORE("isDefaultCore"),
	LAST_MODIFIED("lastModified"),
	MAX_DOCS("maxDocs"),
	MIMETYPE("mimetype"),
	NAME("name"),
	NUM_DOCS("numDocs"),
	QTIME("QTime"),
	RESPONSE_HEADER("responseHeader"),
	SCHEMA("schema"),
	SEGMENT_COUNT("segmentCount"),
	SIZE_IN_BYTES("sizeInBytes"),
	SIZE("size"),
	START_TIME("startTime"),
	STATUS("status"),
	SUMMARY("summary"),
	TITLE("title"),
	UPTIME("uptime"),
	URL("url"),
	USER_DATA("userData"),
	VERSION("version");
	
	private String attribute;
	
	private Attribute(String attribute) {
		this.attribute = attribute;
	}
	
	@Override
	public String toString() {
		return attribute;
	}
	
}
