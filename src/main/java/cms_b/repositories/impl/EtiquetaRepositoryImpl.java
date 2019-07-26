package cms_b.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.repository.query.Param;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.AsyncN1qlQueryResult;
import com.couchbase.client.java.query.AsyncN1qlQueryRow;
import com.couchbase.client.java.query.N1qlParams;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.consistency.ScanConsistency;

import cms_b.model.*;
import cms_b.repositories.EtiquetaRepositoryCustom;
import rx.Observable;

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
			queryEnd+=" and $s"+index+" in pages";
			index++;
		}
		String queryString = "select * from etiquetasBucket where type='cms_b.model.Etiqueta'" + queryEnd;
		String queryTest = "select * from etiquetasBucket where type='cms_b.model.Etiqueta'";
		N1qlQuery query = N1qlQuery.parameterized(queryTest, values , params);
		
		List<Etiqueta> etl = new ArrayList<Etiqueta>();
		
		etl = cbBucket
				.async()
					.query(query)
					.flatMap(
						result -> result.rows())
						.map(row -> EtiquetaConverter.covertJsonObjectToEtiqueta(row.value().getObject("etiquetasBucket")))
							.toList();

		return etl;
	}
}
