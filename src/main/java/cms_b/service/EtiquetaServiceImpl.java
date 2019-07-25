package cms_b.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;

import cms_b.controller.WebController;
import cms_b.exception.APIException;
import cms_b.exception.ErrorType;
import cms_b.model.Etiqueta;
import cms_b.repositories.EtiquetaRepository;




@Service
public class EtiquetaServiceImpl implements EtiquetaService{

	@Autowired
	EtiquetaRepository repo;

	final ObjectMapper objectmapper = new ObjectMapper();
	
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
		etiqueta.setLastModifiedDate(new Date());
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
	public List<Etiqueta> findAllAmbitos() {
		// TODO Auto-generated method stub
		return repo.findAllAmbitos();
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
	public List<Etiqueta> findByAmbitos(List<String> ambitoList) {
		// TODO Auto-generated method stub
		
		List<Etiqueta> etl = null;
		try {
		String arr = objectmapper.writeValueAsString(ambitoList);
		etl = repo.findByAmbitos(arr);
		}catch(Exception e) {
			logger.info("Error while retrieving etiquetas with ambitos:{}",ambitoList.toString());
		}
		return etl;
	}


}
