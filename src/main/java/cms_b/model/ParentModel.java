package cms_b.model;
import javax.persistence.*;

import com.couchbase.client.java.repository.annotation.Field;

import java.util.Date;
@MappedSuperclass
public class ParentModel {
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

	public ParentModel() {}
	

	public boolean isAvailable() {
		return available;
	}

	public Date getCreated() {
		return created;
	}

	public Date getModified() {
		return modified;
	}

	

	public String getKeyId() {
		return keyId;
	}


	public String getId() {
		return id;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}


	public void setId(String id) {
		this.id = id;
	}

	
}
