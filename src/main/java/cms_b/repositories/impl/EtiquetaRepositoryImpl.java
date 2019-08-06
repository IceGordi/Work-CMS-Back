package cms_b.repositories.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;


import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.AsyncN1qlQueryResult;
import com.couchbase.client.java.query.N1qlParams;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.consistency.ScanConsistency;

import cms_b.model.*;
import cms_b.repositories.EtiquetaRepositoryCustom;
public class EtiquetaRepositoryImpl implements EtiquetaRepositoryCustom{
	
	AbstractCouchbaseConfiguration acc;
	@Autowired
	private Bucket cbBucket;

	public List<Etiqueta> fufu(List<String> ambitoList) throws Exception{
		N1qlParams params = N1qlParams.build().adhoc(false).consistency(ScanConsistency.STATEMENT_PLUS);
		JsonObject values = JsonObject.create();
		String queryEnd = "";
		int index = 0;
		for(String s:ambitoList) {
			values.put("s"+index,s);
			queryEnd+=" and (any ambito in pages satisfies ambito.keyId = $s"+index +" end) ";
			index++;
		}
		
		//select * from etiquetasBucket where
		//(any ambito in pages satisfies ambito.keyId = "sad" end) and 
		//(any ambito in pages satisfies ambito.keyId = "sadaf" end) and 
		//(any ambito in pages satisfies ambito.keyId = "asdf" end)
		String queryString = "select meta().id, * from etiquetasBucket where language = 'es' and type = 'etiqueta'";
		N1qlQuery query = N1qlQuery.parameterized(queryString, values , params);
		
		List<Etiqueta> etl = new ArrayList<Etiqueta>();
		etl = cbBucket.async().query(query)
				.flatMap(result -> result.rows()) //browse the resulting rows
			    .map(row -> EntityConverter.covertJsonObjectToEtiqueta(row.value().getObject("etiquetasBucket"))) //extract the value of rows that were obtained 
		        .toList()
		        .toBlocking()
		        .single();		
		if(etl.isEmpty()) {
			return null;
		} else {
			return etl;
		}
	}
	}