package cms_b.model;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.couchbase.core.mapping.Document;
import com.couchbase.client.java.repository.annotation.Field;

@Document
public class Etiqueta extends ParentModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Field
	private String type = "Etiqueta";
	@Field
	private List<Ambito> pages;
	
	
	public Etiqueta() {
		super();
	}
	
	public String getType() {
		return type;
	}

	public List<Ambito> getPages() {
		return pages;
	}


	public void setPages(List<Ambito> pages) {
		this.pages = pages;
	}
	
	
}
