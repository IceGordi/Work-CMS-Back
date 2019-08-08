package cms_b.service;

import java.util.List;

import cms_b.model.FAQ;

public interface FAQService {

	List<FAQ> findAllFAQ();

	FAQ create(FAQ etl);

	FAQ update(FAQ etl);
	
	void delete (String docId);
	
	List<FAQ> findByKeyId (String keyId);
	
	FAQ findById (String id);
	
	List<FAQ> findAllFAQByLang(String lang);

}
