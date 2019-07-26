package cms_b.model;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.document.json.JsonObject;

import cms_b.controller.WebController;

public class EtiquetaConverter {

	  protected static final Logger logger = LoggerFactory.getLogger(EtiquetaConverter.class);
	
	public static Etiqueta covertJsonObjectToEtiqueta(JsonObject json) {
		Etiqueta trans = new Etiqueta(json.getBoolean("available"),
									  json.getString("content"),
									  new Date(json.getLong("createdDate")),
									  json.getString("docId"),
									  json.getString("keyId"),
									  json.getString("id"),
									  json.getString("language"),
									  new Date(json.getLong("lastModifiedDate")),
									  json.getString("tipo"),
									  convertJsonArrayToArrayOfStrings( json.getArray("pages"))
				);
		logger.info("Convrter finished converting this: {}",trans.toString());
		return trans;
	}
	public static List<String> convertJsonArrayToArrayOfStrings(JsonArray jarray) {
		if(jarray == null) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		for(int i=0;i<jarray.size();i++) {
			list.add(jarray.getString(i));
		}
		return list;
	}
}
