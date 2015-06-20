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
