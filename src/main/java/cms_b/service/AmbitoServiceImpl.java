package cms_b.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms_b.exception.APIException;
import cms_b.exception.ErrorType;
import cms_b.model.Ambito;
import cms_b.repositories.AmbitoRepository;

@Service
public class AmbitoServiceImpl implements AmbitoService{

	
	@Autowired
	AmbitoRepository ambrepo;

	@Override
	public List<Ambito> findAllAmbitos() {
		return ambrepo.findAllAmbitos();
	}

	@Override
	public Ambito create(Ambito amb) {
		Ambito a = ambrepo.findByDocId(amb.getDocId());
		if(a != null) {
			throw new APIException(ErrorType.ETIQUETA_YA_EXISTE);
		}else {
			return ambrepo.save(amb);
		}
	}

	@Override
	public Ambito update(Ambito etl) {
		etl.setModified(new Date());
		if(ambrepo.findByDocId(etl.getDocId())==null) {
			throw new APIException(ErrorType.ETIQUETA_NOT_FOUND);
		}else {
			return ambrepo.save(etl);
		}
	}

	@Override
	public Ambito disableAmbito(String keyId) {
		// TODO Auto-generated method stub
		return ambrepo.disableAmbito(keyId);
	}
	
	
}
