package cms_b.service;

import java.util.List;

import cms_b.model.FAQ;

public interface FAQService {

	List<FAQ> findAllFAQ();

	FAQ create(FAQ etl);

	FAQ update(FAQ etl);

	FAQ disableFAQ(String keyId);

}
