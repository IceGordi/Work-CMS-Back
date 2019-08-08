package cms_b.repositories;

import java.util.List;

import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.repository.query.Param;

import cms_b.model.Etiqueta;
import cms_b.model.FAQ;

public interface FAQRepository extends CouchbaseRepository<FAQ,String>{
	@Query("#{#n1ql.selectEntity} WHERE type = 'faq'")
	List<FAQ> findAllFAQ();
	@Query("#{#n1ql.selectEntity} WHERE type = 'faq' AND docId = $docId")
	FAQ findByDocId(String docId);
	@Query("#{#n1ql.selectEntity} WHERE type = 'faq' AND  keyId = $keyId")
	List<FAQ> findByKeyId(String keyId);
	
	@Query("#{#n1ql.selectEntity} WHERE type = 'faq' AND  id = $id")
	FAQ findByMyId(String id);
	@Query("#{#n1ql.selectEntity} WHERE type = 'faq' AND language = $lang")
	List<FAQ> findAllFAQByLang(String lang);
}
