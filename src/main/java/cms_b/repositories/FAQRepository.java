package cms_b.repositories;

import java.util.List;

import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import cms_b.model.Ambito;
import cms_b.model.FAQ;

public interface FAQRepository extends CouchbaseRepository<FAQ,String>{
	@Query("#{#n1ql.selectEntity} WHERE type = 'faq'")
	List<FAQ> findAllFAQ();
	@Query("#{#n1ql.selectEntity} WHERE type = 'faq' AND docId = $docId")
	FAQ findByDocId(String docId);
	
	FAQ deleteByKeyId (String keyId);
}
