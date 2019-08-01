package cms_b.model;

import java.util.Date;



import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
@Document
public class Ambito {

	@Field
	public boolean available;
	@Field
	public Date created;
	@Field
	public Date modified;
	@Field
	public String keyId;
	@Field
	public String id;

	
	
	
	@Field
	private String type = "ambito";
	@Field
	private String language = "es";
	@Field
	private String content;
	@Field
	@Id
	public String docId;

	public Ambito () {}
	
	
	
	public Ambito(boolean available, Date created, Date modified, String keyId, String id, String type, String language,
			String content, String docId) {
		this.available = available;
		this.created = created;
		this.modified = modified;
		this.keyId = keyId;
		this.id = id;
		this.type = type;
		this.language = language;
		this.content = content;
		this.docId = docId;
	}



	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public void setType(String type) {
		this.type = type;
	}


	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getKeyId() {
		return keyId;
	}
	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Date getModified() {
		return modified;	
	}


	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getDocId() {
		return docId;
	}



	public void setDocId(String docId) {
		this.docId = docId;
	}



	public String getType() {
		return type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}	
