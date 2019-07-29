package cms_b.repositories;

import java.util.List;

import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import cms_b.model.Ambito;
import cms_b.model.FAQ;

public interface FAQRepository extends CouchbaseRepository<FAQ,String>{
	@Query("#{#n1ql.selectEntity} WHERE type = 'FAQ'")
	List<FAQ> findAllFAQ();
	@Query("#{#n1ql.selectEntity} WHERE type = 'FAQ' AND docId = $docId")
	Ambito findByDocId(String docId);
	@Query("UPDATE etiquetasBucket SET available = false WHERE keyId = $keyId AND type = 'FAQ'")
	FAQ disableFAQ(String keyId);

}
