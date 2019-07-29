package cms_b.model;

import java.io.Serializable;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
@Document
public class Ambito extends ParentModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Field
	private String type = "Ambito";

	public Ambito () {}
	
	public String getType() {
		return type;
	}
}	
