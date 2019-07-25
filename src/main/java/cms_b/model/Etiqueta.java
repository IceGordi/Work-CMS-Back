package cms_b.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.IdPrefix;
import org.springframework.data.couchbase.core.mapping.id.IdSuffix;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;


@Document
public class Etiqueta implements Serializable{
	
private static final long serialVersionUID = -3009580615528757519L;

	@Field
	private boolean available;
	@Field
	private String content;
	@Field
	private Date createdDate;
	@Id
	@Field
	private String docId;
	@Field
	private String keyId;
	@Field
	private String id;
	@Field
	private String language;
	@Field
	private Date lastModifiedDate;
	@Field
	private String tipo;
	@Field
	private List<String> pages;
	
	public Etiqueta() {
		this.createdDate = new Date();
	}
	
	public String getId() {
		return id;
	}

	public boolean isAvailable() {
		return available;
	}
	public String getContent() {
		return content;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public String getDocId() {
		return docId;
	}
	public String getKeyId() {
		return keyId;
	}
	public String getLanguage() {
		return language;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public String getTipo() {
		return tipo;
	}
	public List<String> getPages() {
		return pages;
	}
	public void setAvailable(boolean available) {
		this.available = available;
		this.lastModifiedDate = new Date();
	}
	public void setContent(String content) {
		this.content = content;
		this.lastModifiedDate = new Date();
	}
	public void setLanguage(String language) {
		this.language = language;
		this.lastModifiedDate = new Date();
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		this.lastModifiedDate = new Date();
		}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = new Date();
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
		this.lastModifiedDate = new Date();
	}
	public void setPages(List<String> pages) {
		this.pages = pages;
		this.lastModifiedDate = new Date();
	}	
	
	public static String getKeyIdFromLangKeyIdType(String tipo, String keyId, String lang) {
		return tipo +"::"+ keyId +"::"+ lang;
	}
	public void fixAllFields() {
		this.docId = this.tipo +"::"+ this.keyId +"::"+ this.language;
		this.id = this.keyId +"::"+ this.language;
		if(this.createdDate == null)
		this.createdDate = new Date();
		this.lastModifiedDate = new Date();
	}
}
