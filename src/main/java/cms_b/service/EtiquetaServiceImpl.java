package cms_b.service;

import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cms_b.exception.APIException;
import cms_b.exception.ErrorType;
import cms_b.model.Etiqueta;
import cms_b.repositories.EtiquetaRepository;




@Service
public class EtiquetaServiceImpl implements EtiquetaService{

	@Autowired
	EtiquetaRepository repo;

	
	protected static final Logger logger = LoggerFactory.getLogger(EtiquetaServiceImpl.class);
	
	public Etiqueta create(Etiqueta etiqueta) {
		// TODO Auto-generated method stub
		Etiqueta e = repo.findByDocId(etiqueta.getDocId());
		if(e != null) {
			throw new APIException(ErrorType.ETIQUETA_YA_EXISTE);
		}else {
			return repo.save(etiqueta);
		}	
	}

	@Override
	public Etiqueta update(Etiqueta etiqueta) {
		// TODO Auto-generated method stub
		etiqueta.setModified(new Date());
		if(repo.findByDocId(etiqueta.getDocId())==null) {
			throw new APIException(ErrorType.ETIQUETA_NOT_FOUND);
		}else {
			return repo.save(etiqueta);
		}
	}

	@Override
	public List<Etiqueta> delete(String keyId) {
		// TODO Auto-generated method stub
		List<Etiqueta> e = repo.findByKeyId(keyId);
		if(e==null) {
			throw new APIException(ErrorType.ETIQUETA_NOT_FOUND);
		}else {
			
			return repo.deleteByKeyId(keyId);	
		}		
	}

	@Override
	public List<Etiqueta> findAllEtiquetas() {
		// TODO Auto-generated method stub
		return repo.findAllEtiquetas();
	}

	@Override
	public List<Etiqueta> findById(String id) {
		// TODO Auto-generated method stub
		return repo.findById1(id);
	}

	@Override
	public List<Etiqueta> findByKeyId(String keyId) {
		// TODO Auto-generated method stub
		return repo.findByKeyId(keyId);
	}

	@Override
	public Etiqueta findByDocId(String docId) {
		// TODO Auto-generated method stub
		return repo.findByDocId(docId);
	}

	@Override
	public List<Etiqueta> findByAmbitos(List<String> ambitoList) throws Exception {
		// TODO Auto-generated method stub
		return repo.fufu(ambitoList);
	}

	@Override
	public List<Etiqueta> disableEtiqueta(String keyId) {
		// TODO Auto-generated method stub
		return repo.disableEtiqueta(keyId);
	}

	@Override
	public List<Etiqueta> findAllEtiquetasByLang(String lang) {
		// TODO Auto-generated method stub
		return repo.findAllEtiquetasByLang(lang);
	}


}
