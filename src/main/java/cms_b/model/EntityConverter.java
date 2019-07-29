package cms_b.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.couchbase.client.java.document.json.JsonObject;

public class EntityConverter {

	  protected static final Logger logger = LoggerFactory.getLogger(EntityConverter.class);
	
	  public static Etiqueta covertJsonObjectToEtiqueta(JsonObject json) {
		
		Etiqueta trans = new Etiqueta();
		trans.setAvailable(json.getBoolean("available"));
		trans.setCreated(new Date(json.getLong("created")));
		trans.setDocId(json.getString("docId"));
		trans.setKeyId(json.getString("keyId"));
		trans.setId(json.getString("id"));
		trans.setLanguage(json.getString("language"));
		trans.setModified(new Date(json.getLong("modified")));
		List<Ambito> ambL = new ArrayList<Ambito>();
		for(int i = 0; i<json.getArray("pages").size();i++) {
			ambL.add(EntityConverter.covertJsonObjectToAmbito(json.getArray("pages").getObject(i)));
		}
		logger.info("Convrter finished converting this: {}",trans.toString());
		return trans;
	}
	  
	  public static Ambito covertJsonObjectToAmbito(JsonObject json) {
		 Ambito trans = new Ambito();
		trans.setAvailable(json.getBoolean("available"));
		trans.setCreated(new Date(json.getLong("created")));
		trans.setDocId(json.getString("docId"));
		trans.setKeyId(json.getString("keyId"));
		trans.setId(json.getString("id"));
		trans.setLanguage(json.getString("language"));
		trans.setModified(new Date(json.getLong("modified")));
		return trans;
	  }
}
