package cms_b.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms_b.exception.APIException;
import cms_b.exception.ErrorType;
import cms_b.model.FAQ;
import cms_b.repositories.FAQRepository;

@Service
public class FAQServiceImpl implements FAQService{

	@Autowired
	FAQRepository faqrepo;

	@Override
	public List<FAQ> findAllFAQ() {
		return faqrepo.findAllFAQ();
	}

	@Override
	public FAQ create(FAQ faq) {
		FAQ f = faqrepo.findByDocId(faq.getDocId());
		if(f != null) {
			throw new APIException(ErrorType.ETIQUETA_YA_EXISTE);
		}else {
			return faqrepo.save(faq);
		}
	}

	@Override
	public FAQ update(FAQ etl) {
		etl.setModified(new Date());
		if(faqrepo.findByMyId(etl.getId())==null) {
			throw new APIException(ErrorType.ETIQUETA_NOT_FOUND);
		}else {
			return faqrepo.save(etl);
		}
	}

	@Override
	public void delete(String docId) {
		 faqrepo.deleteById(docId);
	}

	@Override
	public List<FAQ> findByKeyId(String keyId) {
		// TODO Auto-generated method stub
		return faqrepo.findByKeyId(keyId);
	}

	@Override
	public FAQ findById(String id) {
		// TODO Auto-generated method stub
		return faqrepo.findByMyId(id);
	}

	@Override
	public List<FAQ> findAllFAQByLang(String lang) {
		// TODO Auto-generated method stub
		return faqrepo.findAllFAQByLang(lang);
	}
}
