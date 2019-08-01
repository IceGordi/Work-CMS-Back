package cms_b.model;

import java.util.Date;
import java.util.List;


import org.springframework.data.couchbase.core.mapping.Document;
import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document
public class Etiqueta {
	
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
	private String type = "etiqueta";
	@Field
	private String content;
	@Field
	private List<Ambito> pages;
	@Field
	public String language;
	@Field
	@Id
	public String docId;
	
	public Etiqueta() {
		super();
	}
	
	
	
	public Etiqueta(boolean available, Date created, Date modified, String keyId, String id, String type,
			String content, List<Ambito> pages, String language, String docId) {
		this.available = available;
		this.created = created;
		this.modified = modified;
		this.keyId = keyId;
		this.id = id;
		this.type = type;
		this.content = content;
		this.pages = pages;
		this.language = language;
		this.docId = docId;
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

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
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

	public void setType(String type) {
		this.type = type;
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

	public List<Ambito> getPages() {
		return pages;
	}


	public void setPages(List<Ambito> pages) {
		this.pages = pages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
